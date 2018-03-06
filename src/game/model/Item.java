package game.model;

public class Item 
{
	String name;
	String description;
	public Item(String name, String description) 
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
