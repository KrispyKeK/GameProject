package game.model;

public class Room 
{
	String name;
	String description;
	public Room(String name, String description) 
	{
		this.name = name;
		this.description = description;
	}
	public String getName() 
	{
		return name;
	}
	public String getDescription() 
	{
		return description;
	}
	public String getTotal() 
	{
		return name + "\n" + description;
	}
}
