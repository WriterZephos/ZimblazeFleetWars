/**
 * This is the superclass for all ships in the game, making it possible to have an ArrayList of objects of
 * the same type (Ship), and still have different kind of ships (subclasses) in that ArrayList. The subclasses
 * are simply cast to their superclass for most purposes, including all methods and fields that are common among all
 * ship types.
 * 
 * This super class is an Abstract class, meaning that it can only be instantiated through one of its subclasses. There can be
 * no Ship that isn't a fighter, bomber, or another one of the sub classes. All abstract methods in this class must be implemented 
 * its subclasses.
 * 
 * The variation between Ships comes from the subclasses, which when created call the superclass constructor and 
 * pass in the necessary values for Ship fields that are common among all Ships, but the values themselves are unique 
 * to that sub type. These fields are typically the only things that vary between Ship types, unless the sub type has 
 * methods or fields that are unique. In this case, the Ship would have to be cast down to its sub type to access them.
 */
package units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Optional;

import javax.swing.JLabel;

import attacks.AbstractAttack;
import attacks.AttackManager;
import framework.GameManager;
import graphics.VectorTools;
import player.Player;

public abstract class Ship extends JLabel implements Unit,Selectable,  Moveable, Collideable, Offensive {
	
	// Ship Stats:
	
	private ShipType shipType;
	
	private int maxHealthPower;
	private int maxArmorPower;
	private int maxSpeedPower;
	private int maxAttackPower;
	private int maxAccuracyPower;
	private int maxRangePower;
	private int maxSpecialPower;
	
	private int healthPower;
	private int armorPower;
	private int speedPower;
	private int attackPower;
	private int accuracyPower;
	private int rangePower;
	private int specialPower;
	private final ZFleet fleetName;
	private final Player playerName;
	
	// Ship Graphics Variables:
	
	private boolean selected = false;
	private double positionX = 0;
	private double positionY = 0;
	private double courseX = 0;
	private double courseY = 0;
	private double moveCounter = 0;
	private ShipStatus status = ShipStatus.DEFAULT;
	private boolean rotating = false;
	private double rotationIncrement;
	private double rotationCounter;
	private final int xOffset; // x and y offsets are to determine where the center of the ship is.
	private final int yOffset;
	private final int imageWidthX; //This is the width of the Ship's image. 
	private final int imageHeightY; //This is the height of the Ship's image 
	private double orientation = 0;
	private BufferedImage spriteDefault;  //need to load and initialize
	private Rectangle2D.Double container;
	
	
	/**
	 * Constructor - requires necessary values to assign to common Ship fields, which are passed by the call to this 
	 * constructor from the constructor of the sub type.
	 * 
	 * The fleetName and playerName fields are not specific to the sub type, but will be passed to the sub type, 
	 * and then to this constructor when the sub type is created. 
	 * @param type
	 * @param healthP
	 * @param armorP
	 * @param speedP
	 * @param attackP
	 * @param accuracyP
	 * @param rangeP
	 * @param specialP
	 * @param xOff
	 * @param yOff
	 * @param iWidth
	 * @param iHeight
	 * @param zFleet
	 * @param player
	 */
	Ship(ShipType type, int healthP, int armorP, int speedP, int attackP, int accuracyP, 
			int rangeP, int specialP, int xOff, int yOff, int iWidth, int iHeight, ZFleet zFleet, Player player){
		
		shipType = type;
		
		maxHealthPower = healthP;
		maxArmorPower = armorP;
		maxSpeedPower = speedP;
		maxAttackPower = attackP;
		maxAccuracyPower = accuracyP;
		maxRangePower = rangeP;
		maxSpecialPower = specialP;
		
		
		healthPower = healthP;
		armorPower = armorP;
		speedPower = speedP;
		attackPower = attackP;
		accuracyPower = accuracyP;
		rangePower = rangeP;
		specialPower = specialP;
		
		status = ShipStatus.DEFAULT;
		
		xOffset = xOff; 
		yOffset	= yOff;
		imageWidthX = iWidth;
		imageHeightY = iHeight;
		
		fleetName = zFleet;
		playerName = player;
		
		setOwnRect();
		
	}
	
	/**
	 * Overloaded constructor - adds additional x and y parameters to set the Ship position from the start.
	 * @param type
	 * @param healthP
	 * @param armorP
	 * @param speedP
	 * @param attackP
	 * @param accuracyP
	 * @param rangeP
	 * @param specialP
	 * @param xOff
	 * @param yOff
	 * @param iWidth
	 * @param iHeight
	 * @param fleet
	 * @param player
	 * @param x
	 * @param y
	 */
	Ship(ShipType type, int healthP, int armorP, int speedP, int attackP, int accuracyP, 
			int rangeP, int specialP, int xOff, int yOff, int iWidth, int iHeight, ZFleet fleet, Player player, int x, int y){
		
		shipType = type;
		
		maxHealthPower = healthP;
		maxArmorPower = armorP;
		maxSpeedPower = speedP;
		maxAttackPower = attackP;
		maxAccuracyPower = accuracyP;
		maxRangePower = rangeP;
		maxSpecialPower = specialP;
		
		
		healthPower = healthP;
		armorPower = armorP;
		speedPower = speedP;
		attackPower = attackP;
		accuracyPower = accuracyP;
		rangePower = rangeP;
		specialPower = specialP;
		
		xOffset = xOff; 
		yOffset	= yOff;
		imageWidthX = iWidth;
		imageHeightY = iHeight;
		
		fleetName = fleet;
		playerName = player;
		
		positionX = x;
		positionY = y;
		
		setOwnRect();
		
	}
	
