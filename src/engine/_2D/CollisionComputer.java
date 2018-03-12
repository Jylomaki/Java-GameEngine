package engine._2D;

import java.util.ArrayList;

import engine._2D.physic.Collision2D;

public class CollisionComputer {
	ArrayList<Entity2D> entities;
	public boolean debug= false;
	
	public CollisionComputer(ArrayList<Entity2D> entities) {
		super();
		this.entities = entities;
	}

	public void update() {
		for(int i=0; i< entities.size(); i++) {
			Entity2D a = entities.get(i);
			if(a.activeHitBox)
				for(int j=i+1; j< entities.size(); j++) {
					Entity2D b = entities.get(j);
					if(b.activeHitBox) {
						Collision2D c = a.collider.collide(b);
						if(c != null) {
							if(debug)
								System.out.println("CollisionComputer: A collision was detected");
							a.addCollision(c);
							b.addCollision(c.reciproc(a));
						}
					}
				}
		}
	}
}
