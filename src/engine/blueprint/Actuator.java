package engine.blueprint;
/***
 * Things that make stuff do things like change and move
 * @author Jylomaki
 *
 */
public abstract class Actuator{// need adding <T extends Entity>
	public abstract void update(Entity e, float time);
}
