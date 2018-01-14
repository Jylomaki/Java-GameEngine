package engine._2D;

import java.awt.geom.AffineTransform;

public class Transformation2D {
	public Transformation2D parent;
	
	public boolean debug=false;
	private Vector2D translate;
	private Vector2D scale;// if used as speed, 0 is null speed, positive for growing, negative for shrinking
	public Vector2D getTranslate() {
		return translate;
	}


	public void setTranslate(Vector2D translate) {
		this.translate.set(translate);
	}


	public Vector2D getScale() {
		return scale;
	}


	public void setScale(Vector2D scale) {
		this.scale.set(scale);
	}


	public double getRotation() {
		return rotation;
	}


	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public double rotation;//in radians
	
	public Transformation2D(Vector2D position, Vector2D scale, double rotation) {
		super();
		this.translate = position;
		this.scale = scale;
		this.rotation = rotation;
	}
	
	
	public Transformation2D() {
		super();
		this.translate = new Vector2D();
		this.scale = new Vector2D(1f,1f);
		this.rotation = 0f;
	}
	
	public AffineTransform toAffinetransform(Vector2D pivot) {
		if(debug) {
			System.out.println("position:" + translate);
			System.out.println("scale:" + scale);
			System.out.println("rotation:" + rotation);
			System.out.println("pivot:" + pivot);
		}
		AffineTransform at = AffineTransform.getRotateInstance(rotation, pivot.getX(),pivot.getY());
		if(debug)
			System.out.println("at.rotate:" + at);
		at.scale(scale.getX(), scale.getY());
		if(debug)
			System.out.println("at.scale:" + at);
		at.translate(translate.getX(), translate.getY());
		if(debug)
			System.out.println("at.translate:" + at);
		return at;
	}
	
	public void concatenate_in_place(Transformation2D b) {
		this.translate.add(b.translate);
		this.scale.time(b.scale);
		this.rotation += b.rotation;
	}
	
	public Transformation2D concatenate_copy(Transformation2D b) {
		return new Transformation2D(	Vector2D.add(this.translate, b.translate),
									Vector2D.time(this.scale,b.scale),
									this.rotation+b.rotation);
	}
	
	public void factor_in_place(double f) {
		this.translate.time(f);
		this.scale.linearScale(f);
		this.rotation *= f;
	}
	
	public Transformation2D factor_copy( double f) {
		return new Transformation2D(Vector2D.time(translate, f),Vector2D.linearScale(scale, f),this.rotation*f);
	}
	
}
