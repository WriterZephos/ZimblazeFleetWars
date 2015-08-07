package consoleInterface;

import player.PlayerBuilder;

public class NewPlayer {
	
	public static void newPlayer(){
		
		String option;
		boolean run = true;
		
		while(run){
		
			System.out.println("\nEnter new player name: \n");
			
			option = ConsoleInterfaceControl.optionCheck();
		
			switch(option){
			
				case "back":
					run = false;
					break;
				
				default:
					PlayerBuilder.buildPlayer(option);
					System.out.println("\nPlayer " + option + " was created.");
					run = false;
					break;
			}
		}
		return;
	}
}
