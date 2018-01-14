package engine._2D;

import java.util.ArrayList;
import java.util.Hashtable;

import display._2D.SpriteBuffer;
import engine.MemoryManager;
import engine.Tags;
import engine._2D.physic.Collider2D;
import engine._2D.physic.ColliderDisk;
import engine._2D.physic.Collision2D;
import engine.blueprint.Actuator;
import engine.blueprint.Entity;

public class Entity2D extends Entity{
	public boolean debug=false;
	public Transformation2D position,speed;
	public SpriteBuffer sprite;
	public ArrayList<Tags> tags;
	public Hashtable<String,Entity2D> childEntities;
	public boolean activeHitBox, activeDisplay;
	//Override
	public Collider2D collider;
	public ArrayList<Collision2D> collisions;
	
	private ArrayList<Actuator> actuator_to_be_removed;
	private ArrayList<Entity> childEntity_to_remove;
	
	
	public Entity2D() {
		this.position = new Transformation2D();
		this.speed = new Transformation2D();
		this.tags = new ArrayList<Tags>();
		this.activeDisplay = false;
		this.activeHitBox = false;
		
		this.childEntities = new Hashtable<String,Entity2D>();
		this.collisions = new ArrayList<Collision2D>();
		
		this.actuator_to_be_removed = new ArrayList<Actuator>();
		this.childEntity_to_remove = new ArrayList<Entity>();
	}
	
	public static Entity2D newEntity() {
		return MemoryManager.allocate_entity();
	}
	
	//Tags managing:
	public void addTag(Tags t) {
		tags.add(t);
	}
	public boolean removeTag(Tags t) {
		return tags.remove(t);
	}
	public ArrayList<Tags> getTags(){
		return tags;
	}
	public boolean hasTag(Tags t) {
		return tags.contains(t);
	}
	
	public void clean() {
		tags= new ArrayList<Tags>();
		this.childEntities = new Hashtable<String,Entity2D>();
		return ;	
	}
	
	/**
	 * 
	 */
	public void toggleDisplay() {
		this.activeDisplay = ! this.activeDisplay;
	}
	public void enableDisplay() {
		this.activeDisplay = true;
	}
	public void disableDisplay() {
		this.activeDisplay = false;
	}

	public void addColliderDiskFromSprite() {
		this.collider = new ColliderDisk(this.sprite.centerPoint, this.position.getTranslate(), this.sprite.radius);
		this.activeHitBox = true;
	}
	
	public void addCollision(Collision2D c) {
		this.collisions.add(c);
	}
	@Override
	public void update(float timeElapsed) {
		position.concatenate_in_place(speed.factor_copy(timeElapsed));
		for(int i=0; i<this.actuators.size(); i++) {
			Actuator a = this.actuators.get(i);
			a.update(this, timeElapsed);
		}
		if(debug) {
				System.out.println("position:" + position.getTranslate());
				System.out.println("Speed:" + speed.getTranslate());
				System.out.println("rotation:" + position.getRotation());
				System.out.println("RotationSpeed:" + speed.getRotation());
				System.out.println("display: " + this.activeDisplay);
		}
		if(!this.actuator_to_be_removed.isEmpty()){
			this.actuators.removeAll(actuator_to_be_removed);
			this.actuator_to_be_removed.clear();
		}
		if(!this.childEntity_to_remove.isEmpty()) {
			//TODO
		}
		this.collisions.clear();
	}
	
	public void remove(Actuator a) {
		this.actuator_to_be_removed.add(a);
	}
	public void remove(Entity e) {
		this.childEntity_to_remove.add(e);
	}
}
