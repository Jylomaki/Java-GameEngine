package engine._2D.physic;

import engine._2D.Entity2D;
import engine.blueprint.Collider;

public abstract class Collider2D extends Collider{
	public abstract Collision2D collide(Entity2D that);
}
