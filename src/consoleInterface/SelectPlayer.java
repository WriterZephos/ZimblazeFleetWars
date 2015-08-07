package consoleInterface;

import java.util.Scanner;

import framework.GameManager;

public class SelectPlayer {
	
	public static void selectPlayer(){
		
		// declares and initializes size of the list of players, then declares other needs variables.
		int playerListSize;
		String selection;
		int selectionNumber;
		boolean run = true;
		
		while(run){
			
			playerListSize = GameManager.getPlayerManager().size();
			
			//Outputs message, depending on whether there are players in the list or not.
			if(playerListSize < 1){
				System.out.println("\nThere are no saved players. Enter \"new\" to create a new player.\n");
				
			} else {
				System.out.println("\nEnter the number of the player you want to select, or enter \"new\" to create a new player.\n");
				
				//outputs list of players in player manager
				for (int i = 0; i < playerListSize; i++){
					int j = i + 1;
					System.out.println(j + ". " + GameManager.getPlayerManager().get(i).getPlayerName());
				}
			System.out.println();	
			}
	
			//getting input
			selection = ConsoleInterfaceControl.optionCheck();
			
			//implementing input with a switch
			switch(selection){
				case "back":
					run = false;
					break;
			
				case "new": ;
					NewPlayer.newPlayer();
					break;
					
				default:
					try {
						selectionNumber = Integer.parseInt(selection);
					} catch (NumberFormatException e) {
						System.out.println("\nInvalid entry. Please try again.");
						break;
					}
					
					if (selectionNumber > playerListSize){
						System.out.println("\nInvalid entry. Please try again.");
						break;
						
					} else{
	
					GameManager.setCurrentPlayer(GameManager.getPlayerManager().get(selectionNumber - 1));
					System.out.println("\nPlayer " + GameManager.getCurrentPlayer().getPlayerName() + " was selected.");
					run = false;
					break;
					}
			}	
			//continue while loop here
		}
	
		return;
		
	}
	

}
