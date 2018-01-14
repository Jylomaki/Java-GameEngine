package display._2D;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import engine.FPS_counter;
import engine._2D.Entity2D;
import engine._2D.Scene2D;
import engine._2D.Vector2D;

public class Scene2DDisplay extends JPanel{
		public boolean debug = false;
		private static final long serialVersionUID = 1L;
		Scene2D scene;
		public FPS_counter fps_counter;
		
		public Scene2DDisplay(Scene2D s) {
			this.scene = s;
			this.fps_counter = new FPS_counter(0.5);
		}
		
		public void  paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setTransform(scene.camera_transform.toAffinetransform(new Vector2D()));
			paintBackground(g2d);
			scene.update();
			for(Entity2D e : scene.entities) {
				paintEntity(g2d, e);
			}
			this.fps_counter.update();
			if(this.fps_counter.refreshed)
				System.out.println("(scene2DDisplay)FPS: " + this.fps_counter.FPS());
			repaint();
		}
		
		public void paintBackground(Graphics2D g2d) {
			if(scene.background.activeDisplay) {
				AffineTransform a = scene.background.position.toAffinetransform(scene.background.sprite.centerPoint);//scene.background.position.toAffinetransform(scene.background.sprite.centerPoint);
				g2d.drawImage(scene.background.sprite.img,a,null);
			}
		}
		
		public void paintEntity(Graphics2D g2d,Entity2D e ) {
			if(!e.activeDisplay)
				return;
			Vector2D centerpoint = Vector2D.add(e.sprite.centerPoint, e.position.getTranslate());
			if(debug)
				System.out.println("Scene2DDisplay: pivot point:" + centerpoint);
			AffineTransform at = e.position.toAffinetransform(centerpoint);
			g2d.drawImage(e.sprite.img, at, null);
	}

}
