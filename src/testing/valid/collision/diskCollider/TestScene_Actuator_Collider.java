package testing.valid.collision.diskCollider;

import engine._2D.Entity2D;
import engine._2D.Scene2D;
import engine._2D.Vector2D;
import game.spriteManager.SpriteManager;
import testing.valid.control.TestActuatorController;

public class TestScene_Actuator_Collider extends Scene2D{
	SpriteManager sprites;
	public TestScene_Actuator_Collider () {
		sprites = new SpriteManager();
		
		background= new Entity2D();
		this.background.sprite = SpriteManager.background.arena_schematic;
		this.background.enableDisplay();
		this.playable_entity_init();
		this.obstacle_entity_init();
	}
	
	public void playable_entity_init() {
		Entity2D entity = new Entity2D();
		entity.enableDisplay();
		entity.sprite = SpriteManager.pickable.ultimate;
		entity.speed.rotation = (float) Math.toRadians((double)90);
		entity.position.setTranslate(new Vector2D(100.0,100.0));
		entity.debug = false;
		entity.addActuator(new TestActuatorController(engine.input.Inputs.keyboard));
		entity.addActuator(new TestCollider());
		entity.addColliderDiskFromSprite();
		this.entities.add(entity);
	}
	
	public void obstacle_entity_init() {
		Entity2D entity = new Entity2D();
		entity.enableDisplay();
		entity.sprite = SpriteManager.pickable.health;
		entity.speed.rotation = (float) Math.toRadians((double)45);
		entity.position.setTranslate(new Vector2D(300.0,300.0));
		entity.addColliderDiskFromSprite();
		this.entities.add(entity);
	}

}
