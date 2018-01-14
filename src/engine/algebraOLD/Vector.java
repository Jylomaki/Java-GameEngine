package engine.algebraOLD;

public class Vector {
	float[] v4;
	float[] v3;
	
	public Vector() {
		this(0f,0f,0f);
		
	}
	
	public Vector(float x, float y, float z){
		v3 = new float[]{x,y,z};
		v4 = new float[] {x,y,z,1.0f};
	}
	
	public float dot(Vector that) {
		return Operations.dot(this, that);
	}
	
	public Vector time(float a) {
		return Operations.time(this, a);
	}
}
