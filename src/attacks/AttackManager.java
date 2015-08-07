package attacks;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AttackManager {

	private static Set<AbstractAttack> currentAttacks = new HashSet<>();
	private static Random colorChooser = new Random();
	private static Color[] colors = {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	public static List<AbstractAttack> getCurrentAttacks(){
		List<AbstractAttack> l = new ArrayList<AbstractAttack>(currentAttacks);
		return l;
	}
	
	public static void addAttack(AbstractAttack attack){
		currentAttacks.add(attack);
	}
	
	public static void removeAttack(AbstractAttack attack){
		currentAttacks.remove(attack);
	}
	
	public static Color getColor(){
		return colors[colorChooser.nextInt(9)];
		
	}
	
	
}
