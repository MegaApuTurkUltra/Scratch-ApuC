/**
 * 
 */
package apu.scratch.converter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author MegaApuTurkUltra
 * 
 */
public class Sprite2IO {
	public static void writeToZip(File f, JSONArray code) {
		try {
			if (!f.exists()) {
				InputStream in = Sprite2IO.class
						.getResourceAsStream("/Sprite1.sprite2");
				Files.copy(in, Paths.get(f.toURI()));
				in.close();
			}

			URI uri = f.toURI();
			uri = new URI("jar:file", uri.getHost(), uri.getPath(), uri.getFragment());
			FileSystem fs = FileSystems.newFileSystem(uri,
					new HashMap<String, String>());
			Path sprite = fs.getPath("/sprite.json");
			JSONObject obj;
			obj = new JSONObject(new String(Files.readAllBytes(sprite)));
			if (obj.has("scripts"))
				obj.remove("scripts");
			obj.put("scripts", code);
			Files.write(sprite, obj.toString().getBytes(),
					StandardOpenOption.WRITE,
					StandardOpenOption.TRUNCATE_EXISTING,
					StandardOpenOption.SYNC);
			fs.close();
			JOptionPane.showMessageDialog(IdeFrame.instance,
					"Export successful", "Export",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(IdeFrame.instance,
					"Failed to save file: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String readFile(File f) {
		try {
			return new String(Files.readAllBytes(Paths.get(f.toURI())));
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(IdeFrame.instance,
					"Failed to open file: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public static void writeToFile(File f, String code) {
		try {
			FileOutputStream out = new FileOutputStream(f);
			out.write(code.getBytes());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(IdeFrame.instance,
					"Failed to save file: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
