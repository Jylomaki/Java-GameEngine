package engine._2D.physic;

import engine._2D.Entity2D;
import engine._2D.Vector2D;
import engine.blueprint.Collision;

public class Collision2D extends Collision {
	// collision point
	public Vector2D collision_point;
	// collision normale
	public Vector2D normal_at_impact;
	
	//ref to entity collided
	public Entity2D collidedEntity;

	public Collision2D(Vector2D collision_point, Vector2D normal_at_impact, Entity2D collidedEntity) {
		super();
		this.collision_point = collision_point;
		this.normal_at_impact = normal_at_impact;
		this.collidedEntity = collidedEntity;
	}
	
	public Collision2D reciproc(Entity2D other) {
		return new Collision2D(this.collision_point, Vector2D.time(this.normal_at_impact, -1), other);
	}
}
