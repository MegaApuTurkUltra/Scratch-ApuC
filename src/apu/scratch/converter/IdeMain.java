/**
 * 
 */
package apu.scratch.converter;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;

import apu.scratch.converter.IdeFrame.SaveCallback;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * @author MegaApuTurkUltra
 * 
 */
public class IdeMain {
	static JWebBrowser sb2;
	static File apuCTarget = null;
	static File sprite2Target = null;

	public static void launch() {
		System.out.println("Launch");
		try {
			ScratchConverter.init();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Failed to load Scratch built-ins file!", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ToolTipManager.sharedInstance().setReshowDelay(0);
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
		NativeInterface.open();

		try {
			new File("scratchblocks2/block_images/").mkdirs();
			String[] files = new String[] { "generator.js", "index.html",
					"scratchblocks2-only.js", "scratchblocks2.css",
					"scratchblocks2.js", "block_images/arrows.png",
					"block_images/flag.png" };
			for (String file : files) {
				System.out.println("Copying out: "+file);
				InputStream in = IdeMain.class
						.getResourceAsStream("/scratchblocks2/" + file);
				Files.copy(in,
						Paths.get(new File("scratchblocks2/" + file).toURI()),
						StandardCopyOption.REPLACE_EXISTING);
				in.close();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				IdeFrame.launch();
				try {
					sb2 = new JWebBrowser();
					sb2.setBarsVisible(false);
					sb2.setButtonBarVisible(false);
					sb2.setJavascriptEnabled(true);
					sb2.setMenuBarVisible(false);
					sb2.setStatusBarVisible(false);
					sb2.navigate(new File("scratchblocks2/index.html").toURI().toString());
					IdeFrame.instance.sbRender.setLayout(new BorderLayout());
					IdeFrame.instance.sbRender.add(sb2, BorderLayout.CENTER);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(IdeFrame.instance,
							"Unable to load Scratchblocks2", "Warning",
							JOptionPane.WARNING_MESSAGE);
					IdeFrame.instance.sbRender.add(new JLabel(
							"Unable to load Scratchblocks2"));
				}

				IdeFrame.instance.callback = new SaveCallback() {
					@Override
					public void codeSaved(final String code, boolean save) {
						String js = "window.showCode(\""
								+ code.replace("\"", "\\\"") + "\");";
						try {
							sb2.executeJavascript(js);
						} catch (Exception e) {
						}
					}
				};

				IdeFrame.instance.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								sb2.disposeNativePeer(false);
							}
						});
					}
				});
			}
		});

		NativeInterface.runEventPump();
	}

	public static void main(String[] args) {
		launch();
	}

}
