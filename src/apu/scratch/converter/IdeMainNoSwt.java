/**
 * 
 */
package apu.scratch.converter;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;

/**
 * @author "TheAwesomeTNT"
 * 
 */
public class IdeMainNoSwt {
	static class LazyLayoutManager implements LayoutManager {
		// the laziest layout manager ever
		// makes it so you can slide the split over
		// with preferredSize = new Dimension(0, 0)
		// default layouts prevent you from doing that
		@Override
		public void removeLayoutComponent(Component comp) {
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			return new Dimension(0, 0);
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			return new Dimension(0, 0);
		}

		@Override
		public void layoutContainer(Container parent) {
			for (Component comp : parent.getComponents()) {
				comp.setBounds(parent.getBounds());
			}
		}

		@Override
		public void addLayoutComponent(String name, Component comp) {
		}
	}

	public static void main(String[] args) {
		System.out.println("Opening IDE [no swt]; use -uselaf to enable the LAF");
		final boolean useLaf = args.length > 0 && args[0].equalsIgnoreCase("-uselaf");
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
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				IdeFrame.launch(useLaf);
				IdeFrame.instance.sbRender.setLayout(new LazyLayoutManager());
				IdeFrame.instance.sbRender.add(new JLabel(
						"Preview diabled - run ApuC.jar instead to see it"));
				IdeFrame.instance.sbRender
						.setPreferredSize(new Dimension(0, 0));
			}
		});
	}

}
