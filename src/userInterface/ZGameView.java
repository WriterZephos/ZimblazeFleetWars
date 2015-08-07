package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

import units.Bomber;
import framework.GameManager;
import gameplay.ZMouseTracker;

public class ZGameView extends JScrollPane{
	
	public ZGameView(){
		super(new ZGamePanel(),VERTICAL_SCROLLBAR_NEVER,HORIZONTAL_SCROLLBAR_NEVER);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
		addMouseListener(new ZMouseTracker());
		setBackground(Color.BLACK);
		setVisible(true);

		
		JButton addShip;
		addShip = new JButton("Add Ship");
		addShip.addMouseListener(new MouseAdapter(){
			public void mouseClicked (){
				GameManager.getCurrentFleet().add(new Bomber(GameManager.getCurrentFleet(), GameManager.getCurrentPlayer()));
			}
		});
		
		addShip.setVisible(true);

		
	}

}
