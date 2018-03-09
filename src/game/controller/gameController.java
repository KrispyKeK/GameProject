package game.controller;

import java.util.*;
import game.model.*;

public class gameController 
{	
	Room[][] map;
	Scanner scanner;	
	List<String> wallResponses;
	List<String> take;
	List<>
	int x;
	int y;
	
	public gameController() 
	{
		wallResponses = new ArrayList<String>();
		map = new Room[11][10];
		scanner = new Scanner(System.in);
		x = 8;
		y = 5;
	}
	public void start() 
	{
		setupMap();
		setupWallResponses();
		test();
	}
	private void test() 
	{
		boolean online = true;
		while (online) 
		{
			System.out.println(map[x][y].getRoomDetail());
			System.out.print("Action: ");
			String actionInput = scanner.nextLine();
			actionInput.trim();
			
		}
	}
	private void setupMap() 
	{
		map[9][5] = new Room("~Locked Door~","This door is locked.","The Front Lobby can be seen North of you.",false);
		map[8][5] = new Room("~Front Lobby~","There is nothing around you.","Locked doors are South of you, and a hallway can be seen leading North.",true);
		map[7][5] = new Room("~A HALL~","There are broken and opened lockers to your sides, but you see nothing.","You see a Lobby South of you, and a hallway leading North.",true);
		map[6][5] = new Room("~A HALL~","There are lockers on your sides, they seem to be locked, but maybe you can pry it open.","You see a hall South of you, and a Lobby to your North.",true);
		map[5][5] = new Room("~Main Lobby~","You see a crowbar lying around and about","The Lobby continues North, and you see hallways in your South, East and West direction.",true);
		map[5][5] = new Room("","","",true);
		map[4][5] = new Room("","","",true);
		map[3][5] = new Room("","","",true);
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
	private void setupWallResponses() 
	{
		wallResponses.add("You ran into the wall like a moron");
		wallResponses.add("You are now well acquianted with the wall");
		wallResponses.add("You met the wall and fell in love with it");
	}
	private String generateNullResponse() 
	{
		int random = (int) (Math.random() * wallResponses.size());
		return wallResponses.get(random);
	}
}
