package engine._2D.physic;

import engine._2D.Entity2D;
import engine._2D.Vector2D;
import engine.blueprint.Actuator;
import engine.blueprint.Entity;

/**
 * An acceleration of Tspeed/time uptill uptime
 * @author Jylomaki
 *
 */
public class LinearTimedAcceleration extends Actuator{
	public boolean debug = false;
	public Vector2D targetSpeed;
	public float uptime;
	
	public LinearTimedAcceleration(Vector2D targetSpeed, float uptime) {
		super();
		this.targetSpeed = targetSpeed.time_copy(1./uptime);
		this.uptime = uptime;
	}
	@Override
	public void update(Entity e, float time) {
		if(e instanceof Entity2D)
			update((Entity2D) e, time);
	}
	
	public void update(Entity2D e, float time) {
		if(debug)
			System.out.println("LinearTimedAccel: qty of mvt to convey:" + targetSpeed.time_copy(uptime));
		if(time < uptime) {
			this.uptime -= time;
			e.speed.getTranslate().add(targetSpeed.time_copy(time));
		}
		else {
			e.speed.getTranslate().add(targetSpeed.time_copy(uptime));
			e.remove(this);
		}
	}

}
