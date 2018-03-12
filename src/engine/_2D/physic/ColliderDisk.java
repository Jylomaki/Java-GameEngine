package engine._2D.physic;

import engine._2D.Entity2D;
import engine._2D.Vector2D;
import engine.blueprint.Collision;
import engine.blueprint.Entity;

public class ColliderDisk extends Collider2D{
	public boolean debug = false;
	public Vector2D centerPoint, position;
	public double radius;
	
	/**
	 * Parameter are meant to be references, be careful to keep coherence
	 * @param centerPoint
	 * @param position
	 * @param radius
	 */
	public ColliderDisk(Vector2D centerPoint,Vector2D position, double radius) {
		super();
		this.centerPoint = centerPoint;
		this.position = position;
		this.radius = radius;
	}
	
	public Collision collide(Entity e) {
		if(e instanceof Entity2D)
			return this.collide((Entity2D)e);
		if(debug)
			System.out.println("ColliderDisk: this kind of entity is not handled");
		return null;
	}
	
	public Collision2D collide(Entity2D e) {
		if(e.collider == null)
			return null;
		if(e.collider instanceof ColliderDisk) {
			return collideDisk(e);
		}
		if(debug)
			System.out.println("ColliderDisk: This kind of collider is not handled yet");
		return null;
	}
	
	public Vector2D getActualPosition() {
		return centerPoint.add_copy(position);
	}
	
	private Collision2D collideDisk(Entity2D e) {
		Collision2D c = null;
		ColliderDisk thatCollider = (ColliderDisk) e.collider;
		Vector2D thatCenterPoint = Vector2D.add(thatCollider.centerPoint, thatCollider.position);
		Vector2D thisCenterPoint = Vector2D.add(this.centerPoint, this.position);
		
		c = collision_check(thisCenterPoint,  this.radius, thatCenterPoint, thatCollider.radius);
				
		if(c != null)
			c.collidedEntity = e;
		return c;
	}
	
	public static Collision2D collision_check(Vector2D a, double radius_a, Vector2D b, double radius_b) {
		Collision2D c = null;
		Vector2D centerToCenter = Vector2D.sub(a, b);
		if(centerToCenter.length() < radius_a + radius_b) {
			Vector2D normal = Vector2D.normalized(centerToCenter);
			Vector2D collisionPoint = Vector2D.add(b, Vector2D.time(normal, radius_b));
			
			c = new Collision2D(collisionPoint, normal, null);
		}
		return c;
	}

}
