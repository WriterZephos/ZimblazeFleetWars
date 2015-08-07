package consoleInterface;

import java.util.Scanner;

public class ConsoleInterfaceMenu { 
	
	static boolean run = true;
	public static void startMenu(){
		
		
		
		while (run){	
		
			System.out.println("\nZimblaze Fleet Wars");
			System.out.println("\n1. Start New Game");
			System.out.println("2. Load Saved Game");
			System.out.println("3. Select Player");
			System.out.println("4. New Player");
			System.out.println("5. Options");
			System.out.println("6. Exit");
			System.out.println("\nType the number of your selection, then press enter:\n");

	
			switch(ConsoleInterfaceControl.optionCheck()){
				case "back":
					break;
			
				case "1":
					StartNewGame.startNewGame();
					break;
					
				case "3":
					SelectPlayer.selectPlayer();
					break;
					
				case "4":
					NewPlayer.newPlayer();
					break;
					
				case "5":
					System.out.println("\nOptions have not been defined yet.");
					break;
					
				case "6":
					run = false;
					ConsoleInterfaceControl.close();
					break;
					
				default:
					System.out.println("\nInvalid entry. Please try again.");
					break;
			}
		}
		
		
	}
	public static void setRun(boolean run) {
		ConsoleInterfaceMenu.run = run;
	}
}