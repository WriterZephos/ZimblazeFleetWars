package attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Optional;

public class Bomb extends AbstractAttack{
	
	private double positionX = 0;
	private double positionY = 0;
	private double courseX = 0;
	private double courseY = 0;
	private double moveCounter = 0;
	private final int xOffset = 5; 
	private final int yOffset = 5;
	private final int width = 10;
	private Color color;
	boolean colorChanger = false;
	int colorCounter = 50;
	Color color2;
	Optional target;
	
	public Bomb(double posX, double posY, double cX, double cY, double counter, Optional t){
		
		positionX = posX;
		positionY = posY;
		courseX = cX;
		courseY = cY;
		moveCounter = counter;
		target = t;
		
		color = AttackManager.getColor();
		color2 = color.brighter();
		
	}

	public void update(){
		positionX -= courseX;
		positionY -= courseY;
		moveCounter--;
		if(moveCounter <= 0){
			courseX = 0;
			courseY = 0;
			
			AttackManager.removeAttack(this);
		}
	}
	public void render(Graphics g){
		
		
		if (colorChanger) {
			color2 = color2.darker();
			colorCounter--;
			colorCounter--;
		}
		
		if (!colorChanger) {
			color2 = color2.brighter();
			colorCounter++;
		}
		
		if (colorCounter >= 50) colorChanger = true; 
		
		if (colorCounter <= 0) colorChanger = false; 
		
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(color2);
		g2d.fillOval((int) Math.rint(positionX - xOffset), (int) Math.rint(positionY - yOffset), width, width);
		
	}
	
	private void applyAttack(){
		
	}
}
