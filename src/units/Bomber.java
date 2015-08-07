/**
 * The Bomber is a sub class of Ship. It is meant for hard hitting, second wave attacks. They are sturdy enough 
 * to withstand some resistance, and pack a powerful attack. Their only downfall is their speed and somewhat limited range.
 */
package units;

import graphics.VectorTools;

import java.awt.Point;
import java.util.Optional;

import attacks.AbstractAttack;
import attacks.AttackManager;
import attacks.Bomb;
import player.Player;

public class Bomber extends Ship{
	
	public static final int COST = 15;
	
	private static final ShipType TYPE = ShipType.BOMBER;
	private static final int HEALTH = 80;
	private static final int ARMOR = 30;
	private static final int SPEED = 40;
	private static final int ATTACK = 70;
	private static final int ACCURACY = 85;
	private static final int RANGE = 40;
	private static final int SPECIAL = 10;
	private static final int XOFFSET = 50;
	private static final int YOFFSET = 40;
	private static final int IWIDTHX = 100;
	private static final int IHEIGHTY = 80;

	/**
	 * Constructor - passes the information from this specific sub type of Ship to the superclass constructor. Also relays the 
	 */

	public Bomber(ZFleet zFleet, Player player) {
		
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, SPECIAL, XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY, zFleet, player);
		
	}
	
	/**
	 * Overloaded Constructor - includes the x y coordinates of this Ship.
	 */

	Bomber(ZFleet zFleet, Player player, int x, int y) {
		
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, SPECIAL, XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY,  zFleet, player,x,y);
	}
	
	/**
	 * Overloaded Constructor - includes the x y coordinates of this Ship and the orientation.
	 */
	Bomber(ZFleet zFleet, Player player, int x, int y, double orient) {
		
		super(TYPE, HEALTH, ARMOR, SPEED, ATTACK, ACCURACY, RANGE, 
				SPECIAL, XOFFSET, YOFFSET, IWIDTHX, IHEIGHTY, zFleet, player, x, y, orient);
	}
	
	public void attack(Point p, Optional<?> t){
		
		double x = getAttackOriginX();
		double y = getAttackOriginY();
		AbstractAttack attack = new Bomb(x, y, VectorTools.findAttackCourseX(this, p), VectorTools.findAttackCourseY(this, p), VectorTools.findAttackStop(this, p), t);
		AttackManager.addAttack(attack);
		System.out.println("bam");
		
	}


	
	
	

}
