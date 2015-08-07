package units;

import java.util.ArrayList;

import framework.GameManager;

public class ZFleet extends ArrayList<Ship>{

	
	ZFleet(int fighters, int bombers){
		
		for (int i = 0; i < fighters; i++){
			Ship newShip = new Fighter(GameManager.getCurrentFleet(),GameManager.getCurrentPlayer());
			add(newShip);
		}	
	
		for (int i = 0; i < bombers; i++){
			Ship newShip = new Bomber(GameManager.getCurrentFleet(),GameManager.getCurrentPlayer());
			add(newShip);
			}
		
		
	}

	public void getFleetRoster(){
		
		
	}






}
