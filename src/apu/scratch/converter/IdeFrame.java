/**
 * 
 */
package apu.scratch.converter;

import static apu.antlr.clike.ScratchCLikeLexer.ARRAY_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.ATOMIC_METHOD_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_AND;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_EQUALS;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_GT;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_GTE;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_LT;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_LTE;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_NEQUALS;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_NOT;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_OR;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_TRUE;
import static apu.antlr.clike.ScratchCLikeLexer.BlockComment;
import static apu.antlr.clike.ScratchCLikeLexer.ELSE_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.FOR_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.IDENTIFIER;
import static apu.antlr.clike.ScratchCLikeLexer.IF_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.LineComment;
import static apu.antlr.clike.ScratchCLikeLexer.MATH_DIVIDE;
import static apu.antlr.clike.ScratchCLikeLexer.MATH_MINUS;
import static apu.antlr.clike.ScratchCLikeLexer.MATH_MODULO;
import static apu.antlr.clike.ScratchCLikeLexer.MATH_PLUS;
import static apu.antlr.clike.ScratchCLikeLexer.MATH_TIMES;
import static apu.antlr.clike.ScratchCLikeLexer.METHOD_DEF_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.OPENP;
import static apu.antlr.clike.ScratchCLikeLexer.REPEAT_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.RETURN_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.SINGLE_FRAME_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.STRINGLITERAL;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_CLICKED;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_CLONED;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_FLAG;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_KEY;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_RECEIVE;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_SENSOR;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_TAG;
import static apu.antlr.clike.ScratchCLikeLexer.WHILE_TAG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import apu.antlr.clike.ScratchCLikeLexer;
import apu.scratch.converter.ScratchConverter.CompileError;
import apu.scratch.converter.ScratchConverter.CompileResult;

import com.seaglasslookandfeel.SeaGlassLookAndFeel;

/**
 * @author MegaApuTurkUltra
 * 
 */
public class IdeFrame extends JFrame {

	private static final long serialVersionUID = -7694777067218375044L;
	private JPanel contentPane;
	private JTextPane lines;
	private Style linesDefaultStyle;
	private Style linesRedStyle;
	private JTextPane codeArea;
	private StyleContext context;
	private Style defaultStyle;
	private Map<Integer, Style> styles = new HashMap<>();
	private DefaultStyledDocument doc;
	public JPanel sbRender;
	private Runnable compileTimer;
	private Thread compileThread;
	private JLabel lblFile;

	public static IdeFrame instance;

	public static File saveFile = null;

	private List<CompileError> currentErrors = new ArrayList<>();

	public SaveCallback callback = new SaveCallback() {
		@Override
		public void codeSaved(String code, boolean save) {
		}
	};

