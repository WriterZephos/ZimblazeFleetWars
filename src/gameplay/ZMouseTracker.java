package gameplay;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZMouseTracker extends MouseAdapter{
	
	public void mouseClicked(MouseEvent e){
		
		Point pointClicked = new Point(e.getX(), e.getY());
		int clickType = e.getButton();
		GameActionHandler.process(pointClicked, clickType);
	}
	

}
