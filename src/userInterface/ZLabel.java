package userInterface;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import units.Bomber;
import units.Fighter;
import framework.GameManager;

public class ZLabel extends JLabel {
	
	
	
	
	ZLabel(){
		JButton addBomber;
		JButton addFighter;
		setSize(600,600);
		setOpaque(true);
		setBackground(Color.BLUE);
		addBomber = new JButton("Add Bomber");
		addFighter = new JButton("Add Fighter");
		addBomber.addMouseListener(new MouseAdapter(){
			public void mouseClicked (){
				GameManager.getCurrentFleet().add(new Bomber(GameManager.getCurrentFleet(), GameManager.getCurrentPlayer()));
			}
		});
		addFighter.addMouseListener(new MouseAdapter(){
			public void mouseClicked (){
				GameManager.getCurrentFleet().add(new Fighter(GameManager.getCurrentFleet(), GameManager.getCurrentPlayer()));
			}
		});
		//addBomber.setVisible(true);
		setVisible(true);
	}

}
