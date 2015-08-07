package consoleInterface;

import player.PlayerBuilder;
import units.ZFleetBuilder;
import userInterface.UIManager;
import framework.GameManager;
import gameplay.GameInitializer;

public class StartNewGame {
	
	
	
	public static void startNewGame(){
		
		PlayerBuilder.buildPlayer("Bob");
		ZFleetBuilder.buildFleet(1,0);
		GameManager.setCurrentPlayer(GameManager.getPlayerManager().get(0));
		
		boolean run = true;
		
		while(run){
	
			if (GameManager.getCurrentPlayer() == null){
				SelectPlayer.selectPlayer();
			}	
			if (GameManager.getCurrentPlayer() == null){
				return;
			}
		
		System.out.println("\nStarting game.");	
		
		//BuildYourFleet.buildYourFleet();
		
		GameInitializer.newGame();
		
		System.out.println("new Game");
		
		ConsoleInterfaceMenu.setRun(false);
		run = false;
		return;	
	}
	}
	
	}

