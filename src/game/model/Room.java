package game.model;

public class Room 
{
	String name;
	int description;
	public Room(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return description;
	}
}
