package game.view;

import javax.swing.*;
import game.controller.*;

public class gamePanel extends JPanel
{
	gameController controller;
	
	JTextField input;
	
	public gamePanel(gameController controller) 
	{
		super();
		this.controller = controller;
	}
	private void setupPanel() 
	{
		input = new JTextField();
	}
	private void setupLayout() 
	{
		
	}
	private void setupListeners() 
	{
		
	}
	public String userInput() 
	{
		return input.getText();
	}
}