	private ScratchCLikeLexer lexer = new ScratchCLikeLexer(null);

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
		lexer.removeErrorListeners();
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

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String code;
				try {
					code = doc.getText(0, doc.getEndPosition().getOffset());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
					return;
				}
				if (!code.trim().isEmpty()) {
					if (JOptionPane
							.showConfirmDialog(
									IdeFrame.this,
									"You have code in the editor. If you have "
											+ "not saved it, opening a new file will cause"
											+ " it to be lost. Continue?",
									"Continue?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
						return;
				}
				File f = SavePanel.showDialog(true, false);
				if (f != null && f.exists()) {
					saveFile = f;
					lblFile.setText("File: " + f.getName());
					String newCode = Sprite2IO.readFile(f);
					if (newCode != null) {
						try {
							doc.replace(0,
									doc.getEndPosition().getOffset() - 1,
									newCode, defaultStyle);
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
				checkCode(true);
			}
		});
		header.add(btnSave);

		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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

		JScrollPane scrollPane = new JScrollPane();
		leftSplit.add(scrollPane, BorderLayout.CENTER);

		context = new StyleContext();
		doc = new DefaultStyledDocument(context);
		doc.setDocumentFilter(new DocumentFilter() {
			public void insertString(FilterBypass fb, int offset,
					String string, AttributeSet attr)
					throws BadLocationException {
				fb.insertString(offset, string, attr);
				countLines();
				highlight(fb);
			}

			public void remove(FilterBypass fb, int offs, int len)
					throws BadLocationException {
				fb.remove(offs, len);
				countLines();
				highlight(fb);
			}

			public void replace(FilterBypass fb, int offset, int length,
					String text, AttributeSet attrs)
					throws BadLocationException {
				fb.replace(offset, length, text, attrs);
				countLines();
				highlight(fb);
			}
		});
		defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontFamily(defaultStyle, "monospaced");
		Style style = context.addStyle("identifier", defaultStyle);
		StyleConstants.setForeground(style, Color.BLUE);
		StyleConstants.setItalic(style, true);
		styles.put(IDENTIFIER, style);
		style = context.addStyle("methodIdentifier", style);
		StyleConstants.setForeground(style, new Color(0.7f, 0f, 1f));
		styles.put(999, style);
		styles.put(WHEN_CLICKED, style);
		styles.put(WHEN_RECEIVE, style);
		styles.put(WHEN_KEY, style);
		styles.put(WHEN_CLONED, style);
		styles.put(WHEN_SENSOR, style);
		styles.put(WHEN_FLAG, style);
		styles.put(RETURN_TAG, style);
		style = context.addStyle("keyword", defaultStyle);
		StyleConstants.setBold(style, true);
		StyleConstants.setForeground(style, new Color(0.5f, 0f, 0.5f));
		styles.put(BOOL_TRUE, style);
		styles.put(IF_TAG, style);
		styles.put(ELSE_TAG, style);
		styles.put(FOR_TAG, style);
		styles.put(WHILE_TAG, style);
		styles.put(METHOD_DEF_TAG, style);
		styles.put(REPEAT_TAG, style);
		styles.put(ARRAY_TAG, style);
		style = context.addStyle("comment", defaultStyle);
		StyleConstants.setForeground(style, new Color(0.3f, 0.6f, 0.4f));
		StyleConstants.setItalic(style, true);
		styles.put(LineComment, style);
		styles.put(BlockComment, style);
		style = context.addStyle("string", defaultStyle);
		StyleConstants.setForeground(style, new Color(0.3f, 0.5f, 1f));
		styles.put(STRINGLITERAL, style);
		style = context.addStyle("annotation", defaultStyle);
		StyleConstants.setItalic(style, true);
		StyleConstants.setForeground(style, new Color(0.7f, 0.3f, 0.5f));
		styles.put(SINGLE_FRAME_TAG, style);
		styles.put(ATOMIC_METHOD_TAG, style);
		styles.put(WHEN_TAG, style);
		style = context.addStyle("operators", defaultStyle);
		StyleConstants.setBold(style, true);
		StyleConstants.setForeground(style, new Color(0f, 0.5f, 0f));
		styles.put(BOOL_AND, style);
		styles.put(BOOL_OR, style);
		styles.put(BOOL_NOT, style);
		styles.put(BOOL_EQUALS, style);
		styles.put(BOOL_NEQUALS, style);
		styles.put(BOOL_GT, style);
		styles.put(BOOL_LT, style);
		styles.put(BOOL_GTE, style);
		styles.put(BOOL_LTE, style);
		styles.put(MATH_PLUS, style);
		styles.put(MATH_MINUS, style);
		styles.put(MATH_TIMES, style);
		styles.put(MATH_DIVIDE, style);
		styles.put(MATH_MODULO, style);
		style = context.addStyle("syntaxerror", defaultStyle);
		StyleConstants.setForeground(style, Color.RED);
		StyleConstants.setUnderline(style, true);
		styles.put(1000, style);

		compileTimer = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							checkCode(false);
						}
					});
				} catch (InterruptedException e) {
					// do nothing; we were interrupted
				}
			}
		};

		codeArea = new JTextPane(doc);
		String tab = "";
		for (int i = 0; i < 4; i++) {
			tab += " ";
		}
		Font font = new Font(StyleConstants.getFontFamily(defaultStyle),
				Font.PLAIN, StyleConstants.getFontSize(defaultStyle));
		float f = (float) codeArea.getFontMetrics(font).stringWidth(tab);
		TabStop[] tabs = new TabStop[500]; // this sucks

		for (int i = 0; i < tabs.length; i++) {
			tabs[i] = new TabStop(f * (i + 1), TabStop.ALIGN_LEFT,
					TabStop.LEAD_NONE);
		}

		TabSet tabset = new TabSet(tabs);
		AttributeSet attrs = context.addAttribute(SimpleAttributeSet.EMPTY,
				StyleConstants.TabSet, tabset);
		codeArea.setParagraphAttributes(attrs, false);
		codeArea.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (compileThread != null && compileThread.isAlive())
					compileThread.interrupt();
				compileThread = new Thread(compileTimer);
				compileThread.setName("Compiler timer");
				compileThread.setDaemon(true);
				compileThread.start();
			}
		});
		codeArea.setBackground(Color.WHITE);
		JPanel codeContainer = new JPanel(new BorderLayout());
		scrollPane.setViewportView(codeContainer);
		codeContainer.add(codeArea, BorderLayout.CENTER);
		new LinePainter(codeArea, new Color(0.9f, 0.9f, 1f));

		lines = new JTextPane();
		lines.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent me) {
				Font f = new Font(StyleConstants
						.getFontFamily(linesDefaultStyle), Font.PLAIN,
						StyleConstants.getFontSize(linesDefaultStyle));
				int lineHeight = lines.getFontMetrics(f).getHeight();
				int line = me.getY() / lineHeight;
				line++;
				StringBuilder tooltip = new StringBuilder();
				tooltip.append("<html>");
				int i = 0;
				for (CompileError error : currentErrors) {
					if (line == error.line) {
						tooltip.append(error.toString());
						tooltip.append("<br/>");
						i++;
					}
				}
				tooltip.append("</html>");
				if (i == 0) {
					lines.setToolTipText(null);
				} else {
					lines.setToolTipText(tooltip.toString());
				}
			}
		});
		lines.setBackground(Color.WHITE);
		lines.setText("1");
		lines.setEditable(false);

		linesDefaultStyle = lines.getStyledDocument().getStyle(
				StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontFamily(linesDefaultStyle, "monospaced");
		linesRedStyle = lines.getStyledDocument().addStyle("red",
				linesDefaultStyle);
		StyleConstants.setForeground(linesRedStyle, Color.RED);
		StyleConstants.setBold(linesRedStyle, true);

		Border oldBorder = lines.getBorder();
		Border blackBorder = BorderFactory.createMatteBorder(0, 0, 0, 1,
				Color.BLACK);
		Border newBorder = BorderFactory.createCompoundBorder(blackBorder,
				oldBorder);
		lines.setBorder(newBorder);
		scrollPane.setRowHeaderView(lines);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainSplit.setRightComponent(tabbedPane);

		sbRender = new JPanel();
		tabbedPane.addTab("Scratchblocks2 Preview", null, sbRender, null);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
	}

	private void checkCode(boolean save) {
		try {
			String code = doc.getText(0, doc.getEndPosition().getOffset());
			lines.setBackground(Color.white);
			try {
				CompileResult result = ScratchConverter.compile(code);
				currentErrors.clear();
				currentErrors.addAll(result.errors);
				highlightErrorLines();
				if (currentErrors.size() == 0)
					callback.codeSaved(result.scripts.toString(), save);
				if (save) {
					if (saveFile == null) {
						File f = SavePanel.showDialog(true, true);
						if (f != null) {
							saveFile = f;
							lblFile.setText("File: " + f.getName());
						}
					}
					if (saveFile != null) {
						Sprite2IO.writeToFile(saveFile, code);
					}
				}
			} catch (Exception e) {
				lines.setBackground(new Color(1f, 0.5f, 0.5f));
				if (save) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(this,
							"Compile failed!\n" + e.getMessage(), "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	private void highlightErrorLines() {
		StyledDocument doc = lines.getStyledDocument();
		doc.setCharacterAttributes(0, doc.getEndPosition().getOffset(),
				linesDefaultStyle, true);
		highlight(null);
		for (CompileError e : currentErrors) {
			System.out.println(e);
			int len = Integer.toString(e.line).length();
			int pos = lines.getText().indexOf(e.line + "\n");
			if (pos == -1)
				pos = lines.getText().indexOf("\n" + e.line) + 1;
			if (pos == -1)
				pos = 0;

			doc.setCharacterAttributes(pos, len, linesRedStyle, true);

			int start = e.position, length = e.endPosition + 1 - start;
			this.doc.setCharacterAttributes(start, length, styles.get(1000),
					false);
		}
	}

	private void countLines() {
		String text;
		try {
			text = doc.getText(doc.getStartPosition().getOffset(), doc
					.getEndPosition().getOffset());
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		int index = 0;
		int c = 1;
		StringBuilder count = new StringBuilder();
		while (index < text.length() - 1) {
			index++;
			if (text.charAt(index) == '\n') {
				count.append(c);
				count.append("\n");
				c++;
			}
		}
		String l = count.toString();
		lines.setText(l.length() > 0 ? l : "1");

		highlightErrorLines();
	}

	private void highlight(FilterBypass fb) {
		try {
			String text;
			try {
				text = doc.getText(doc.getStartPosition().getOffset(), doc
						.getEndPosition().getOffset());
			} catch (BadLocationException e) {
				e.printStackTrace();
				return;
			}
			lexer.reset();
			lexer.setInputStream(new ANTLRInputStream(new StringReader(text)));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			tokens.fill();
			doc.setCharacterAttributes(0, text.length(), defaultStyle, true);
			List<Token> tokenList = tokens.getTokens();
			for (int i = 0; i < tokenList.size(); i++) {
				Token t = tokenList.get(i);
				int type = t.getType();
				if (styles.containsKey(type)) {
					if (type == IDENTIFIER && i + 1 < tokenList.size()) {
						if (tokenList.get(i + 1).getType() == OPENP) {
							type = 999;
						}
					}

					int offs = t.getStartIndex();
					int len = t.getStopIndex() - offs + 1;
					doc.setCharacterAttributes(offs, len, styles.get(type),
							true);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	static interface SaveCallback {
		public void codeSaved(String code, boolean save);
	}
}
