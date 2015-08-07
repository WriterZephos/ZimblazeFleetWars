package units;

import framework.GameManager;

public class ZFleetBuilder {
	

	public static void buildFleet(int numbFighters, int numbBombers){
		
		ZFleet newFleet = new ZFleet(numbFighters, numbBombers);	
		GameManager.getFleetManager().add(newFleet);
		int zFleetPosition = GameManager.getFleetManager().size()-1;
		GameManager.setCurrentFleet(GameManager.getFleetManager().get(zFleetPosition));
	}
}