	/**
	 * Overloaded constructor. This constructor allows the Ship to be 
	 * created with a given orientation.
	 * 
	 * @param type
	 * @param healthP
	 * @param armorP
	 * @param speedP
	 * @param attackP
	 * @param accuracyP
	 * @param rangeP
	 * @param specialP
	 * @param xOff
	 * @param yOff
	 * @param iWidth
	 * @param iHeight
	 * @param fleet
	 * @param player
	 * @param x
	 * @param y
	 * @param orient
	 */
	
	Ship(ShipType type, int healthP, int armorP, int speedP, int attackP, int accuracyP, 
			int rangeP, int specialP, int xOff, int yOff, int iWidth, int iHeight, ZFleet fleet, Player player, int x, int y, double orient){
		
		shipType = type;
		
		maxHealthPower = healthP;
		maxArmorPower = armorP;
		maxSpeedPower = speedP;
		maxAttackPower = attackP;
		maxAccuracyPower = accuracyP;
		maxRangePower = rangeP;
		maxSpecialPower = specialP;
		
		
		healthPower = healthP;
		armorPower = armorP;
		speedPower = speedP;
		attackPower = attackP;
		accuracyPower = accuracyP;
		rangePower = rangeP;
		specialPower = specialP;
		
		xOffset = xOff; 
		yOffset	= yOff;
		imageWidthX = iWidth;
		imageHeightY = iHeight;
		
		fleetName = fleet;
		playerName = player;
		
		positionX = x;
		positionY = y;
		orientation = orient;
		
		setOwnRect();
		
	}
	
	public void updateUnit(){
		
		if (rotating) {
			
			setOrientation(orientation + rotationIncrement);
			rotationCounter--;
			setOwnRect();
			if(rotationCounter <= 0){
				rotating = false;
				rotationIncrement = 0.0;
				System.out.println("final " + Math.toDegrees(orientation));
			}
		} else {
			
			switch (status){
			case MOVING:
				positionX -= courseX;
				positionY -= courseY;
				setOwnRect();
				moveCounter--;
				//System.out.println("" + position + course + moveCounter + status);
				if(moveCounter <= 0){
					setStatus(ShipStatus.DEFAULT);
					courseX = 0;
					courseY = 0;
				}
				break;
			case ATTACKING:
				//change sprite, etc.
				break;
			case DEFENDING:
				//change sprite, etc.
				break;
			case EXPLODING:
				//change sprite, etc;
				break;
			case DEFAULT:
				//change sprite, etc.
				break;
			}	
			
		}
		
		
			
		//need to add more checks if the ship is dead, etc.
	}
	
	@Override
	public void select(){
		selected = true;
		System.out.println("selected");
	}
	
	@Override
	public void deselect(){
		selected = false;
	}
	
	@Override
	public boolean getSelected(){
		return selected;
	}
	
