package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import units.Bomber;
import units.Fighter;
import framework.GameManager;

public class ZFrame extends JFrame {

	private Dimension windowSize;

	public ZFrame (String title){
		
		super(title);
		windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,windowSize.width,windowSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setOpacity(1f);
		setBackground(Color.BLACK);
		setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu options = new JMenu("Options");
		menuBar.add(options);
		JMenuItem addBomber = new JMenuItem("Add Bomber");
		options.add(addBomber);
		addBomber.addActionListener(new ShipAdderB());
		JMenuItem addFighter = new JMenuItem("Add Fighter");
		options.add(addFighter);
		addFighter.addActionListener(new ShipAdderF());
				
		}
	
	class ShipAdderB implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			GameManager.getCurrentFleet().add(new Bomber(GameManager.getCurrentFleet(), GameManager.getCurrentPlayer()));
		}
	}
	class ShipAdderF implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			GameManager.getCurrentFleet().add(new Fighter(GameManager.getCurrentFleet(), GameManager.getCurrentPlayer()));
		}
	}
}