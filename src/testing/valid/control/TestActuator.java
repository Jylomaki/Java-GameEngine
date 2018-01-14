package testing.valid.control;

import engine._2D.Entity2D;
import engine._2D.Vector2D;
import engine.blueprint.Actuator;
import engine.blueprint.Entity;
import engine.input.AbstractController;

public class TestActuator extends Actuator{
	public boolean debug = false;
	AbstractController controller;

	public TestActuator(AbstractController a) {
		this.controller = a;
	}
	public void update(Entity2D e, float time) {
		Vector2D movement = Vector2D.time(this.controller.move,600);
		movement.time(time);
		if(debug)
			System.out.println("Movement:" +movement);
		e.position.getTranslate().add(movement);
	}
	
	@Override
	@Deprecated
	public void update(Entity e, float time) {
		// TODO Auto-generated method stub
		if(e instanceof Entity2D)
			update((Entity2D)e, time);
	}
	
}
