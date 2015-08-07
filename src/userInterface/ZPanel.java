package userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;

import units.Fighter;
import units.Ship;
import framework.GameManager;

public class ZPanel extends JPanel {

	ZPanel (){
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(Color.BLACK);
		setVisible(true);
	}
}
