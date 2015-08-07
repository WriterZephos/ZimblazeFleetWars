package player;

import framework.GameManager;

public class PlayerBuilder {
	
	public static Player buildPlayer(String name){
		
		Player newPlayer = new Player(name);
		
		GameManager.getPlayerManager().add(newPlayer);
		
		return newPlayer;
	}

}
