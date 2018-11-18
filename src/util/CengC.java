import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CengC {
	// private final CountDownLatch countDownLatch = new CountDownLatch(1);
	private  String[][] ascii;

	public  BufferedImage toGrayScale(BufferedImage image) throws IOException {

		File file = new File("output.txt");
		FileWriter writer = new FileWriter(file);
		String line = "";
		ascii = new String[image.getHeight()][image.getWidth()];

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y));

				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				int a = c.getAlpha();
				String key = RGBToASCII(r, g, b);
//				int brightness = (r + g + b) / 3;
//				char key = ' ';
//				if (brightness <= 25) {
//					key = '&';
//				} else if (25 < brightness && brightness <= 50) {
//					key = 'P';
//				} else if (50 < brightness && brightness <= 76) {
//					key = 'o';
//				} else if (76 < brightness && brightness <= 102) {
//					key = ')';
//				} else if (102 < brightness && brightness <= 127) {
//					key = '*';
//				} else if (127 < brightness && brightness <= 152) {
//					key = ':';
//				} else if (152 < brightness && brightness <= 178) {
//					key = '=';
//				} else if (178 < brightness && brightness <= 204) {
//					key = '.';
//				} else if (204 < brightness && brightness <= 255) {
//					key = ' ';
//				}

			//	if (y == image.getWidth()) {
				//	ascii[x][y + 1] = '\n';
				//} else {
					ascii[y][x] = key;
				//}
				// Color grey = new Color(brightness,brightness,brightness);
				// image.setRGB(x, y, grey.getRGB());

				System.out.println("Pixel " + (x + y));

			}
		}
		for (int y = 0; y < ascii.length; y++) {
			line = "";
			for (int x = 0; x < ascii[y].length; x++) {
				
				line = line + ascii[y][x];
			}
			writer.write(line+"\n");
			//writer.write("\n");

		}

		System.out.println("done!");
		return image;
	}
	
	private String RGBToASCII(int r, int g, int b) {
		int brightness = (r + g + b) / 3;
		String key = "";
		if (r > g&&r>b) {
			if (brightness <= 25) {
				key = "&";
			} else if (25 < brightness && brightness <= 50) {
				key = "P";
			} else if (50 < brightness && brightness <= 76) {
				key = "o";
			} else if (76 < brightness && brightness <= 102) {
				key = ")";
			} else if (102 < brightness && brightness <= 127) {
				key = "*";
			} else if (127 < brightness && brightness <= 152) {
				key = ":";
			} else if (152 < brightness && brightness <= 178) {
				key = "=";
			} else if (178 < brightness && brightness <= 204) {
				key = ".";
			} else if (204 < brightness && brightness <= 255) {
				key = " ";
			}
		} else if (g > r&& g>b) {
			if (brightness <= 25) {
				key = "@";
			} else if (25 < brightness && brightness <= 50) {
				key = "Q";
			} else if (50 < brightness && brightness <= 76) {
				key = "u";
			} else if (76 < brightness && brightness <= 102) {
				key = "(";
			} else if (102 < brightness && brightness <= 127) {
				key = "^";
			} else if (127 < brightness && brightness <= 152) {
				key = ";";
			} else if (152 < brightness && brightness <= 178) {
				key = ">";
			} else if (178 < brightness && brightness <= 204) {
				key = ",";
			} else if (204 < brightness && brightness <= 255) {
				key = " ";
			}
		} else {
			if (brightness <= 25) {
				key = "%";
			} else if (25 < brightness && brightness <= 50) {
				key = "R";
			} else if (50 < brightness && brightness <= 76) {
				key = "C";
			} else if (76 < brightness && brightness <= 102) {
				key = "]";
			} else if (102 < brightness && brightness <= 127) {
				key = "|";
			} else if (127 < brightness && brightness <= 152) {
				key = "i";
			} else if (152 < brightness && brightness <= 178) {
				key = "<";
			} else if (178 < brightness && brightness <= 204) {
				key = "-";
			} else if (204 < brightness && brightness <= 255) {
				key = " ";
			}
		}
		return key;
	}

	private int[] ASCIItoRGB(String c) {
		int[] toReturn = new int[3];
			if (c.equals("&")) {
				toReturn[0] = 20;
				toReturn[1] = 0;
				toReturn[2] = 0;
			} else if (c.equals("P")) {
				toReturn[0] = 50;
				toReturn[1] = 15;
				toReturn[2] = 15;
			} else if (c.equals("o")) {
				toReturn[0] = 60;
				toReturn[1] = 25;
				toReturn[2] = 25;
			} else if (c.equals(")")) {
				toReturn[0] = 100;
				toReturn[1] = 50;
				toReturn[2] = 50;
			} else if (c.equals("*")) {
				toReturn[0] = 120;
				toReturn[1] = 60;
				toReturn[2] = 60;
			} else if (c.equals(":")) {
				toReturn[0] = 150;
				toReturn[1] = 75;
				toReturn[2] = 75;
			} else if (c.equals("=")) {
				toReturn[0] = 170;
				toReturn[1] = 85;
				toReturn[2] = 85;
			} else if (c.equals(".")) {
				toReturn[0] = 200;
				toReturn[1] = 100;
				toReturn[2] = 100;
			} else if (c.equals(" ")) {
				toReturn[0] = 250;
				toReturn[1] = 250;
				toReturn[2] = 250;
			}
			else if (c.equals("@")) {
				toReturn[0] = 0;
				toReturn[1] = 20;
				toReturn[2] = 0;
			} else if (c.equals("Q")) {
				toReturn[0] = 15;
				toReturn[1] = 50;
				toReturn[2] = 15;
			} else if (c.equals("u")) {
				toReturn[0] = 25;
				toReturn[1] = 60;
				toReturn[2] = 25;
			} else if (c.equals("(")) {
				toReturn[0] = 50;
				toReturn[1] = 100;
				toReturn[2] = 50;
			} else if (c.equals("^")) {
				toReturn[0] = 60;
				toReturn[1] = 120;
				toReturn[2] = 60;
			} else if (c.equals(";")) {
				toReturn[0] = 75;
				toReturn[1] = 150;
				toReturn[2] = 75;
			} else if (c.equals(">")) {
				toReturn[0] = 85;
				toReturn[1] = 170;
				toReturn[2] = 85;
			} else if (c.equals(",")) {
				toReturn[0] = 100;
				toReturn[1] = 200;
				toReturn[2] = 100;
			}
			else if (c.equals("%")) {
				toReturn[0] = 0;
				toReturn[1] = 0;
				toReturn[2] = 20;
			} else if (c.equals("R")) {
				toReturn[0] = 15;
				toReturn[1] = 15;
				toReturn[2] = 50;
			} else if (c.equals("C")) {
				toReturn[0] = 25;
				toReturn[1] = 25;
				toReturn[2] = 60;
			} else if (c.equals("]")) {
				toReturn[0] = 50;
				toReturn[1] = 50;
				toReturn[2] = 100;
			} else if (c.equals("|")) {
				toReturn[0] = 60;
				toReturn[1] = 60;
				toReturn[2] = 120;
			} else if (c.equals("i")) {
				toReturn[0] = 75;
				toReturn[1] = 75;
				toReturn[2] = 150;
			} else if (c.equals("<")) {
				toReturn[0] = 85;
				toReturn[1] = 85;
				toReturn[2] = 170;
			} else if (c.equals("-")) {
				toReturn[0] = 100;
				toReturn[1] = 100;
				toReturn[2] = 200;
				}
			else 
			{
				toReturn[0] = 250;
				toReturn[1] = 250;
				toReturn[2] = 250;	
			}
				return toReturn;
	}
	
	public BufferedImage ASCIItoPNG(File file) throws IOException {

		LineNumberReader reader = new LineNumberReader(new FileReader(file));
		BufferedReader read = new BufferedReader(new FileReader(file));
		int height = 0;
		String lineRead = "";
		String lineOfFile = read.readLine();
		int width = lineOfFile.length();
		while ((lineRead = reader.readLine()) != null) {
		}

		height = reader.getLineNumber();
		reader.close();

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		String line = "";
		int coloravg;
		for (int y = 0; y < image.getHeight() - 1; y++) {
			for (int x = 0; x < image.getWidth(); x++) {

				String character = lineOfFile.substring(x, x + 1);
				System.out.println(character);

				/**coloravg = 0;
				if (character.equals("&")) {
					coloravg = 25 / 2;
				} else if (character.equals("P")) {
					coloravg = (50 + 25) / 2;
				} else if (character.equals("o")) {
					coloravg = (50 + 76) / 2;
				} else if (character.equals(")")) {
					coloravg = (76 + 102) / 2;
				} else if (character.equals("*")) {
					coloravg = (102 + 127) / 2;
				} else if (character.equals(":")) {
					coloravg = (127 + 152) / 2;
				} else if (character.equals("=")) {
					coloravg = (152 + 178) / 2;
				} else if (character.equals(".")) {
					coloravg = (178 + 204) / 2;
				} else if (character.equals(" ")) {
					coloravg = (204 + 255) / 2;
				}

				int r = coloravg;
				int g = coloravg;
				int b = coloravg;
				**/
				int[] answer = ASCIItoRGB(character);

				//Color grey = new Color(r, g, b);
				Color grey = new Color(answer[0], answer[1], answer[2]);
				image.setRGB(x, y, grey.getRGB());

				//System.out.println(coloravg);

			}
			lineOfFile = read.readLine();

		}

		return image;
	}


}
/*
 * int p = image.getRGB(x,y); int a = (p>>24)&0xff; int r = (p>>16)&0xff; int g
 * = (p>>8)&0xff; int b = p&0xff; int brightness = ( r + g + b)/3; p = (a<<24) |
 * (brightness<<16) | (brightness<<8) | brightness;
 * 
 * image.setRGB(x, y, p);
 */
