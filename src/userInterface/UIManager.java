package userInterface;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JComponent;

public class UIManager {
	
	private static ZFrame startWindow;
	private static ZPanel mainScreen;
	private static ZGameView gameScreen;
	
	private static JComponent currentScreen;
	
	public static void initializeUI(){
		startWindow = new ZFrame("Zimblaze Fleet Wars");
		initializeStartScreen();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//		if (gd.isFullScreenSupported()) {
//			gd.setFullScreenWindow(startWindow);
//			try {
//				gd.setFullScreenWindow(startWindow);
//			} finally {
//			    gd.setFullScreenWindow(null);
//			}
//		}
	}
	
	
	public static void initializeGameBoard(){
		if(!(gameScreen == null)) return;
		gameScreen = new ZGameView();
		if (!(mainScreen == null)){
			mainScreen.setVisible(false);
			startWindow.remove(mainScreen);
			mainScreen = null;
		}
		startWindow.add(gameScreen);
		currentScreen = gameScreen;
		startWindow.revalidate();
		startWindow.repaint();	
	}
	
	public static void initializeStartScreen(){
		if(!(mainScreen == null)) return;
		mainScreen = new ZPanel();
		if (!(gameScreen == null)) {
			gameScreen.setVisible(false);
			startWindow.remove(gameScreen);
			gameScreen = null;
		}
		startWindow.add(mainScreen);
		currentScreen = mainScreen;
		startWindow.revalidate();
		startWindow.repaint();
	}
	
	public static JComponent getCurrentScreen() {
		return currentScreen;
	}
}
