package framework;

public class Settings {  
	
	Settings(){
		movementSpeed = 200;  //number of pixels a ship moves per second
		fps = 120;
		attackSpeed = 400;
	}
	
	private double movementSpeed;
	private int fps;
	private int attackSpeed;
	
	public double getMovementSpeed() {
		return movementSpeed / fps;
	}
	
	public double getAttackSpeed() {
		return attackSpeed / fps;
	}

	public void setMovementSpeed(int mSpeed) {
		movementSpeed = mSpeed;
	}
	
	public double getFPS() {
		return fps;
	}

	public void setFPS(int frameRate) {
		fps = frameRate;
	}
	
}
