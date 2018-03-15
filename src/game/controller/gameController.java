package game.controller;

import java.util.*;
import game.model.*;

public class gameController 
{	
	Room[][] map;
	
	List<Item> items;
	
	Scanner scanner;	
	
	List<String> wallResponses;
	List<String> take;
	List<String> listOfActions;
	
	int x;
	int y;
	
	public gameController() 
	{
		wallResponses = new ArrayList<String>();
		take = new ArrayList<String>();
		listOfActions = new ArrayList<String>();
		map = new Room[11][10];
		items = new ArrayList<Item>();
		scanner = new Scanner(System.in);
		x = 8;
		y = 5;
	}
	public void start() 
	{
		setupMap();
		setupItems();
		setupWallResponses();
		test();
	}
	private void test() 
	{
		boolean online = true;
		while (online) 
		{
			System.out.println(map[x][y].getRoomDetail() + "\n");
			System.out.print("Action: ");
			String actionInput = scanner.nextLine();
			actionInput.trim();
			if (listOfActions.contains(actionInput) || checkRoomSpace(actionInput)) 
			{
				if (checkAccess(actionInput)) 
				{
					movement(actionInput);
				}
				else if (true) 
				{
					
				}
			}
			else 
			{
				System.out.println("*You did not input a correct input* \n");
			}
			System.out.println("---------------------------------------------------------------------------------------------------|");
		}
	}
	private void setupMap() 
	{
		map[9][5] = new Room("~Locked Door~","This door is locked.","The Front Lobby can be seen North of you.",false);
		map[8][5] = new Room("~Front Lobby~","There is nothing around you.","Locked doors are South of you, and a hallway can be seen leading North.",true);
		map[7][5] = new Room("~A HALL~","There are broken and opened lockers to your sides, but you see nothing.","You see a Lobby South of you, and a hallway leading North.",true);
		map[6][5] = new Room("~A HALL~","There are lockers on your sides, they seem to be locked, but maybe you can pry it open.","You see a hall South of you, and a Lobby to your North.",true);
		map[5][5] = new Room("~Main Lobby~","You see a crowbar lying around and about","The Lobby continues North, and you see hallways in your South, East and West direction.",true);
		map[4][5] = new Room("~Main Lobby[North]~","You see nothing to be looted here.","You see a hallway stretching North, South, East, and West.",true);
		map[3][5] = new Room("~~","","",true);
		map[2][5] = new Room("","","",true);
		map[1][5] = new Room("","","",true);
		
		map[2][1] = new Room("","","",false);
		
		map[1][2] = new Room("","","",true);
		map[2][2] = new Room("","","",true);
		map[4][2] = new Room("","","",true);
		map[5][2] = new Room("","","",true);
		map[7][2] = new Room("","","",true);
		
		map[7][3] = new Room("","","",true);
		map[6][3] = new Room("","","",true);
		map[5][3] = new Room("","","",true);
		map[4][3] = new Room("","","",true);
		map[3][3] = new Room("","","",true);
		map[2][3] = new Room("","","",true);
		
		map[5][4] = new Room("","","",true);
		map[4][4] = new Room("","","",true);
		map[1][4] = new Room("","","",false);
		
		map[5][6] = new Room("","","",true);
		map[4][6] = new Room("","","",true);
		map[1][6] = new Room("","","",false);
		
		map[7][7] = new Room("","","",true);
		map[6][7] = new Room("","","",true);
		map[5][7] = new Room("","","",true);
		map[4][7] = new Room("","","",true);
		map[3][7] = new Room("","","",true);
		map[2][7] = new Room("","","",true);
		
		map[8][8] = new Room("","","",true);
		map[5][8] = new Room("","","",true);
		map[4][8] = new Room("","","",true);
		map[2][8] = new Room("","","",true);
		
	}
	private void setupItems() 
	{
		items.add(new Item("Crowbar","An object whereas you can open things with",5,5,true));
		items.add(new Item("FlashLight","An object whereas you can illuminate with",0,0,false));
		items.add(new Item("Notes","An object whereas you can hold information in",0,0,false));
		items.add(new Item("Key","An object whereas you can unlock doors with",0,0,false));
		items.add(new Item("Red Book","An object whereas it is read for information",0,0,false));
		items.add(new Item("Green Book","An object whereas it is read for information",0,0,false));
		items.add(new Item("Blue Book","An object whereas it is read for information",0,0,false));
	}
	private boolean checkAccess(String direction) 
	{
		switch (direction.toLowerCase()) 
		{
			case "north":
				if (map[x-1][y] != null) 
				{
					return map[x-1][y].getAccess();
				}
				else
				{
					return false;
				}
			case "south":
				if (map[x+1][y] != null) 
				{
					return map[x+1][y].getAccess();
				}
				else
				{
					return false;
				}
			case "east":
				if (map[x][y+1] != null) 
				{
					return map[x][y+1].getAccess();
				}
				else
				{
					return false;
				}
			case "west":
				if (map[x][y+1] != null) 
				{
					return map[x][y+1].getAccess();
				}
				else
				{
					return false;
				}
			default:
				return false;
		}
	}
	private boolean checkRoomSpace(String direction) 
	{
		switch (direction.toLowerCase()) 
		{
			case "north":
				if (map[x-1][y] != null) 
				{
					return true;
				}
				else
				{
					return false;
				}
			case "south":
				if (map[x+1][y] != null) 
				{
					return true;
				}
				else
				{
					return false;
				}
			case "east":
				if (map[x][y+1] != null) 
				{
					return true;
				}
				else
				{
					return false;
				}
			case "west":
				if (map[x][y+1] != null) 
				{
					return true;
				}
				else
				{
					return false;
				}
			default:
				return false;
		}
	}
	private void movement(String input) 
	{
		switch (input.toLowerCase()) 
		{
		case "north":
			x--;
			break;
		case "south":
			x++;
			break;
		case "east":
			y++;
			break;
		case "west":
			y--;
			break;
		default:
			System.out.println("Not a valid direciton");
		}
	}
	private void setupWallResponses() 
	{
		wallResponses.add("*You have FAILED*");
		wallResponses.add("*DEAD*");
		wallResponses.add("*Do you ever learn?*");
	}
	private void setupActions() 
	{
		take.add("take");
		take.add("pickup");
		take.add("acquire");
		take.add("obtain");
		
		for (String object : take) 
		{
			listOfActions.add(object);
		}
	}
	private String generateNullResponse() 
	{
		int random = (int) (Math.random() * wallResponses.size());
		return wallResponses.get(random);
	}
}
