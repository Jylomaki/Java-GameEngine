package display._2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine._2D.Transformation2D;
import engine._2D.Vector2D;
import engine._2D.physic.Collider2D;
import engine._2D.physic.ColliderBloatedSegment;
import engine._2D.physic.ColliderDisk;

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

	public Collider2D getColliderDisk(Vector2D position) {
		return new ColliderDisk(this.centerPoint, position, this.radius);
	}
	
	public Collider2D getColliderBloatedSegment(Transformation2D position) {
		if(img.getHeight() > img.getWidth()) {
			double radius = img.getWidth()/2;
			Vector2D a = new Vector2D(radius,radius);
			Vector2D b = new Vector2D(radius, img.getHeight()-radius);
			return new ColliderBloatedSegment(a, b, position, radius);
		}
		double radius = img.getHeight()/2;
		Vector2D a = new Vector2D(radius,radius);
		Vector2D b = new Vector2D(img.getWidth()-radius, radius);
		return new ColliderBloatedSegment(a, b, position, radius);
	}
}
