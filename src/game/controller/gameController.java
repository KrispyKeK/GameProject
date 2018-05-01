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
	List<String> move;
	List<String> listOfActions;	
	List<String> directions;
	
	HashMap<String, String> movement;
	
	int x;
	int y;
	 
	public gameController() 
	{
		wallResponses = new ArrayList<String>();
		take = new ArrayList<String>();
		move = new ArrayList<String>();
		movement = new HashMap<>();
		directions = new ArrayList<String>();
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
		setupDirections();
		test();
	}
	private void test() 
	{
		boolean online = true;
		while (online) 
		{
			System.out.println(map[x][y].getRoomDetail() + "\n" + x + "" + y);
			System.out.print("Action: ");
			String actionInput = scanner.nextLine();
			if (listOfActions.contains(actionInput.toLowerCase()) || directions.contains(actionInput.toLowerCase())) 
			{
				if (checkRoomSpace(actionInput)) 
				{
					if (checkAccess(actionInput)) 
					{
						movement(actionInput);
					}
					else 
					{
						System.out.println(generateDeny(actionInput));
					}
				}
				else 
				{
					System.out.println(generateWallResponse());
				}
				if (listOfActions.contains(actionInput.toLowerCase())) 
				{
					
				}
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
		map[3][5] = new Room("~D HALL~","There is nothing around you","There is a lobby South of you, and a hall can be seen leading North.",true);
		map[2][5] = new Room("~D HALL~","There is nothing around you","There is a hallway South of you, and another hall North of you.",true);
		map[1][5] = new Room("~DC HALL~","There is nothing around you","You see the entrance to a Library East of you, and a door that is labeled Office, West of you.",true);
		
		map[2][1] = new Room("~Secret Room~","There is nothing around you. Such a waste of a secrete room am I right?","An exit can be seen West of you.",false);

		map[2][2] = new Room("~ClassRoom B2~","You see a safe on top of a desk, but it appears to be locked.","You see an exit East of you.",true);
		map[4][2] = new Room("~BathRoom Male~","","",true);
		map[5][2] = new Room("~BathRoom Female~","","",true);
		map[7][2] = new Room("~ClassRoom B1~","","",true);
		
		map[7][3] = new Room("~BT HALL~","","There is a room West of you, and the hallway continueing North",true);
		map[6][3] = new Room("~BT HALL~","","",true);
		map[5][3] = new Room("~BT HALL~","","",true);
		map[4][3] = new Room("~BT HALL~","","",true);
		map[3][3] = new Room("~BT HALL~","","",true);
		map[2][3] = new Room("~BT HALL~","","",true);
		
		map[5][4] = new Room("~B HALL~","","",true);
		map[4][4] = new Room("~B HALL~","","",true);
		map[1][4] = new Room("~Office~","","",false);
		
		map[5][6] = new Room("~C HALL~","","",true);
		map[4][6] = new Room("~C HALL~","","",true);
		map[1][6] = new Room("~Library~","","",false);
		
		map[7][7] = new Room("~CT HALL~","","",true);
		map[6][7] = new Room("~CT HALL~","","",true);
		map[5][7] = new Room("~CT HALL~","","",true);
		map[4][7] = new Room("~CT HALL~","","",true);
		map[3][7] = new Room("~CT HALL~","","",true);
		map[2][7] = new Room("~CT HALL~","","",true);
		
		map[8][8] = new Room("~ClassRoom C2~","","",true);
		map[5][8] = new Room("~BathRoom Female~","","",true);
		map[4][8] = new Room("~BathRoom Male~","","",true);
		map[2][8] = new Room("~ClassRoom C1~","","",true);
		
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
	private void setupDirections() 
	{
		directions.add("north");
		directions.add("south");
		directions.add("east");
		directions.add("west");
	}
	private String generateDeny(String input) 
	{
		if (checkAccess(input) != true && input.toLowerCase().equals("east")) 
		{
			return "*You are too scared of the dark to enter*";
		}
		else if (checkAccess(input) != true && input.toLowerCase().equals("west")) 
		{
			return "*The door is locked, perhaps you need to seek a key*";
		}
		else if (checkAccess(input) != true && input.toLowerCase().equals("south")) 
		{
			return "*Great, a locked door.*";
		}
		return "*I have no idea how you even got here*";
	}
	private boolean checkAccess(String direction) 
	{
		switch (direction.toLowerCase()) 
		{
			case "north":
				return map[x-1][y].getAccess();	
			case "south":
				return map[x+1][y].getAccess();
			case "east":
				return map[x][y+1].getAccess();
			case "west":
				return map[x][y-1].getAccess();
			default:
				return false;
		}
	}
	private boolean checkRoomSpace(String direction) 
	{
		try {
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
					if (map[x][y-1] != null) 
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
		catch(Exception E) 
		{
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
		
		movement.put("walk", "You have slowly walked");
		
		
		
		for (String object : take) 
		{
			listOfActions.add(object);
		}
	}
	private String generateWallResponse() 
	{
		int random = (int) (Math.random() * wallResponses.size());
		return wallResponses.get(random);
	}
}
