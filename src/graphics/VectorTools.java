package graphics;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import units.Collideable;
import units.Moveable;
import units.Offensive;
import units.Ship;
import units.Unit;
import framework.GameManager;
import framework.Settings;

public class VectorTools {
	
	// Range Finders
	
	/**
	 * Method - Returns true if a given point is within or equal to the given range from another point. Returns false otherwise.
	 * @param one
	 * @param two
	 * @param range
	 * @return true or false
	 */
	public static boolean isWithinOrEqualDistance(Point one, Point two, int range){

		if(one.distance(two) <= range){
			return true;
		} else {
			return false;
		}		
	}
	
	/**
	 * Method - returns true if a given point is within the given range from another point. Returns false otherwise.
	 * This method is exclusive, so a distance between the points that is equal to the range returns false.
	 * @param one
	 * @param two
	 * @param range
	 * @return true or false
	 */
	public static boolean isWithinDistance(Point one, Point two, int range){

		if(one.distance(two) < range){
			return true;
		} else {
			return false;
		}		
	}

	//Distance Finders
	
	/** Method - This method takes the Point position objects of two ships as parameters, calculates the distance between them, 
	 * then returns the value.
	*/
	public static double distanceFormulaP(Point one, Point two){
		return one.distance(two);
		
	}
	
	public static double distanceFormulaD(double x1, double y1, double x2, double y2){
		
		double side1 = x1 - x2;
		double side2 = y1 - y2;
		return Math.hypot(side1, side2); 
	}

	//Collision Finders
	
	/**
	 * Method - this method takes a ship and a point, generates a hypothetical rectangle where the ship wants to move
	 * and tests for collisions.
	 * @param c The ship that wants to move
	 * @param one The point where the ship wants to move. (where the mouse cursor is, for players)
	 * @return True if a collision was detected, false if not.
	 */
	public static boolean isColliding(Collideable c, Point one){ //converted to double
		
		boolean collision = false;
		
		//Next two lines generate a hypothetical rectangle at the given point to test.
		double theta = getAngle(c,one);
		Rectangle2D testRect = imagineContainingRect(theta, c.getImageWidth(), c.getImageHeight(), one);
		
		//these lines test if the hypothetical rectangle would cause a collision.
		if (GameManager.getCurrentFleet().parallelStream().filter((pS) -> !(pS == c)).anyMatch((pS) -> testRect.intersects(pS.getContainingRect()))){
			collision = true;
			return collision;
		} else if (GameManager.getCurrentComputerFleet().parallelStream().filter((pS) -> !(pS == c)).anyMatch((eS) -> testRect.intersects(eS.getContainingRect()))){
			collision = true;
			return collision;
		}
		
		return collision;
	}
	
	public static boolean isColliding(Collideable c, Point one, double beta){ //converted to double
		
		boolean collision = false;
		
		//Next two lines generate a hypothetical rectangle at the given point to test.
		double theta = beta;
		Rectangle2D testRect = imagineContainingRect(theta, c.getImageWidth(), c.getImageHeight(), one);
		
		//these lines test if the hypothetical rectangle would cause a collision.
		if (GameManager.getCurrentFleet().parallelStream().filter((pS) -> !(pS == c)).anyMatch((pC) -> testRect.intersects(pC.getContainingRect()))){
			collision = true;
			return collision;
		}  /*else if (GameManager.getCurrentComputerFleet().parallelStream().filter((pS) -> !(pS == c)).anyMatch((eC) -> testRect.intersects(eC.getContainingRect()))){
			collision = true;
			return collision;
		} */
		
		return collision;
	}
	
	public static boolean isColliding(Collideable c, double beta){ //converted to double
		
		boolean collision = false;
		
		//Next two lines generate a hypothetical rectangle at the given point to test.
		double theta = beta;
		Point testPoint = new Point((int) Math.rint(c.getXGamePosition()), (int) Math.rint(c.getYGamePosition()));
		Rectangle2D testRect = imagineContainingRect(theta, c.getImageWidth(), c.getImageHeight(), testPoint);
		
		//these lines test if the hypothetical rectangle would cause a collision.
		if (GameManager.getCurrentFleet().parallelStream().filter((pS) -> !(pS == c)).anyMatch((pC) -> testRect.intersects(pC.getContainingRect()))){
			collision = true;
			return collision;
		}  /*else if (GameManager.getCurrentComputerFleet().parallelStream().filter((pS) -> !(pS == c)).anyMatch((eC) -> testRect.intersects(eC.getContainingRect()))){
			collision = true;
			return collision;
		} */
		
		return collision;
	}
	
