package engine.algebraOLD;

public class Operations {

	static float dot(Vector a, Vector b) {
		return a.v3[0] * b.v3[0] + a.v3[1] * b.v3[1] + a.v3[2] * b.v3[2];
	}
	static Vector time(Vector a, float b) {
		return new Vector(a.v3[0]*b,a.v3[1]*b, a.v3[2]*b);
	}
	
	static Vector add(Vector a, Vector b) {
		return new Vector(a.v3[0]+b.v3[0],a.v3[1]+b.v3[1],a.v3[2]+b.v3[2]);
	}
	
	static Vector time(Vector a, Vector b) {
		return new Vector(a.v3[0]*b.v3[0],a.v3[1]*b.v3[1],a.v3[2]*b.v3[2]);
	}
	
	static Vector vec_by_mat(Vector v, Matrix m) {
		return new Vector();
	}
}
