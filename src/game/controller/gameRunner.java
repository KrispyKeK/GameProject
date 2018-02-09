package game.controller;

import game.model.*;

public class gameRunner 
{
	public static void main(String[]args) 
	{
		//gameController start = new gameController();
		Map begin = new Map();
		if (begin.x == 5) {
			System.out.println(begin.map[begin.x][begin.y].getName());
			begin.move();
		}
		System.out.println(begin.map[begin.x][begin.y].getName());
	}
}
