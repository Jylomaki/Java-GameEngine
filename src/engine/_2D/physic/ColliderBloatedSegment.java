package engine._2D.physic;

import java.awt.geom.AffineTransform;

import engine._2D.Entity2D;
import engine._2D.Transformation2D;
import engine._2D.Vector2D;
import engine.blueprint.Collision;
import engine.blueprint.Entity;

/**
 * An area that extends from a vector in all direction
 * @author Jylomaki
 *
 */
public class ColliderBloatedSegment extends Collider2D{
	public boolean debug=false;
	public Vector2D a,b;
	private Vector2D actual_a,actual_b;
	public Transformation2D transform;
	public double radius;
	
	
	public ColliderBloatedSegment(Vector2D a, Vector2D b, Transformation2D transform) {
		this(a,b,transform, 0);
	}

	public ColliderBloatedSegment(Vector2D a, Vector2D b, Transformation2D transform, double radius) {
		super();
		this.a = a;
		this.b = b;
		this.transform = transform;
		this.radius = radius;
		
		this.actual_a = new Vector2D();
		this.actual_b = new Vector2D();
	}

	@Override
	public Collision2D collide(Entity2D e) {
		this.compute_actuals(actual_a, actual_b);
		if(e.collider instanceof ColliderDisk)
			return collide_Disk( e);
		return null;
	}

	private Collision2D collide_Disk(Entity2D e) {
		// TODO Auto-generated method stub
		// project the collider to the segment line. 
		/*def distance_one_point(self,target):    			
		u = (end_point - start_point )/np.dist(end_point-start_point)

		proj = start_point + np.dot((target-start_point ), u)* u

		if 0<np.dot(end_point - start_point, proj - start_point) < np.dist(end_point-start_point) :#in segment
			result = np.dist(target-proj)
		else:
			dP1 = np.dist(start_point, target)
			dP2 = np.dist(end_point, target)
			result = np.min(dp1,dp2)

		return result
		 * */
		ColliderDisk collider = (ColliderDisk)e.collider;
		Vector2D potential_collision_center = find_closest_point(collider.getActualPosition());
		Collision2D c = null;
		c = ColliderDisk.collision_check(potential_collision_center, this.radius,
				collider.getActualPosition(), collider.radius);
		if( c != null)
			c.collidedEntity = e;
		return c;
	}

	private Vector2D find_closest_point(Vector2D point) {
		Vector2D segment_A_B = actual_a.sub_copy(actual_b);
		Vector2D unit_vector = segment_A_B.time_copy(1.0/segment_A_B.length());
		Vector2D segment_A_C = point.sub_in_place(actual_a);
		Vector2D projection_point = unit_vector.time_in_place(Vector2D.dot(segment_A_C, unit_vector)).add_in_place(actual_a);
		
		double distance_A_pC = this.actual_a.sub_copy(projection_point).length();
		
		if(0<=distance_A_pC && distance_A_pC <= segment_A_B.length())// Case; in segment
			return projection_point;
		
		double distance_A_C = segment_A_C.length();
		double distance_B_C = this.actual_b.sub_copy(point).length();
		if(distance_A_C < distance_B_C)
			return actual_a;
		return actual_b;
	}
	@Override
	public Collision collide(Entity e) {
		if(e instanceof Entity2D)
			return collide((Entity2D) e);
		return null;
	}
	
	private void compute_actuals(Vector2D actual_a, Vector2D actual_b) {
		AffineTransform at = this.transform.toAffinetransform();
		at.transform(this.a, actual_a);
		at.transform(this.b, actual_b);
	}

}
