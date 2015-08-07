package gameplay;

import javax.swing.SwingUtilities;

import framework.GameManager;
import framework.Settings;
import graphics.GraphicsHandler;

public class GameClock implements Runnable{
	
	long recordedTime;
	long runTime;
	long nano = 1_000_000_000;
	double delay = nano / GameManager.getMySettings().getFPS();
	long before;
	long now;
	long elapsed;
	int count = 0;
	
	@Override
	public void run() {
		
		before = System.nanoTime();
		//System.out.println(before);
		
		while(GameManager.getGame().isRunning()){
			
			now = System.nanoTime();
			elapsed = now - before;
			//System.out.println("delay: " + delay);
			//System.out.println(elapsed);
			//runTime += elapsed;
			//recordedTime += elapsed;
			
			if(elapsed >= delay){
				before = now;
				count++;
				UpdateHandler.update();
				SwingUtilities.invokeLater(new GraphicsHandler());
				//System.out.println("tick");
				//if ((count % 60) == 0) System.out.println("tick");
			}
			//if ((count % 60) == 0) System.out.println("tick");
			
			
		}
		
		
	}
}
