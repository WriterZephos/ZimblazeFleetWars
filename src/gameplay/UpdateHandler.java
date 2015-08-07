package gameplay;

import java.util.Arrays;

import attacks.AttackManager;
import framework.GameManager;

public class UpdateHandler {
	
	public static void update(){
		
		GameManager.getCurrentFleet().stream().forEachOrdered(s -> s.updateUnit());
		AttackManager.getCurrentAttacks().stream().forEachOrdered(a -> a.update());
		//System.out.println("updating");
		//GameManager.getCurrentComputerFleet().stream().forEachOrdered(s -> s.updateUnit());
	
	}

}
