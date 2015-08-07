package unused;

import java.awt.Point;

import units.Ship;

public class MoveOrder {
	
	boolean move = false;
	boolean attack = false;
	
	Ship currentShip;
	Ship targetShip;
	Point targetPosition;
	
	MoveOrder(boolean m, boolean a, Ship current, Ship target, Point targetP){
		
		move = m;
		attack = a;
		currentShip = current;
		targetShip = target;
		targetPosition = targetP;
	
	}
	
	MoveOrder(boolean m, Ship current, Point targetP){
		
		move = m;
		attack = false;
		currentShip = current;
		targetShip = null;
		targetPosition = targetP;
	
	}
	
	MoveOrder(boolean a, Ship current, Ship target){
		
		move = false;
		attack = a;
		currentShip = current;
		targetShip = target;
		targetPosition = null;
	
	}
	
	MoveOrder(Ship current){
		
		currentShip = current;
	
	}
	
	public void move(){	
		
	}
	
	public void attack(){
		
	}
	
	
	
	
	

}
