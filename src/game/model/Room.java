package game.model;

public class Room {
	String name;
	int number;
	public Room(String name, int number) 
	{
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}
	public void setName() {
		this.name = name;
	}
	public void setNumber() {
		this.number = number;
	}
}
