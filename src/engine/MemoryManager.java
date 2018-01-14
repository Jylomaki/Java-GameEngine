package engine;

import java.util.ArrayList;

import engine._2D.Entity2D;

public class MemoryManager {
	// store an array list of entity, used, and unused
	public static ArrayList <Entity2D> used;
	public static ArrayList <Entity2D> unused;
	
	public static Entity2D allocate_entity() {
		if(unused.size() == 0) {
			Entity2D e = new Entity2D();
			used.add(e);
			return e;
		}
		else {
			Entity2D e = unused.remove(0);
			used.add(e);
			return e;
		}
	}
	
	public static int freeEntity(Entity2D e) {
		//TODO
		return 0;
	}
}
