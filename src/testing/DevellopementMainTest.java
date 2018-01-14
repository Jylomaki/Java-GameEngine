package testing;
import java.awt.Dimension;

import javax.swing.JFrame;

import display._2D.Scene2DDisplay;
import engine._2D.Scene2D;
import engine.input.Inputs;
import engine.input.KeyboardListener;
import testing.valid.collision.diskCollider.TestScene_Actuator_Collider;

public class DevellopementMainTest {
	public static void main(String[] args) {
		JFrame F = new JFrame();
		Dimension d = new Dimension(600,600);
		F.setSize(d);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Scene2D scene = new testing.valid.TestScene();
		
		KeyboardListener kbListener = new engine.input.KeyboardListener();
		F.addKeyListener(kbListener);
		Inputs.keyboard = kbListener.controller;
		
		Scene2D scene = new TestScene_Actuator_Collider();
		Scene2DDisplay sceneDisplay = new Scene2DDisplay(scene);
		
		F.add(sceneDisplay);
		F.setVisible(true);
	}
}
