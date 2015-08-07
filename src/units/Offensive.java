package units;

import java.awt.Point;
import java.util.Optional;

public interface Offensive {
	
	public abstract void attack(Point p, Optional<?> t);
	
	public abstract double getAttackOriginX();
	public abstract double getAttackOriginY();
	

}
