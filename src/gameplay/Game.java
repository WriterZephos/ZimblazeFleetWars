package gameplay;



public class Game {
	
	boolean running = false;
	boolean paused = false;
	Thread gameThread;

	public boolean isRunning() {
		return running;
	}

	public void startGame(){
		if(running) return;
		running = true;
		gameThread = new Thread(new GameClock());
		gameThread.start();
	}
	
	public void stopGame(){
		if(!running) return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
