package testing.valid.control;

import engine._2D.Entity2D;
import engine._2D.Scene2D;
import engine._2D.Vector2D;
import game.spriteManager.SpriteManager;

public class TestScene_Actuator extends Scene2D{
	SpriteManager sprites;
	public TestScene_Actuator () {
		
		this.background = new Entity2D();
		this.background.disableDisplay();
		Entity2D entity = new Entity2D();
		sprites = new SpriteManager();
		entity.enableDisplay();
		entity.sprite = SpriteManager.pickable.ultimate;
		entity.speed.rotation = (float) Math.toRadians((double)90);
		entity.position.setTranslate(new Vector2D(100.0,100.0));
		entity.debug = true;
		entity.addActuator(new TestActuatorController(engine.input.Inputs.keyboard));
		this.entities.add(entity);
	}

}