	/**
	 * Method - This method is a modified version of the Ship class's setContainingRect method. 
	 * It takes in a few additional parameters, and instead of setting the container field, it simply returns a 
	 * Rectangle2D object.
	 * 
	 * The purpose of this is for collision testing, to see if the ship would collide with anything if it assumed the
	 * hypothetical orientation and location.
	 * @param alpha Orientation of the rectangle/ Ship - this is a hypothetical value.
	 * @param imageHeight A Ship image's height.
	 * @param imageWidth A Ship image's width.
	 * @param one The location of the hypothetical/ imagined rectangle. This is a hypothetical point, 
	 * corresponding to the Ship's actual position, not the gamePosition..
	 * @return Hypothetical Rectangle2D.double object.
	 */
	private static Rectangle2D imagineContainingRect(double alpha, int imageWidth, int imageHeight, Point one){ 
		
		double containerWidth;
		double containerHeight;
		double theta = 0;
		double beta = (Math.PI / 2) - theta;
		
		if (alpha <= (Math.PI / 2)){
			
			theta = alpha;
			beta = (Math.PI / 2) - theta;
			
		} else if(alpha > (Math.PI / 2) && alpha <= Math.PI){
	
			beta = (Math.PI / 2) - (Math.PI - alpha);
			theta = (Math.PI / 2) - beta;
			
		} else if(alpha > Math.PI && alpha <= ((3 * Math.PI) / 2)){
	
			beta = (Math.PI / 2) - Math.abs((Math.PI - alpha));
			theta = (Math.PI / 2) - beta;
		}
		else if (alpha > (3 * (Math.PI / 2)) && Math.abs(alpha) <= (2 * Math.PI)){
			
			beta = (Math.PI / 2) - ((2 * Math.PI) - alpha);
			theta = (2 * Math.PI) - alpha;
			
		}
		
		containerWidth = (Math.sin(beta) * imageWidth) + (Math.sin(theta) * imageHeight);
		containerHeight = (Math.sin(theta) * imageWidth) + (Math.sin(beta) * imageHeight);
		
		return new Rectangle2D.Double(Math.rint(one.x - (containerWidth / 2)), (int) Math.rint(one.y - (containerHeight / 2)), containerWidth, containerHeight);
		
	}
		
	public static Optional<Unit> getContainingObject(Point one){ //converted to double
		
		Optional<Unit> containingObject;
		//these lines test if any units contain the hypothetical point and return an object containing the first one it finds, or a null reference.
			
		containingObject = GameManager.getCurrentFleet().parallelStream().map(pS -> (Unit) pS).filter(pS -> pS.getContainingRect().contains(one)).findFirst();
		
		return containingObject;
	}

	//Course Finders
	
	/**
	 * Method - This simple method takes two points and calculates the slope between them.
	 * @param a First point.
	 * @param b Second Point.
	 * @return double - Slope between the two points.
	 */
	public static double getSlope(double aX, double aY, double bX, double bY){ // converted to double, this method is not being used (I think). Remove it? 
		
		double slope = (aY - bY) / (aX - bX);
		return slope;
	}
	
		/**
	 * Method - This method finds the incremental slope between a ship and another point, 
	 * then calculates the incremental slope which is the amount that ship's coordinates
	 * should change each time its position is updated. This change is what 
	 * animates the Ship.
	 * @param m The moving Ship.
	 * @param b Point where the ship is moving to.
	 * @return Point object, which includes the x value of change and the y value of 
	 * change.
	 */
	public static double findCourseY(Moveable m,  Point b){ //converted to double
		
		double mX = m.getXGamePosition();
		double mY = m.getYGamePosition();
		
		double distance = distanceFormulaD(mX, mY, b.x, b.y);
		double divider = distance / GameManager.getMySettings().getMovementSpeed();
		double rise = (mY - b.y) / divider;
		double run = (mX - b.x) / divider;
		return rise;

	}
	
