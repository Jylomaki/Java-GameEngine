package game.spriteManager;

import display._2D.SpriteBuffer;

public class Sprites_pickable {
	public SpriteBuffer ultimate, ammo, health;

	public Sprites_pickable() {
		super();
		ultimate = new SpriteBuffer("./assets/sprites/pickable/ultimate_lowres.png");
		health = new SpriteBuffer("./assets/sprites/pickable/health_lowres.png");
	}
	
}
