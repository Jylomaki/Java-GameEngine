package testing.valid.collision.diskCollider;

import engine._2D.Entity2D;
import engine._2D.physic.Collision2D;
import engine._2D.physic.LinearTimedAcceleration;
import engine.blueprint.Actuator;
import engine.blueprint.Entity;
import game.spriteManager.SpriteManager;

public class TestCollider extends Actuator{
	public boolean debug = false;
	
	private float disabled_total_time= 0.05f;
	private float disabled_uptime =-1;
	private float animation_total_time = 0.5f;
	private float animation_uptime = -1;
	public float repulsionStrength = 200;

	
	private boolean upTodate;
	
	public TestCollider() {
		super();

	}
	
	@Override
	@Deprecated
	public void update(Entity e, float time) {
		if(e instanceof Entity2D)
			update((Entity2D) e, time);
	}
	
	public void update(Entity2D e, float time) {
		if(this.disabled()) {
			this.disabled_uptime -= time;
			this.animation_uptime -= time;
			return;
		}
		
		if(this.in_animation()) {
			this.animation_uptime -= time;
		}else if(!this.upTodate) { //dafuq? it work though
			this.upTodate = true;
		}
		// getting collision info
		for(Collision2D c: e.collisions) {
			this.animation_uptime= this.animation_total_time;
			this.disabled_uptime = this.disabled_total_time;
			this.upTodate = false;
			if(debug)
				System.out.println("Collider: collision returned normal:" + c.normal_at_impact);
				
			e.speed.getTranslate().add_in_place(c.normal_at_impact.time_copy(repulsionStrength));
			e.addActuator(new LinearTimedAcceleration(c.normal_at_impact.time_copy(-repulsionStrength), this.animation_total_time));
		}
		
		
		if(in_animation())
			e.sprite = SpriteManager.pickable.health;
		else
			e.sprite = SpriteManager.pickable.ultimate;
	}
	
	private boolean in_animation() {
		return this.animation_uptime > 0;
	}
	
	private boolean disabled() {
		if(debug)
			System.out.println("Collider: Disabled:" + (this.disabled_uptime > 0)); 
		return this.disabled_uptime > 0;
	}

	

}
