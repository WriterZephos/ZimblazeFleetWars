package player;

import java.util.ArrayList;

import units.ZFleetTemplate;

public class Player {
	
	private String playerName;
	private int highScore;
	
	private ArrayList<ZFleetTemplate> savedFleets;
	
	public Player(String name){
		
		setPlayerName(name);
		setHighScore(0);
		savedFleets = new ArrayList<ZFleetTemplate>();
		
	}

	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	
	public int getHighScore() {
		return highScore;
	}


	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}


	public ArrayList<ZFleetTemplate> getSavedFleets() {
		return savedFleets;
	}


	public void saveFleet(ZFleetTemplate saveThisFleet) {
		savedFleets.add(saveThisFleet);
	}
}
