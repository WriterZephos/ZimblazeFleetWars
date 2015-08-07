package units;

import java.awt.geom.Rectangle2D;

public interface Unit { //this interface is for anything that exists on the gameboard

	public abstract void setContainingRect(double alpha);
	
	public abstract Rectangle2D.Double getContainingRect();
	
	public abstract double getXGamePosition();
	
	public abstract double getYGamePosition();

	public abstract double getXPosition();
	
	public abstract double getYPosition();
}
