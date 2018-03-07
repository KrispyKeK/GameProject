package game.controller;

import java.util.*;
import game.model.*;

public class gameController 
{	
	Room[][] map;
	Scanner scanner;	
	List<String> nullResponses;	
	List<String> move;
	int x;
	int y;
	
	public gameController() 
	{
		nullResponses = new ArrayList<String>();
		move = new ArrayList<String>();
		move.add("move");
		map = new Room[11][10];
		scanner = new Scanner(System.in);
		x = 8;
		y = 5;
	}
	public void start() 
	{
		setupMap();
		setupNullResponses();
		test();
	}
	private void test() 
	{
		boolean online = true;
		while(online) 
		{
			
		}
	}
	private void setupMap() 
	{
		map[9][5] = new Room("~Locked Door~","This door is locked.","The Front Lobby can be seen North of you.",false);
		map[8][5] = new Room("~Front Lobby~","There is nothing around you.","Locked doors are South of you, and a hallway can be seen leading North.",true);
		map[7][5] = new Room("~A HALL~","There are broken and opened lockers to your sides, but you see nothing.","You see a Lobby South of you, and a hallway leading North.",true);
		map[6][5] = new Room("","","",true);
		map[5][5] = new Room("","","",true);
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
	private void setupNullResponses() 
	{
		nullResponses.add("You ran into the wall like a moron");
		nullResponses.add("You are now well acquianted with the wall");
		nullResponses.add("You met the wall and fell in love with it");
	}
	private String generateNullResponse() 
	{
		int random = (int) (Math.random() * nullResponses.size());
		return nullResponses.get(random);
	}
}
