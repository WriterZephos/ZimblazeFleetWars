package units;

import java.awt.geom.Rectangle2D;

public interface Collideable { //this interface is for anything that is collidable
	
	public abstract Rectangle2D.Double getContainingRect();
	
	public abstract int getImageWidth();
	
	public abstract int getImageHeight();

	public abstract double getXGamePosition();
	
	public abstract double getYGamePosition();
}
