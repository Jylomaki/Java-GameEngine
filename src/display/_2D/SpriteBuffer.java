package display._2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine._2D.Vector2D;

public class SpriteBuffer {
	public BufferedImage img;
	public Vector2D centerPoint;
	public double radius;
	
	public SpriteBuffer(String filename) {
		this.img = loadimage(filename);
		this.centerPoint = new Vector2D (img.getWidth()/2, img.getHeight()/2f);
		this.radius = Math.max(img.getHeight(), img.getWidth())/2;
	}
	
	public BufferedImage loadimage(String fileName) {
		BufferedImage img=null;
		try {
			img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}
