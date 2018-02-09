package game.view;

import javax.swing.*;
import game.controller.*;

public class gamePanel extends JPanel
{
	gameController controller;
	
	JLabel logLabel;
	JLabel inputLabel;
	JLabel inventoryLabel;
	
	JTextField input;
	
	JTextArea log;
	JTextArea inventory;
	
	JButton enter;
	
	SpringLayout layout;
	
	public gamePanel(gameController controller) 
	{
		super();
		this.controller = controller;
		
		setupPanel();
	}
	private void setupPanel() 
	{
		logLabel = new JLabel("LOG");
		inputLabel = new JLabel("INTERACT");
		inventoryLabel = new JLabel("INVENTORY");
		
		input = new JTextField();
		
		log = new JTextArea();	
		inventory = new JTextArea();
		
		enter = new JButton("Enter");
		
		layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, enter, 142, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, enter, 127, SpringLayout.WEST, this);
		
		this.add(log);
		this.add(inventory);
		this.add(enter);	
		this.add(input);
		this.setLayout(layout);
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
