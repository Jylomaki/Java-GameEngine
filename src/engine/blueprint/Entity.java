package engine.blueprint;
/**
 * Entity:
 * Transform
 * Modèle
 * boolean display
 * boolean activehitbox
 * @author Jylomaki
 *
 */

import java.util.ArrayList;

public abstract class Entity {
	public ArrayList<Actuator> actuators;
	public Collider collider;
	public Entity() {
		actuators = new ArrayList<Actuator>();
	}
	public void update(float time) {
		for(Actuator a: actuators) {
			a.update(this, time);
		}
	}
	public void addActuator(Actuator a) {
		actuators.add(a);
	}
}
