package attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import units.ShipStatus;

public abstract class AbstractAttack {
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	
}
