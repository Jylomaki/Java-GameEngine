package engine.input;

import engine._2D.Vector2D;

/**
 * Classe to turn physical input into abstract inputs
 * @author Jylomaki
 *
 */
public class AbstractController {
	public Vector2D move, aim;
	
	public AbstractController() {
		move = new Vector2D();
		aim = new Vector2D();
	}
}

