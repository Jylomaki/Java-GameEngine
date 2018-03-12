package engine._2D;

import java.awt.geom.Point2D;

public class Vector2D extends Point2D{
	private double x;
	private double y;
	
	public Vector2D(){
		super();
		x=0f;
		y=0f;
	}
	
	/**
	 * Setter in order to not break reference
	 * @param a
	 */
	public void set(Vector2D a) {
		x= a.x;
		y= a.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vector2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double length() {
		return length(this);
	}
	public Vector2D time_in_place(double b) {
		x *= b;
		y *= b;
		return this;
	}
	public Vector2D time_in_place(Vector2D b) {
		x *= b.x;
		y *= b.y;
		return this;
	}
	public Vector2D add_in_place(Vector2D b) {
		x += b.x;
		y += b.y;
		return this;
	}
	public Vector2D sub_in_place(Vector2D b) {
		x -= b.x;
		y -= b.y;
		return this;
	}
	
	public Vector2D sub_copy(Vector2D b) {
		return Vector2D.sub(this, b);
	}
	public Vector2D add_copy(Vector2D b) {
		return Vector2D.add(this, b);
	}
	
	public Vector2D linearScale_in_place(double f) {
		x = Math.pow(x, f);
		y = Math.pow(y, f);
		return this;
	}
	
	
	public static double dot(Vector2D a, Vector2D b) {
		return a.x * b.x + a.y * b.y;
	}
	public static Vector2D time(Vector2D a, double b) {
		return new Vector2D(a.x*b, a.y*b);
	}
	
	public static Vector2D add(Vector2D a, Vector2D b) {
		return new Vector2D(a.x+b.x, a.y+b.y);
	}
	
	public static Vector2D sub(Vector2D a, Vector2D b) {
		return new Vector2D(a.x-b.x, a.y-b.y);
	}
	
	public static double length(Vector2D a) {
		return Math.sqrt(a.x*a.x + a.y*a.y);
	}
	
	public static Vector2D time(Vector2D a, Vector2D b) {
		return new Vector2D(a.x*b.x,a.y*b.y);
	}
	public static Vector2D halfwayVector(Vector2D a, Vector2D b) {
		return new Vector2D((a.x+b.x)*0.5f,(a.y+b.y)*0.5f);
	}
	public static Vector2D normalized(Vector2D a) {
		double len = (double)a.length();
		return new Vector2D(a.x/len, a.y/len);
	}
	
	public Vector2D time_copy(double f) {
		return Vector2D.time(this, f);
	}
	/**
	 * return a 
	 * @param a the vector to factor scale
	 * @param f the factor of scaling
	 * @return scaling factored scaling factor
	 */
	public static Vector2D linearScale_copy(Vector2D a, double f) {
		return new Vector2D(Math.pow(a.x, f), Math.pow(a.y, f));
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	/*static Vector2D vec_by_mat(Vector2D v, Matrix m) {
		return new Vector2D();
	}*/

	@Override
	public void setLocation(double x, double y) {
		this.setX(x);
		this.setY(y);
		
	}
}
