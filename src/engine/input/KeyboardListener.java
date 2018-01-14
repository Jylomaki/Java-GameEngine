package engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{
	public boolean debug = false;
	public AbstractController controller;
	private int move_v_up, move_v_down, move_h_right, move_h_left;
	private int aim_v_up, aim_v_down, aim_h_right, aim_h_left;
	@Override
	public void keyTyped(KeyEvent e) {
	}

	public KeyboardListener() {
		super();
		controller = new AbstractController();
	}
	private void update_controller_state() {
		controller.move.setX(this.move_h_right - this.move_h_left);
		controller.move.setY(this.move_v_down - this.move_v_up);
		
		controller.aim.setX(this.aim_h_right - this.aim_h_left);
		controller.aim.setY(this.aim_v_down - this.aim_v_up);
	}
	
	public void keyPressed(KeyEvent e) {
		if(debug) {
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			System.out.println(controller.move);
		}
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_Z:
			this.move_v_up = 1;
			break;
		case KeyEvent.VK_Q:
			this.move_h_left = 1;
			break;
		case KeyEvent.VK_S:
			this.move_v_down = 1;
			break;
		case KeyEvent.VK_D:
			this.move_h_right = 1;
			break;
			
		case KeyEvent.VK_UP:
			this.aim_v_up= 1;
			break;
		case KeyEvent.VK_LEFT:
			this.aim_h_left= 1;
			break;
		case KeyEvent.VK_DOWN:
			this.aim_v_down= 1;
			break;
		case KeyEvent.VK_RIGHT:
			this.aim_h_right= 1;
			break;
		}
		this.update_controller_state();
	}
	public void keyReleased(KeyEvent e) {
		if(debug)
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_Z:
			this.move_v_up = 0;
			break;
		case KeyEvent.VK_Q:
			this.move_h_left = 0;
			break;
		case KeyEvent.VK_S:
			this.move_v_down = 0;
			break;
		case KeyEvent.VK_D:
			this.move_h_right = 0;
			break;
			
		case KeyEvent.VK_UP:
			this.aim_v_up = 0;
			break;
		case KeyEvent.VK_LEFT:
			this.aim_h_left = 0;
			break;
		case KeyEvent.VK_DOWN:
			this.aim_v_down = 0;
			break;
		case KeyEvent.VK_RIGHT:
			this.aim_h_right = 0;
			break;
		}
		this.update_controller_state();
	}
	
}
