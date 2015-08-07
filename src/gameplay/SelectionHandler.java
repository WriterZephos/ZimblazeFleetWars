package gameplay;

import java.util.ArrayList;
import java.util.HashSet;

import units.Selectable;
import units.Ship;

public class SelectionHandler {
	
	private static HashSet<Selectable> selectedUnits = new HashSet<>();

	public static void resetSelection(){
		
		selectedUnits.stream().forEachOrdered(s -> s.deselect());
		selectedUnits.removeIf(s -> !s.getSelected());
		selectedUnits.stream().filter(s -> s.getXGamePosition() > 50).forEach(s -> System.out.print(s.getXGamePosition() > 50));
		
	}

	public static HashSet<Selectable> getSelectedUnits() {
		return selectedUnits;
	}

	public static int getSelectionSize(){
		return selectedUnits.size();
	}
	
	public static void setSelectedUnits(HashSet<Selectable> mUnits) {
		selectedUnits = mUnits;
	}
	
	public static void selectUnit(Selectable s){
		selectedUnits.add(s);
		s.select();
	}
	
	public static void deselectUnit(Selectable s){
		
		if(selectedUnits.size() == 0){
			return;
		}
		selectedUnits.removeIf(sShip -> sShip.equals(s));
	}
}
