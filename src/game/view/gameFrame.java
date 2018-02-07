package game.view;

import javax.swing.*;
import game.controller.*;

public class gameFrame extends JFrame
{
	gameController controller;
	gamePanel panel;
	public gameFrame(gameController controller) 
	{
		super();
		this.controller = controller;
		this.panel = new gamePanel(controller);
		setupFrame();
	}
	private void setupFrame() 
	{
		this.setContentPane(panel);
		this.setTitle("Puzzles");
		this.setSize(1920, 1080);
		this.setResizable(false);
		this.setVisible(true);
	}
}
