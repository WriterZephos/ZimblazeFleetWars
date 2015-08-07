package consoleInterface;

import java.util.Scanner;

public class ConsoleInterfaceControl {
	
	public static Scanner myScanner = new Scanner(System.in);
	
	public static String optionCheck(){
		String option = myScanner.nextLine();
		
		if(option.equalsIgnoreCase("exit")){
			close();
		}
		if(option.equalsIgnoreCase("back")){
			option = "back";
		}
		if(option.equalsIgnoreCase("new")){
			option = "new";
		}
		return option;
	}
	
	public static String numberCheck(){
		String option = myScanner.nextLine();
		int optionNumber;
		
		if(option.equalsIgnoreCase("exit")){
			close();
		}
		if(option.equalsIgnoreCase("back")){
			option = "back";
		}
		if(option.equalsIgnoreCase("new")){
			option = "new";
		}
		try {
			optionNumber = Integer.parseInt(option);
		} catch (NumberFormatException e) {
			System.out.println("\nInvalid entry. Please try again.");
			return "fail";
		}
		return option;
	}
	
	public static void start(){
		ConsoleInterfaceMenu.startMenu();
		
	}
	
	
	public static void close(){
		System.out.println("\nGoodbye.");
		myScanner.close();
		System.exit(0);	
	}
	
	

}
