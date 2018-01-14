package game.actuators;

import engine._2D.Entity2D;
import engine._2D.Transformation2D;
import engine.blueprint.Actuator;
import engine.blueprint.Entity;

public class ConstantForce2D extends Actuator{
	private Transformation2D v;
	public ConstantForce2D(Transformation2D v) {
		this.v=v;
	}
	@Override
	@Deprecated
	public void update(Entity e, float time) {
	}
	public void update(Entity2D e, float time) {
		e.speed.concatenate_in_place(v.factor_copy(time));
	}
}
