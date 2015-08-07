package userInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;

import attacks.AttackManager;
import units.Bomber;
import framework.GameManager;

public class ZGamePanel extends JPanel{
	
	
	
	ZGamePanel (){
		
		
		setBackground(Color.BLACK);
		setVisible(true);

	}

	
	@Override
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		GameManager.getCurrentFleet().parallelStream().forEach(s -> s.render(g));
		AttackManager.getCurrentAttacks().parallelStream().forEach(a -> a.render(g));
		
	}
}
