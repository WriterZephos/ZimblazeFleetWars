package launch;

import consoleInterface.ConsoleInterfaceControl;
import consoleInterface.StartNewGame;
import userInterface.UIManager;
import userInterface.ZFrame;

public class ZimblazeFleetWars {
	
	static ZFrame gameWindow;

	public static void main(String[] args) {
		
		
		UIManager.initializeUI();
		//UIManager.initializeGameBoard();
		
		StartNewGame.startNewGame();
		//start console interface
		//ConsoleInterfaceControl.start();
		
	}

	
	public static ZFrame getGameWindow(){
		return gameWindow;
	}
}
