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
	private Collision2D collideDisk(Entity2D e) {
		Collision2D c = null;
		ColliderDisk thatCollider = (ColliderDisk) e.collider;
		Vector2D thatCenterPoint = Vector2D.add(thatCollider.centerPoint, thatCollider.position);
		Vector2D thisCenterPoint = Vector2D.add(this.centerPoint, this.position);
		
		Vector2D centerToCenter = Vector2D.sub(thisCenterPoint, thatCenterPoint);
		if(centerToCenter.length() < this.radius + thatCollider.radius) {
			Vector2D normal = Vector2D.normalized(centerToCenter);
			Vector2D collisionPoint = Vector2D.add(thatCenterPoint, Vector2D.time(normal, thatCollider.radius));
			
			c = new Collision2D(collisionPoint, normal, e);
		}
		
		return c;
	}

}
