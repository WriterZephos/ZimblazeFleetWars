package userInterface;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StartWindow extends JLabel{
	
	StartWindow(){
	
		setSize(300,300);
		setVisible(true);
		add(new JButton("Start Game"));
		add(new JButton("Select Player"));
		add(new JButton("Exit"));	
		
	}

}
