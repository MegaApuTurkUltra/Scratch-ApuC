/**
 * 
 */
package apu.scratch.converter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.SystemUtils;

/**
 * 
 * @author MegaApuTurkUltra
 * 
 */
public class NsLauncher {
	static URLClassLoader loader;

	enum Os {
		WINDOWS("swt-4.3-win32-win32-x86_s.jar"), WINDOWS64(
				"swt-4.3-win32-win32-x86_64_s.jar"), LINUX(
				"swt-4.3-gtk-linux-x86_s.jar"), LINUX64(
				"swt-4.3-gtk-linux-x86_64_s.jar"), OSX(
				"swt-4.3-cocoa-macosx_s.jar"), OSX64(
				"swt-4.3-cocoa-macosx-x86_64_s.jar"), IDK("");

		String swt;

		Os(String swtpath) {
			swt = swtpath;
		}
	}

	public static void main(String[] args) {
		Os os;
		boolean is64Bit = SystemUtils.OS_ARCH.contains("64");
		if (SystemUtils.IS_OS_WINDOWS) {
			if (is64Bit)
				os = Os.WINDOWS64;
			else
				os = Os.WINDOWS;
		} else if (SystemUtils.IS_OS_LINUX) {
			if (is64Bit)
				os = Os.LINUX64;
			else
				os = Os.LINUX;
		} else if (SystemUtils.IS_OS_MAC_OSX) {
			if (is64Bit)
				os = Os.OSX64;
			else
				os = Os.OSX;
		} else
			os = Os.IDK;

		if (os == Os.IDK) {
			JOptionPane.showMessageDialog(null,
					"Your OS was not recognized. Unable to load SWT", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		System.out
				.println("Found OS " + os.toString() + " with path " + os.swt);
		URL resource = NsLauncher.class.getResource("/lib/" + os.swt);
		System.out.println("Loading resource: " + resource);

		try {
			new File("lib").mkdirs();
			Files.copy(NsLauncher.class.getResourceAsStream("/lib/" + os.swt),
					Paths.get(new File("lib/" + os.swt).toURI()),
					StandardCopyOption.REPLACE_EXISTING);
			Files.copy(NsLauncher.class
					.getResourceAsStream("/lib/DJNativeSwing-SWT.jar"), Paths
					.get(new File("lib/DJNativeSwing-SWT.jar").toURI()),
					StandardCopyOption.REPLACE_EXISTING);
			Files.copy(NsLauncher.class
					.getResourceAsStream("/lib/DJNativeSwing.jar"), Paths
					.get(new File("lib/DJNativeSwing.jar").toURI()),
					StandardCopyOption.REPLACE_EXISTING);
			Files.copy(NsLauncher.class.getResourceAsStream("/IDE.jar"),
					Paths.get(new File("lib/IDE.jar").toURI()),
					StandardCopyOption.REPLACE_EXISTING);

			loader = new URLClassLoader(new URL[] {
					new File("lib/" + os.swt).toURI().toURL(),
					new File("lib/DJNativeSwing-SWT.jar").toURI().toURL(),
					new File("lib/DJNativeSwing.jar").toURI().toURL(),
					new File("lib/IDE.jar").toURI().toURL() },
					NsLauncher.class.getClassLoader());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Failed to copy libs: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					loader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}));

		System.out.println("Checking for components");
		try {
			loader.loadClass("org.eclipse.swt.SWT");
			loader.loadClass("chrriis.dj.nativeswing.swtimpl.NativeInterface");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Failed to link SWT: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Launching");
		try {
			Class<?> clazz = loader.loadClass("apu.scratch.converter.IdeMain");
			clazz.getDeclaredMethod("launch", new Class[] {}).invoke(
					(Object) null, new Object[] {});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Unable to launch app: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
	}
}
