package game.view;

import javax.swing.*;
import game.controller.*;

public class gamePanel extends JPanel
{
	gameController controller;
	public gamePanel(gameController controller) 
	{
		super();
		this.controller = controller;
	}
}
