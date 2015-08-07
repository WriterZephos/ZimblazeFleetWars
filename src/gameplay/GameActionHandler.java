package gameplay;

import graphics.VectorTools;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Optional;

import units.MoveableHandler;
import units.Offensive;
import units.Selectable;
import units.Unit;

public class GameActionHandler {
	
	public static void process(Point clickedPoint, int button){
		
		Optional<Unit> clickedThing = VectorTools.getContainingObject(clickedPoint); 
		
		if(SelectionHandler.getSelectionSize() < 1 && !clickedThing.isPresent()){
			return;
		
		} else if (SelectionHandler.getSelectionSize() < 1 && clickedThing.get() instanceof Selectable){
			SelectionHandler.selectUnit((Selectable) clickedThing.get());
			return;
			
		} else if (SelectionHandler.getSelectionSize() >= 1 && !clickedThing.isPresent()) {
			decideSoloAction(clickedPoint, button);
			return;
			
		} else if (SelectionHandler.getSelectionSize() >= 1 && clickedThing.isPresent()){
			decideJointAction(clickedPoint, button, clickedThing);
			return;
			
		}
	}
	
	private static void decideSoloAction(Point clickedPoint, int button){
		
		System.out.println(button);
		if (button == MouseEvent.BUTTON1) {
			SelectionHandler.resetSelection();
			return;
		}
		MoveableHandler.courseSetter(clickedPoint);

	}
	
	
	private static void decideJointAction(Point clickedPoint, int button, Optional<Unit> target){
		if (button == MouseEvent.BUTTON1) {
			SelectionHandler.resetSelection();
			if (target.get() instanceof Selectable){
				SelectionHandler.selectUnit((Selectable) target.get());
			}
			return;
		}
		if (button == MouseEvent.BUTTON3){
			if (MoveableHandler.rotationSetter(clickedPoint)){
				SelectionHandler.getSelectedUnits().stream().filter(s -> s instanceof Offensive).forEach((s) -> {((Offensive) s).attack(clickedPoint, target);});
		
			}
		//SelectionHandler.getSelectedUnits().stream().filter(s -> s instanceof Offensive).forEach((s) -> {((Offensive) s).attack(clickedPoint);});
		}
	}
}
