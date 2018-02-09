package game.model;

import java.util.*;

public class Map 
{
	public Room[][] map;
	
	public int x;
	public int y;
	
	public Map()
	{
		map = new Room[11][10];
		x = 5;
		y = 5;
		
		//Methods Called
		setupMap();
	}
	private void setupMap() 
	{
		map[5][5] = new Room("Test",5);
		map[6][5] = new Room("Yes", 6);
	}
	public void move() {
		x++;
	}
	
}
