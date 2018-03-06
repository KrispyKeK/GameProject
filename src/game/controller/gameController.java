package game.controller;

import java.util.*;
import game.model.*;

public class gameController 
{
	
	Room[][] map;
	Scanner scanner;
	List<String> nullResponses;
	int x;
	int y;
	
	public gameController() 
	{
		nullResponses = new ArrayList<String>();
		map = new Room[11][10];
		scanner = new Scanner(System.in);
		x = 5;
		y = 5;
	}
	public void start() 
	{
		setupMap();
		setupNullResponses();
		test();
	}
	private void setupMap() 
	{
		map[5][5] = new Room("|A HALL|", "There are a line of lockers aligned further North of you.");
		map[6][5] = new Room("|B Hall|", "There is a lot of lockers to your East and West");
	}
	private void setupNullResponses() 
	{
		nullResponses.add("Not like this");
		nullResponses.add("But y");
		nullResponses.add("Nani");
	}
	private String generateNullResponse() 
	{
		int random = (int) (Math.random() * nullResponses.size());
		return nullResponses.get(random);
	}
	private void test() 
	{
		boolean status = true;
		while (status) 
		{
			System.out.println(map[x][y].getTotal());
			System.out.print("Action: ");
			String actionInput = scanner.nextLine();
			System.out.print("\n");
			if (actionInput.equals("move")) 
			{
				moveNorth();
			}
			else {
				System.out.println("Not move");
			}
		}
	}
	private void moveNorth() 
	{
		if (map[x+1][y] != null) 
		{
			x++;
		}
		else 
		{
			System.out.println(generateNullResponse());
		}
	}
}