	public static double findCourseX(Moveable m,  Point b){ //converted to double
		
		double mX = m.getXGamePosition();
		double mY = m.getYGamePosition();
		
		double distance = distanceFormulaD(mX, mY, b.x, b.y);
		double divider = distance / GameManager.getMySettings().getMovementSpeed();
		double rise = (mY - b.y) / divider;
		double run = (mX - b.x) / divider;
		return run;

	}
	
	public static double findAttackCourseY(Offensive o,  Point b){ //converted to double
		
		double mX = o.getAttackOriginX();
		double mY = o.getAttackOriginY();
		
		double distance = distanceFormulaD(mX, mY, b.x, b.y);
		double divider = distance / GameManager.getMySettings().getAttackSpeed();
		double rise = (mY - b.y) / divider;
		double run = (mX - b.x) / divider;
		return rise;

	}
	
	public static double findAttackCourseX(Offensive o,  Point b){ //converted to double
		
		double mX = o.getAttackOriginX();
		double mY = o.getAttackOriginY();
		
		double distance = distanceFormulaD(mX, mY, b.x, b.y);
		double divider = distance / GameManager.getMySettings().getAttackSpeed();
		double rise = (mY - b.y) / divider;
		double run = (mX - b.x) / divider;
		return run;

	}
	
	/**
	 * Method - this method is similar to findCourse method, but instead of finding and
	 * returning the incremental slope, it finds and returns the number of times the 
	 * incremental slope should be implemented. In other words, it tells the ship when 
	 * to stop moving.
	 * @param m The moving Ship.
	 * @param b Point where the ship is moving to.
	 * @return int value which is the number of times to increment the slope.
	 */
	
	public static double findStop(Moveable m, Point b){ //converted to double
		
		double mX = m.getXGamePosition();
		double mY = m.getYGamePosition();
		
		double distance = distanceFormulaD(mX, mY, b.x, b.y);
		double stopCounter = distance / GameManager.getMySettings().getMovementSpeed();
		return stopCounter;
	}
	
	public static double findAttackStop(Offensive o, Point b){ //converted to double
		
		double mX = o.getAttackOriginX();
		double mY = o.getAttackOriginY();
		
		double distance = distanceFormulaD(mX, mY, b.x, b.y);
		double stopCounter = distance / GameManager.getMySettings().getAttackSpeed();;
		return stopCounter;
	}
	
	
	
	
	// Angle Finders
	
	/**
	 * Method - this method calculates the angle from the standard position (x axis) of a line that starts at the
	 * position of a Collideable, and ends at a given point (usually the mouse cursor). It returns the angle in a range of 0 to 360 degrees, 
	 * but in radians (0 to 2PI).
	 * @param ship The Collideable where the line begins.
	 * @param one The point where the vector ends.
	 * @return double The angle Alpha in radians.
	 */
	public static double getAngle(Collideable c, Point one){ //converted to double
		
		double cX = c.getXGamePosition();
		double cY = c.getYGamePosition();
		double opposite = distanceFormulaD(one.x, cY, one.x, one.y); // this gives the vertical side length
		double adjacent = distanceFormulaD(one.x, cY, cX, cY); // this gives the horizontal side length
		double alpha = 0;
		
		if (opposite == 0 && one.x > cX){
			alpha =  0.0;
			
		} else if (opposite == 0 && one.x < cX){
			alpha = Math.PI;
			
		} else if (adjacent == 0 && one.y < cY){
			alpha =  Math.PI / 2;
			
		} else if (adjacent == 0 && one.y > cY){
			alpha =  3 * Math.PI / 2;
			
		} else if (one.x > cX && one.y < cY){ // if point is in first quadrant (0 to 90 degrees).
			alpha = Math.atan(opposite/adjacent); //no compensation, assigning the first result.
			
		} else if (one.x < cX && one.y < cY){ // if point is in second quadrant (90 to 180 degrees).
			alpha = Math.atan(-1 * (opposite/adjacent)) + Math.PI; // compensation, making negative and adding 180 degrees.

		} else if (one.x < cX && one.y > cY){ // if point is in third quadrant (180 to 270 degrees).
			alpha = Math.atan(opposite/adjacent) + Math.PI; //compensation, adding 180 degrees to positive result.

		} else if (one.x > cX && one.y > cY){ // if point in in fourth quadrant (270 to 360 degrees).
			alpha = Math.atan(-1 * (opposite/adjacent)) + (2 * Math.PI); //compensation, applying negative and adding 360 degrees. 
		
		}
		
		return alpha;
	}

