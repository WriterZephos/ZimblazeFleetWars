/**
 * The Fighter is a subclass of Ship. It is a small, fast ship meant primarily for hit and run and fast strikes.
 * Where it gains in speed and fire-power, it lacks in defenses and overall sturdiness.
 */
package units;

import graphics.VectorTools;

import java.awt.Point;
import java.util.Optional;

import attacks.AbstractAttack;
import attacks.AttackManager;
import attacks.Laser;
import player.Player;

public class Fighter extends Ship {
	
	public static final int COST = 10;
	
	private static final ShipType TYPE = ShipType.FIGHTER;
	private static final int HEALTH = 80;
	private static final int ARMOR = 30;
	private static final int SPEED = 40;
	private static final int ATTACK = 70;
	private static final int ACCURACY = 85;
	private static final int RANGE = 40;
	private static final int SPECIAL = 10;
	private static final int XOFFSET = 40;
	private static final int YOFFSET = 25;
	private static final int IWIDTHX = 80;
	private static final int IHEIGHTY = 50;
	
	
	/**
	 * Constructor - passes the information from this specific sub type of Ship to the superclass constructor. Also relays the 
	 */

	public Fighter(ZFleet zFleet, Player player) {
		
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, SPECIAL, XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY, zFleet, player);
		
	}
	
	/**
	 * Overloaded Constructor - includes the x y coordinates of this Ship.
	 */
	
	Fighter(ZFleet zFleet, Player player, int x, int y) {
		
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, SPECIAL, XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY,  zFleet, player,x,y);
	}
	
	/**
	 * Overloaded Constructor - includes the x y coordinates of this Ship and the orientation.
	 */
	Fighter(ZFleet zFleet, Player player, int x, int y, double orient) {
		
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, 
				SPECIAL, XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY, zFleet, player, x, y, orient);
	}

	public Fighter() {  //testing purposes only
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, SPECIAL,
				XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY, new ZFleet(1,1), new Player("Bob"));
	}
	
	public void attack(Point p, Optional<?> t){
		
		double x = getAttackOriginX();
		double y = getAttackOriginY();
		AbstractAttack attack = new Laser(x, y, VectorTools.findAttackCourseX(this, p), VectorTools.findAttackCourseY(this, p), VectorTools.findAttackStop(this, p), t);
		AttackManager.addAttack(attack);
		System.out.println("bam");
		
	}
}