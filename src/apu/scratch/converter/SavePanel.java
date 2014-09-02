/**
 * 
 */
package apu.scratch.converter;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

/**
 * @author MegaApuTurkUltra
 */
public class SavePanel extends JPanel {
	private static final long serialVersionUID = 599784585392483986L;
	private JFileChooser chooser;
	public boolean save = false;
	public boolean apuc = true;
	public boolean sb2 = false;

	public File selected = null;
	JDialog owner;

	public SavePanel(boolean sb2, boolean save, boolean apuc, JDialog owner) {
		this.owner = owner;
		this.sb2 = sb2;
		this.save = save;
		this.apuc = apuc;
		setLayout(new BorderLayout(0, 0));

		chooser = new JFileChooser();
		FileFilter ff = new FileFilter() {
			@Override
			public String getDescription() {
				return SavePanel.this.sb2 ? "Sb2 files"
						: (SavePanel.this.apuc ? "ApuC files" : "Sprite2 files");
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory())
					return true;
				return SavePanel.this.sb2 ? (f.getName().endsWith(".sb2") || f
						.getName().endsWith(".zip")) : (SavePanel.this.apuc ? f
						.getName().endsWith(".apuc") : f.getName().endsWith(
						".sprite2")
						|| f.getName().endsWith(".zip"));
			}
		};
		chooser.addChoosableFileFilter(ff);
		chooser.setFileFilter(ff);
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileHidingEnabled(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setApproveButtonText(save ? "Save" : "Open");
		chooser.setApproveButtonToolTipText(save ? "Save to the selected file"
				: "Load the selected file");
		chooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
					performAction();
				} else {
					SavePanel.this.owner.setVisible(false);
				}
			}
		});
		add(chooser, BorderLayout.CENTER);
	}

	protected void performAction() {
		if (save && chooser.getSelectedFile().exists()) {
			if (JOptionPane.showConfirmDialog(this,
					"This file already exists! Do you want to overwrite "
							+ (apuc ? "it" : "its JSON code") + "?",
					"File exists", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
		}
		if (!save && !chooser.getSelectedFile().exists()) {
			JOptionPane.showMessageDialog(this,
					"That file doesn't exist. Select another file.", "",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		selected = chooser.getSelectedFile();
		if (apuc && !selected.getName().contains(".")) {
			selected = new File(selected.getAbsolutePath() + ".apuc");
		} else if (!apuc && !selected.getName().contains(".")) {
			selected = new File(selected.getAbsolutePath() + ".sprite2");
		}
		owner.setVisible(false);
	}

	public static File showDialog(boolean sb2, boolean apuc, boolean save) {
		JDialog d = new JDialog();
		d.setModalityType(ModalityType.APPLICATION_MODAL);
		SavePanel p = new SavePanel(sb2, save, apuc, d);
		d.setContentPane(new JPanel(new BorderLayout()));
		d.getContentPane().add(p, BorderLayout.CENTER);
		d.pack();
		d.setLocationRelativeTo(p);
		d.setVisible(true);
		return p.selected;
	}
}
