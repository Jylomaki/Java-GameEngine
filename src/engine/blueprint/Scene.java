package engine.blueprint;

import java.util.ArrayList;

public abstract class Scene {
	public Long lastTime;
	public ArrayList<Entity> entities;
	
	public void update() {
		long newTime = System.nanoTime();
		long elapsed_nano = newTime - lastTime;
		this.lastTime = newTime;
		float milliard = 1000000000;
		update(elapsed_nano/milliard);
	}
	
	public void update(float time) {}
}
