package game.spriteManager;

public class SpriteManager {
	public static Sprites_bullet bullets;
	public static Sprites_pickable pickable;
	public static Sprites_playable playble_characters;
	public static Sprites_background background;
	
	public SpriteManager() {
		bullets = new Sprites_bullet();
		pickable = new Sprites_pickable();
		playble_characters = new Sprites_playable();
		background = new Sprites_background();
	}
	
	public static void init_SpriteManager() {
		bullets = new Sprites_bullet();
		pickable = new Sprites_pickable();
		playble_characters = new Sprites_playable();
		background = new Sprites_background();
	}
}
