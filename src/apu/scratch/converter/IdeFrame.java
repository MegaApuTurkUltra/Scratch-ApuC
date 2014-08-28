/**
 * 
 */
package apu.scratch.converter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import apu.scratch.converter.CodePanel.Tab;
import apu.scratch.converter.ScratchConverter.CompileResult;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;

/**
 * @author MegaApuTurkUltra
 * 
 */
public class IdeFrame extends JFrame {

	private static final long serialVersionUID = -7694777067218375044L;
	private JPanel contentPane;
	public JPanel sbRender;
	JLabel lblFile;

	public static IdeFrame instance;

	CodePanel panel;

	public SaveCallback callback = new SaveCallback() {
		@Override
		public void codeSaved(String code, boolean save) {
		}
	};

	public static void launch() {
		try {
			UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			instance = new IdeFrame();
			instance.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public IdeFrame() {
		setTitle("ApuC IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JSplitPane mainSplit = new JSplitPane();
		mainSplit.setResizeWeight(0.7);
		contentPane.add(mainSplit, BorderLayout.CENTER);

		JPanel leftSplit = new JPanel(new BorderLayout());
		mainSplit.setLeftComponent(leftSplit);

		JPanel header = new JPanel();
		FlowLayout flowLayout = (FlowLayout) header.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		leftSplit.add(header, BorderLayout.NORTH);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.addNewTab();
			}
		});
		header.add(btnNew);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				Tab tab = panel.getCurrentlySelectedTab();
//				if (tab == null)
//					return;
//				DefaultStyledDocument doc = tab.doc;
//				String code;
//				try {
//					code = doc.getText(0, doc.getEndPosition().getOffset());
//				} catch (BadLocationException e1) {
//					e1.printStackTrace();
//					return;
//				}
//				if (!code.trim().isEmpty()) {
//					if (JOptionPane
//							.showConfirmDialog(
//									IdeFrame.this,
//									"You have code in the editor. If you have "
//											+ "not saved it, opening a new file will cause"
//											+ " it to be lost. Continue?",
//									"Continue?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
//						return;
//				}
				File f = SavePanel.showDialog(true, false);
				if (f != null && f.exists()) {
					Tab tab = panel.addNewTab();
					DefaultStyledDocument doc = tab.doc;
					tab.saveFile = f;
					tab.title.setText(f.getName());
					lblFile.setText("File: " + f.getName());
					String newCode = Sprite2IO.readFile(f);
					if (newCode != null) {
						try {
							doc.replace(0,
									doc.getEndPosition().getOffset() - 1,
									newCode, tab.defaultStyle);
							tab.checkCode(false);
						} catch (BadLocationException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		header.add(btnOpen);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tab tab = panel.getCurrentlySelectedTab();
				if (tab == null)
					return;
				tab.checkCode(true);
			}
		});
		header.add(btnSave);

		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tab tab = panel.getCurrentlySelectedTab();
				if (tab == null)
					return;
				DefaultStyledDocument doc = tab.doc;
				String code;
				try {
					code = doc.getText(0, doc.getEndPosition().getOffset());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
					return;
				}

				if (code.trim().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									IdeFrame.this,
									"You don't have any code to export! Try writing some first.",
									"Export", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				CompileResult result;
				try {
					result = ScratchConverter.compile(code);
					if (result.errors.size() > 0) {
						throw new Exception("Errors in code");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane
							.showMessageDialog(
									IdeFrame.this,
									"You have errors in your code! Please fix them first.",
									"Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}

				File f = SavePanel.showDialog(false, true);
				if (f != null) {
					Sprite2IO.writeToZip(f, result.scripts);
				}
			}
		});
		header.add(btnExport);

		lblFile = new JLabel("File: ");
		header.add(lblFile);

		panel = new CodePanel();
		leftSplit.add(panel, BorderLayout.CENTER);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainSplit.setRightComponent(tabbedPane);

		sbRender = new JPanel();
		tabbedPane.addTab("Scratchblocks2 Preview", null, sbRender, null);
	}

	static interface SaveCallback {
		public void codeSaved(String code, boolean save);
	}
}