	/**
	 * Method - this method calculates the angle from the standard position (x axis) of a line that starts at the
	 * position of a Moveable, and ends at a given point (usually the mouse cursor). It returns the angle in a range of 0 to 360 degrees, 
	 * but in radians (0 to 2PI).
	 * @param ship The Moveable where the line begins.
	 * @param one The point where the vector ends.
	 * @return double The angle Alpha in radians.
	 */
	public static double getAngle(Moveable m, Point one){ //converted to double
		
		double mX = m.getXGamePosition();
		double mY = m.getYGamePosition();
		double opposite = distanceFormulaD(one.x, mY, one.x, one.y); // this gives the vertical side length
		double adjacent = distanceFormulaD(one.x, mY, mX, mY); // this gives the horizontal side length
		double alpha = 0;
	
		if (opposite == 0 && one.x > mX){
			alpha =  0.0;
			
		} else if (opposite == 0 && one.x < mX){
			alpha = Math.PI;
			
		} else if (adjacent == 0 && one.y < mY){
			alpha =  Math.PI / 2;
			
		} else if (adjacent == 0 && one.y > mY){
			alpha =  3 * Math.PI / 2;
			
		} else if (one.x > mX && one.y < mY){ // if point is in first quadrant (0 to 90 degrees).
			alpha = Math.atan(opposite/adjacent); //no compensation, assigning the first result.
			
		} else if (one.x < mX && one.y < mY){ // if point is in second quadrant (90 to 180 degrees).
			alpha = Math.atan(-1 * (opposite/adjacent)) + Math.PI; // compensation, making negative and adding 180 degrees.

		} else if (one.x < mX && one.y > mY){ // if point is in third quadrant (180 to 270 degrees).
			alpha = Math.atan(opposite/adjacent) + Math.PI; //compensation, adding 180 degrees to positive result.

		} else if (one.x > mX && one.y > mY){ // if point in in fourth quadrant (270 to 360 degrees).
			alpha = Math.atan(-1 * (opposite/adjacent)) + (2 * Math.PI); //compensation, applying negative and adding 360 degrees. 
		
		}
		
		return alpha;

	}
	
	public static double getRotation(Moveable m, double theta){

		double orientationDiff = (Math.PI * 2) - m.getOrientation();
		double newDiff = (Math.PI * 2) - theta;
		
		double rotation = orientationDiff - newDiff;
		
		if (rotation > Math.PI) rotation -= (Math.PI * 2);
		
		if (rotation < (-1 * Math.PI)) rotation += (Math.PI * 2);
		
		return rotation;
		
	}
	
	public static double getRotationCounter(Moveable m, double theta){

		double rotation;
		double divider = Math.PI / (3 * GameManager.getMySettings().getFPS());
		
		double bigger = (m.getOrientation() > theta) ? m.getOrientation() : theta;
		double smaller = (m.getOrientation() <= theta) ? m.getOrientation() : theta;
		
		if ((bigger - smaller) < ((smaller + (Math.PI * 2)) - bigger)){
			int multiplier = 1;
			if (m.getOrientation() > theta) multiplier = -1;
			
			rotation = (bigger - smaller) * multiplier;
			
		} else {
			int multiplier = 1;
			if (m.getOrientation() < theta) multiplier = -1;
			rotation = ((smaller + Math.PI) - bigger) * multiplier;
		}
		
		return (rotation/(rotation / divider));
		
	}
	



	
}
