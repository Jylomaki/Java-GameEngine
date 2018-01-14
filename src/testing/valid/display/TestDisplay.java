package testing.valid.display;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.FPS_counter;
import game.spriteManager.SpriteManager;

public class TestDisplay extends JPanel {
	static SpriteManager sprites;
	static FPS_counter fps_counter;
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		sprites = new SpriteManager();
		fps_counter = new FPS_counter(0.5);
		
		JFrame F = new JFrame();
		F.add(new TestDisplay());
		Dimension d = new Dimension(1280,600);

		F.setSize(d);
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	int r=0;
	public void  paintComponent(Graphics g) {
		fps_counter.update();
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform at = AffineTransform.getTranslateInstance(100, 100);
		at.scale(0.3, 0.5);

		at.rotate(Math.toRadians(r++), SpriteManager.pickable.health.centerPoint.getX(), SpriteManager.pickable.health.centerPoint.getY());
		g2d.drawImage(SpriteManager.pickable.health.img, at,null);
		if(fps_counter.refreshed)
			System.out.println("FPS:" + fps_counter.FPS());
		repaint();
		
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
