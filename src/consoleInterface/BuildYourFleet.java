package consoleInterface;

import framework.GameManager;
import player.PlayerBuilder;
import units.Bomber;
import units.Fighter;
import units.ZFleetBuilder;

public class BuildYourFleet {
	
public static void buildYourFleet(){
		
		int fleetPoints;
		String option;
	
		int numbFighters = 0;
		boolean fighterRun = true;
		int numbBombers = 0;
		boolean bomberRun = true;
		boolean run = true;
		
		while(run){
		
			System.out.println("\nEnter fleet size (how many Fleet Points): \n");
			
			option = ConsoleInterfaceControl.numberCheck();
		
			switch(option){
			
				case "back":
					run = false;
					return;
				
				default:
					fleetPoints = Integer.parseInt(option);
					break;
			}
			
			while(fighterRun){
			
				System.out.printf("\nEnter number of Fighters. Cost: %d Remaining Fleet Points: %d\n", Fighter.COST, fleetPoints);
			
				option = ConsoleInterfaceControl.numberCheck();
			
				switch(option){
			
					case "back":
						fighterRun = false;
						run = false;
						return;
					
					case "fail":
						break;
			
					default:
						numbFighters = Integer.parseInt(option);
						if(fleetPoints - numbFighters * Fighter.COST >= 0){
							fleetPoints -= numbFighters * Fighter.COST;
							fighterRun = false;
							break;	
						} else {
							System.out.println("\nNot enough Fleet Points. Try again.");
							numbFighters = 0;
							break;
						}	
				}	
			}
			
			
			while(bomberRun){
				
				System.out.printf("\nEnter number of Bombers. Cost: %d Remaining Fleet Points: %d\n", Bomber.COST, fleetPoints);
			
				option = ConsoleInterfaceControl.numberCheck();
			
				switch(option){
			
					case "back":
						fighterRun = false;
						run = false;
						return;
					
					case "fail":
						break;
			
					default:
						numbBombers = Integer.parseInt(option);
						if(fleetPoints - numbBombers * Bomber.COST >= 0){
							fleetPoints -= numbBombers * Bomber.COST;
							bomberRun = false;
							break;	
						} else {
							System.out.println("\nNot enough Fleet Points. Try again.");
							numbBombers = 0;
							break;
						}	
				}	
			}
			
			ZFleetBuilder.buildFleet(numbFighters,numbBombers);
			System.out.println("\nFleet created.");
			run = false;
		}
		return;
	}
}
