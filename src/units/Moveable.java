package units;

public interface Moveable { //this interface is for anything that can move
	
	public abstract void setCourse(double stop, double x, double y);
	
	public abstract void setRotation(double rotation);
	
	public abstract void setOrientation(double alpha);
	
	public abstract double getOrientation();
	
	public abstract double getXGamePosition();
	
	public abstract double getYGamePosition();

	public abstract double getXPosition();
	
	public abstract double getYPosition();
	
	public abstract boolean isMoving();
	
	public abstract boolean isRotating();
}
