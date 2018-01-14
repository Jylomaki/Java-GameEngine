package engine;

public class FPS_counter {
	long lastTime;
	long periode_ns;
	double periode_S;
	double lastFPS;
	public boolean refreshed;
	int currentFrameCount;
	public FPS_counter(double refreshPeriod) {
		periode_ns = (long)(refreshPeriod * 1000000000);
		periode_S = refreshPeriod;
	}
	
	public void update() {
		currentFrameCount++;
		long currentTime = System.nanoTime();
		long elapsedTime = currentTime - lastTime;
		if(elapsedTime >= periode_ns) {
			this.refreshed = true;
			lastTime = currentTime;
			lastFPS = this.currentFrameCount/this.periode_S;
			this.currentFrameCount =0;
		}
	}
	public double FPS() {
		this.refreshed = false;
		return this.lastFPS;
	}
}
