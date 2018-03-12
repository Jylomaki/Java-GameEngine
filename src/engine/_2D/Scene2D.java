package engine._2D;

import java.util.ArrayList;

import engine.FPS_counter;
import engine.blueprint.Scene;
import game.spriteManager.SpriteManager;

public class Scene2D extends Scene{
	public ArrayList<Entity2D> entities;
	public Entity2D background;
	public Transformation2D camera_transform;
	public FPS_counter fps_counter;
	
	protected CollisionComputer collisionComputer;
	
	//TODO remove this things, it's supposed to be in each an every scene:
	public SpriteManager sprites;
	
	private void init_time() {
		this.lastTime = System.nanoTime();
		this.fps_counter = new FPS_counter(0.5);//refresh FPS twice a second
	}
	public Scene2D () {
		this.entities = new ArrayList<Entity2D>();
		this.camera_transform = new Transformation2D();
		this.collisionComputer = new CollisionComputer(entities);
		init_time();
	}
	public Scene2D(ArrayList<Entity2D> entities, Entity2D background) {
		super();
		this.entities = entities;
		this.background = background;
		this.camera_transform = new Transformation2D();
		init_time();
	}
	
	public Scene2D(ArrayList<Entity2D> entities, Entity2D background, Transformation2D camera_transform) {
		super();
		this.entities = entities;
		this.background = background;
		this.camera_transform = camera_transform;
		init_time();
	}
	
	public void update() {
		//Time
		long newTime = System.nanoTime();
		long elapsed_nano = newTime - lastTime;
		this.lastTime = newTime;
		float milliard = 1000000000;
		
		//Update
		update(elapsed_nano/milliard);
		
		//FPS display
		if(this.fps_counter.refreshed)
			System.out.println("(scene2D)FPS: " + this.fps_counter.FPS());
	}
	
	public void update(float timeElasped) {
		// Fps update here so you can tweak time passing and keep a real fps
		this.fps_counter.update();
		for(Entity2D e : entities) {
			e.update(timeElasped);
		}
		
		//Collision are computed after because collisions are cleared in entity update
		this.collisionComputer.update();
	}
}
