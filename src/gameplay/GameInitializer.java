package gameplay;

import userInterface.UIManager;
import framework.GameManager;


public class GameInitializer {
	
	
	public static void newGame(){
		
		Game newGame = new Game();
		GameManager.setGame(newGame);
		UIManager.initializeGameBoard();
		newGame.startGame();
	
	}

	public static void loadGame(Game game){ 

	}

}
