package game.model;

public class Item 
{
	String name;
	String description;
	int x;
	int y;
	boolean access;
	public Item(String name, String description, int x, int y, boolean access) 
	{
		this.name = name;
		this.description = description;
		this.x = x;
		this.y = y;
		this.access = access;
	}
	public String getName() 
	{
		return name;
	}
	public String getDescription() 
	{
		return description;
	}
	public int getLocationX() 
	{
		return x;
	}
	public int getLocationY() 
	{
		return y;
	}
	public String getItemDetail() 
	{
		return name + "\n" + description;
	}
}
