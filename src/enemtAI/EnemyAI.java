
package enemtAI;

import java.awt.Point;
import java.util.ArrayList;

import javax.jws.Oneway;

import units.Ship;
import framework.GameManager;
import graphics.VectorTools;

/**
 * The EnemyAI class contains the methods for collecting data about the current game
 * relative to each individual Ship in the enemy fleet. These methods are called by the
 * evaluateBattle method as it cycles through the enemy fleet and assesses the situation for each ship.
 * 
 * The evaluateBattle method will take several parameters which will influence the assessments it
 * makes by favoring one decision over another.
 *
 * @author Bryant
 */
public class EnemyAI {

/*	public void evaluateBattle(){
		for (Ship aiShip: GameManager.getCurrentComputerFleet()){
	
		}	
	}
	
	/**
	 * Returns an ArrayList containing all the player's ships that are in range of the aiShip given as an argument.
	 * @param aiShip - the ship looking for targets.
	 * @return Returns an array list of in-range targets.
	 */
	/* public ArrayList<Ship> findTargets(Ship aiShip){
		
		ArrayList<Ship> targets = new ArrayList<Ship>();
		
		for (Ship playerShip: GameManager.getCurrentFleet()){
			
			if (VectorTools.isWithinOrEqualDistance(aiShip.getPosition(), playerShip.getPosition(), aiShip.getRange())){
				targets.add(playerShip);		
			}	
		}
		return targets;
	}*/
	
	/**
	 * Finds the closest target to the aiShip given as an argument.
	 * @param aiShip - the ship looking for targets.
	 * @return Returns a Ship, which represents the closest target to the aiShip.
	 */
	/*public Ship findClosestTargets(Ship aiShip){
		
		Ship closestShip = GameManager.getCurrentFleet().get(0); //initializing with temporary value.
		double closestDistance = VectorTools.distanceFormula(aiShip.getPosition(), closestShip.getPosition()); //initializing with temporary value.
		
		for (Ship playerShip: GameManager.getCurrentFleet()){
				
			if (VectorTools.isWithinDistance(aiShip.getPosition(), playerShip.getPosition(), (int) Math.rint(closestDistance))){
				
				closestDistance = VectorTools.distanceFormula(aiShip.getPosition(),playerShip.getPosition());
				closestShip = playerShip;		
			
			} else if (VectorTools.isWithinOrEqualDistance(aiShip.getPosition(), playerShip.getPosition(), (int) Math.rint(closestDistance))){
				
				//add an additional test to break ties?
				closestShip = playerShip;		
			}	
		}
		return closestShip;
	}*/
	
	
	
	 /*public Point findClosestMove(Ship aiShip, Ship playerShip){
		
		
		
		return;
	} 
	
	
	*/
	
	
	
}
