package engine._2D;

public class Vector2D {
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
	public void time(double b) {
		x *= b;
		y *= b;
	}
	public void time(Vector2D b) {
		x *= b.x;
		y *= b.y;
	}
	public void add(Vector2D b) {
		x += b.x;
		y += b.y;
	}
	public void sub(Vector2D b) {
		x -= b.x;
		y -= b.y;
	}
	public void linearScale(double f) {
		x = Math.pow(x, f);
		y = Math.pow(y, f);
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
	public static Vector2D linearScale(Vector2D a, double f) {
		return new Vector2D(Math.pow(a.x, f), Math.pow(a.y, f));
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	/*static Vector2D vec_by_mat(Vector2D v, Matrix m) {
		return new Vector2D();
	}*/
}
