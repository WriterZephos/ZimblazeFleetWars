package units;

import gameplay.SelectionHandler;
import graphics.VectorTools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class MoveableHandler {
	
	public static void courseSetter(Point b){
		
		HashSet<Selectable> selection;
		selection = SelectionHandler.getSelectedUnits();
		
		
		selection.stream().filter(s -> s instanceof Moveable).forEachOrdered((s) -> {
			
															boolean colliding = false;
															
															if (s instanceof Collideable){
																
																Collideable c = (Collideable) s;
																
																double theta = VectorTools.getAngle(c, b);
																colliding = VectorTools.isColliding(c, b, theta);
							
															}
								
															if (colliding){
																return;
															} else {
															
																Moveable m = (Moveable) s;
																
																double beta = VectorTools.getRotation(m, VectorTools.getAngle(m, b));
																//double rotStop = VectorTools.getRotationCounter(m, VectorTools.getAngle(m, b));
																double courseX = VectorTools.findCourseX(m, b);
																double courseY = VectorTools.findCourseY(m, b);
																double stop = VectorTools.findStop(m, b);
																
																m.setRotation(beta);
																m.setCourse(stop, courseX, courseY);

															}
															});
		
	}
	
public static boolean rotationSetter(Point b){
		
		HashSet<Selectable> selection;
		selection = SelectionHandler.getSelectedUnits();
		boolean moved = false;
		
		selection.stream().filter(s -> s instanceof Moveable).forEachOrdered((s) -> {
			
															boolean colliding = false;
															
															if (s instanceof Collideable){
																
																Collideable c = (Collideable) s;
																
																double theta = VectorTools.getAngle(c, b);
																colliding = VectorTools.isColliding(c, theta);
							
															}
								
															if (colliding){
																return;
															} else {
															
																Moveable m = (Moveable) s;
																
																double beta = VectorTools.getRotation(m, VectorTools.getAngle(m, b));
																//double rotStop = VectorTools.getRotationCounter(m, VectorTools.getAngle(m, b));
																
																m.setRotation(beta);

															}
															});
		if (selection.stream().filter(s -> s instanceof Moveable).filter(s -> ((Moveable)s).isRotating()).count() > 0){
			moved = true;
		}
		return moved;
		
	}
	
	
	
	
}
