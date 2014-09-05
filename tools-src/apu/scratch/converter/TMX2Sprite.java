/**
 * 
 */
package apu.scratch.converter;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * I am making a platformer with ApuC so I'm writing this tool to convert Tiled
 * map files (json format) to a base sprite with tile costumes
 * 
 * @author MegaApuTurkUltra
 */
public class TMX2Sprite {
	static Map<Integer, BufferedImage> tiles = new HashMap<Integer, BufferedImage>();

	public static void main(String[] args) throws Exception {
		File input = new File(args[0]);
		JSONObject main = new JSONObject(new String(Files.readAllBytes(Paths
				.get(input.toURI()))));
		JSONObject project = new JSONObject(new String(
				Files.readAllBytes(Paths.get(TMX2Sprite.class.getResource(
						"/BaseProject.json").toURI()))));
		JSONObject sprite = new JSONObject(new String(Files.readAllBytes(Paths
				.get(ScratchConverter.class.getResource("/BaseSprite.json")
						.toURI()))));
		sprite.remove("costumes");
		sprite.put("objName", "tiles");
		JSONArray children = project.getJSONArray("children");
		children.put(sprite);

		JSONArray tilesets = main.getJSONArray("tilesets");
		for (int i = 0; i < tilesets.length(); i++) {
			JSONObject ts = tilesets.getJSONObject(i);
			int iw = ts.getInt("imagewidth"), ih = ts.getInt("imageheight"), tw = ts
					.getInt("tilewidth"), th = ts.getInt("tileheight");
			System.out.println(iw + " " + ih + " " + tw + " " + th);
			BufferedImage image = ImageIO.read(new File(input.getParentFile(),
					ts.getString("image")));
			int id = ts.getInt("firstgid");
			for (int y = 0; y < ih; y += th) {
				for (int x = 0; x < iw; x += tw) {
					System.out.println("\t"+x+" "+y);
					BufferedImage tile = new BufferedImage(tw, th,
							BufferedImage.TYPE_INT_ARGB);
					Graphics2D g = tile.createGraphics();
					g.drawImage(image, 0, 0, tw, th, x, y, x + tw, y + th, null);
					g.dispose();
					tiles.put(id, tile);
					id++;
				}
			}
		}
		JSONArray variables = new JSONArray();
		variables.put(createVar("MAP_WIDTH", main.get("width")));
		variables.put(createVar("MAP_HEIGHT", main.get("height")));
		variables.put(createVar("TILE_WIDTH", main.get("tilewidth")));
		variables.put(createVar("TILE_HEIGHT", main.get("tileheight")));
		project.put("variables", variables);

		JSONArray lists = new JSONArray();

		JSONArray layers = main.getJSONArray("layers");
		for (int i = 0; i < layers.length(); i++) {
			JSONObject layer = layers.getJSONObject(i);
			if (!layer.getString("type").equals("tilelayer")) {
				continue;
			}
			lists.put(createList("Map_" + layer.getString("name"),
					layer.getJSONArray("data")));
		}
		project.put("lists", lists);

		Files.copy(Paths.get(TMX2Sprite.class.getResource(
				"/BaseProjectTiles.sb2").toURI()), Paths.get(new File(
				"output.zip").toURI()), StandardCopyOption.REPLACE_EXISTING);
		URI uri = new File("output.zip").toURI();
		uri = new URI("jar:" + uri.getScheme(), uri.getHost(), uri.getPath(),
				uri.getFragment());
		FileSystem fs = FileSystems.newFileSystem(uri,
				new HashMap<String, Object>());

		int j = 2;
		JSONArray costumes = new JSONArray();
		for (Integer i : tiles.keySet()) {
			BufferedImage tile = tiles.get(i);

			Path p = fs.getPath("/" + j + ".png");
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			OutputStream out = Files.newOutputStream(p,
					StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			ImageIO.write(tile, "png", bytes);
			byte[] data = bytes.toByteArray();
			out.write(data);
			out.close();

			String md5 = toHex(MessageDigest.getInstance("MD5").digest(data));
			System.out.println(md5);
			JSONObject costume = new JSONObject();
			costumes.put(costume);
			costume.put("costumeName", j + "");
			costume.put("baseLayerID", j);
			costume.put("baseLayerMD5", md5 + ".png");
			costume.put("bitmapResolution", 1);
			costume.put("rotationCenterX", tile.getWidth() / 2);
			costume.put("rotationCenterY", tile.getHeight() / 2);
			j++;
		}
		sprite.put("costumes", costumes);

		Files.write(fs.getPath("/project.json"), project.toString().getBytes(),
				StandardOpenOption.WRITE, StandardOpenOption.CREATE);

		fs.close();
	}

	static JSONObject createList(String name, JSONArray value) {
		JSONObject list = new JSONObject();
		list.put("listName", name);
		list.put("contents", value);
		list.put("isPersistant", false);
		list.put("x", 0);
		list.put("y", 0);
		list.put("width", 0);
		list.put("height", 0);
		list.put("visible", false);
		return list;
	}

	static JSONObject createVar(String name, Object value) {
		JSONObject var = new JSONObject();
		var.put("name", name);
		var.put("value", value);
		var.put("isPersistant", false);
		return var;
	}

	static String toHex(byte[] bytes) {
		return String.format("%032x", new BigInteger(1, bytes));
	}
}
