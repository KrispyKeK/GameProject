package game.model;

public class Room 
{
	String name;
	String description;
	String direction;
	boolean access;
	public Room(String name, String description,String direction, boolean access) 
	{
		this.name = name;
		this.description = description;
		this.direction = direction;
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
	public boolean getAccess() 
	{
		return access;
	}
	public String getDirection() 
	{
		return direction;
	}
	public String getRoomDetail() 
	{
		return name + "\n" + description + "\n" + direction;
	}
	public void setDirection(String direction) 
	{
		this.direction = direction;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public void setAccess(boolean access) 
	{
		this.access = access;
	}
}