	/**
	 * Method - render 
	 * 
	 * This method renders the ship's image, first by rotating the graphics context around the ship's axis 
	 * according to its orientation, then drawing the image according to the original coordinate orientation.
	 * 
	 * The three parameter method call for Graphics2D.rotate is supposed to reset the origin point (0,0) back to the
	 * top left corner of the screen.
	 * 
	 * The original transform of the graphics context is saved and then reset at the end, so that only this ship 
	 * is rotated and not everything else that is drawn afterwards.
	 * 
	 * @param g Graphics context that will be used to draw the ship's image. It will be cast to a Graphics2D
	 * object so that the ship can be rotated using graphics2D methods.
	 */
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.CYAN);
		g2d.draw(container);
		g2d.rotate(-orientation, (int) getXGamePosition(), getYGamePosition());
		
		//g2d.drawImage(spriteDefault, (int) Math.rint(positionX), (int) Math.rint(positionY), null);

		g2d.setColor(Color.ORANGE);
		g2d.fillRect((int) Math.rint(positionX), (int) Math.rint(positionY), imageWidthX, imageHeightY);
		g2d.setColor(Color.RED);
		g2d.fillRect((int) Math.rint(positionX) + 60, (int) Math.rint(positionY), imageWidthX-60, imageHeightY);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval((int) Math.rint(getXGamePosition() - 3), (int) Math.rint(getYGamePosition() - 3), 6, 6);
		g2d.setColor(Color.BLUE);
		//g2d.draw(container);
		if (selected) g2d.drawOval((int) Math.rint(positionX - imageWidthX / 2) , 
				(int) Math.rint(positionY - imageWidthX + imageHeightY/2), imageWidthX * 2, imageWidthX * 2);
		g2d.dispose();
	}
	
	/**
	 * Method - this method sets the containing rectangle for this Ship, which is used for object collision detection.
	 * The containing rectangle is calculated to be as small as possible while still containing the entire image of 
	 * the Ship. Unfortunately it still has corners, but this is unavoidable without pixel by pixel collision detections
	 * which is much more difficult and require more resources.
	 * 
	 * By taking the orientation (angle) of the Ship, it uses trigonometry to calculate the sides of triangles
	 * on either side of the Ship to determine the dimensions of the containing box.
	 * 
	 * The if statements are needed to set the angles of the imaginary triangles correctly, depending on the Ship's
	 * orientation.
	 * 
	 * @param alpha This is the orientation of the Ship, which will determine the dimensions of its containing box.
	 * @param g  This is for testing purposes, to visualize the container box.
	 */
	
	@Override
	public void setContainingRect(double alpha){ 
		
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
		
		containerWidth = (Math.sin(beta) * imageWidthX) + (Math.sin(theta) * imageHeightY);
		containerHeight = (Math.sin(theta) * imageWidthX) + (Math.sin(beta) * imageHeightY);
		
		container = new Rectangle2D.Double(Math.rint(getXGamePosition() - (containerWidth / 2)), 
				(int) Math.rint(this.getYGamePosition() - (containerHeight / 2)), containerWidth, containerHeight);
	}
	
	private void setOwnRect(){
		setContainingRect(getOrientation());
	}
	
	
	// getters
	public double getXPosition(){
		return positionX;
	}
	
	public double getYPosition(){
		return positionY;
	}
	
	/**
	 * Method - This method returns a double representing the Ship's position on the x axis, offset by the xOffset to be in the center of the Ship's image. The Ship rotates 
	 * around this point, and range, movement and all other game functions are 
	 * based around this point.
	 * 
	 * @return point object representing this Ship's game position.
	 */
	@Override
	public double getXGamePosition(){
		double gameXPosition = positionX + xOffset;
		return gameXPosition;
	}
	
	/**
	 * Method - This method returns a double representing the Ship's position on the y axis, offset by the yOffset to be in the center of the Ship's image. The Ship rotates 
	 * around this point, and range, movement and all other game functions are 
	 * based around this point.
	 * 
	 * @return point object representing this Ship's game position.
	 */
	@Override
	public double getYGamePosition(){
		double gameYPosition = positionY + yOffset;
		return gameYPosition;
	}
	
	@Override
	public double getOrientation(){
		return orientation;
	}
	
	public int getRange(){
		return rangePower;
	}
	
	@Override
	public Rectangle2D.Double getContainingRect(){
		return container;
	}
	
	@Override
	public int getImageWidth(){
		return imageWidthX;
	}
	
	@Override	
	public int getImageHeight(){
		return imageHeightY;
	}
	
	public ShipStatus getStatus(){
		return status;
	}
	
	// setters
	@Override
	public void setOrientation(double alpha){
		if (status == ShipStatus.MOVING && !rotating) return;
		if (alpha > (Math.PI * 2)) {
			orientation = alpha - ((Math.PI * 2));
		} else if (alpha < 0){
			orientation = alpha + ((Math.PI * 2));
		} else {
			orientation = alpha;	
		}
		
		setOwnRect();
	}
	
	public void setStatus(ShipStatus newStatus){
		status = newStatus; //need to add if statements to change sprite, etc based on status.
	}
	
	@Override
	public void setCourse(double stop, double x, double y){
		if (status == ShipStatus.MOVING) return;
		status = ShipStatus.MOVING;
		courseX = x;
		courseY = y;
		moveCounter = Math.rint(stop);

	}
	
	@Override
	public void setRotation(double rotation){
		if (rotating) return;
		if(status == ShipStatus.MOVING) return;
		rotating = true;
		
		if (Math.abs(rotation) < 0.01) return;
		
		if (rotation < 0) {
			rotationIncrement = -1 * (Math.PI / (3 * GameManager.getMySettings().getFPS()));
		} else {
			rotationIncrement = Math.PI / (3 * GameManager.getMySettings().getFPS());
		}
		rotationCounter = Math.abs(rotation / (Math.PI / (3 * GameManager.getMySettings().getFPS())));
		//System.out.println("counter " + rotationCounter);
		System.out.println("rotation " + rotation);
	}
	
	
	public boolean isSelected() {
		return selected;
	}

	public abstract void attack(Point p, Optional<?> t);
	
	public double getAttackOriginX(){
		double gameXPosition = positionX + xOffset;
		return gameXPosition;
	}
	
	public double getAttackOriginY(){
		double gameYPosition = positionY + yOffset;
		return gameYPosition;
	}
	
	public boolean isMoving(){
		if (status != null &&  status == ShipStatus.MOVING) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isRotating(){
		if (rotating == true) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		return "Ship: " + shipType + positionX + positionY + orientation;
		
	}

}
