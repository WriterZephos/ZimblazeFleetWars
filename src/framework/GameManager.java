

package framework;

import gameplay.Game;

import javax.swing.JComponent;

import player.Player;
import player.PlayerManager;
import units.ZFleet;
import units.ZFleetManager;

/*
 * The GameManager class is primarily for setting/ storing/ providing the current player, 
 * current computer ai, their fleets, and other needed references. This class should have no other 
 * functionality to keep it simple and straightforward. It is useful for making these 
 * accessible to the rest of the game. 
 */


public class GameManager {
	
	private static Player currentPlayer;
	private static ZFleet currentFleet;
	private static Player currentComputer;
	private static ZFleet currentComputerFleet;
	

	private static ZFleetManager myFleetManager;
	private static PlayerManager myPlayerManager;
	
	private static Game myGame;
	private static Settings mySettings;
	
	static{
		
		myPlayerManager = new PlayerManager();
		myFleetManager = new ZFleetManager();
		mySettings = new Settings();
		
	}
	
	public static void setCurrentPlayer(Player player){
		
		currentPlayer = player;
		
	}
		
	public static Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public static void setCurrentFleet(ZFleet fleet){
		
		currentFleet = fleet;
		
	}
	
	public static ZFleet getCurrentFleet() {
		return currentFleet;
	}
	
	public static PlayerManager getPlayerManager(){
		
		return myPlayerManager;
		
	}
	
	public static void setPlayerManager(PlayerManager playerManager){
		
		myPlayerManager = playerManager;
		
	}
	
	public static ZFleetManager getFleetManager(){
		
		return myFleetManager;
		
	}
	
	public static void setFleetManager(ZFleetManager fleetManager){
		
		myFleetManager = fleetManager;
		
	}

	public static Player getCurrentComputer() {
		return currentComputer;
	}

	public static void setCurrentComputer(Player currentComputer) {
		GameManager.currentComputer = currentComputer;
	}

	public static ZFleet getCurrentComputerFleet() {
		return currentComputerFleet;
	}

	public static void setCurrentComputerFleet(ZFleet currentComputerFleet) {
		GameManager.currentComputerFleet = currentComputerFleet;
	}
	
	public static void setGame(Game game){
		myGame = game;
	}
	
	public static Game getGame(){
		return myGame;
	}

	public static Settings getMySettings() {
		return mySettings;
	}

	public static void setMySettings(Settings mySettings) {
		GameManager.mySettings = mySettings;
	}

}	
	
	
