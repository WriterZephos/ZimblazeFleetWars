package graphics;

import java.awt.Graphics;

import javax.swing.SwingUtilities;

import userInterface.UIManager;
import launch.ZimblazeFleetWars;

public class GraphicsHandler implements Runnable{

	@Override
	public void run() {
		UIManager.getCurrentScreen().repaint();
	}
	
	
}
