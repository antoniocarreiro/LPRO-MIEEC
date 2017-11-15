package logic;

import java.util.ArrayList;

public class Building  implements Facility{

	protected String name;
	protected int minFloor;
	protected int maxFloor;
	protected int capacity;
	protected ArrayList<Room> rooms = new ArrayList<>();
	
	public Building(String name, int minFloor, int maxFloor) {
		if(maxFloor < minFloor)
			throw new IllegalArgumentException();
		this.name = name;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
	}

	public Building(String name, int minFloor, int maxFloor, int capacity) {
		if(maxFloor < minFloor)
			throw new IllegalArgumentException();
		this.name = name;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
		this.capacity = capacity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(int minFloor) {
		this.minFloor = minFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}
	
	public String toString() {
		return "Building(" + this.name + ")";			
	}

	public int getCapacity() {
		int nrRooms = 0;
	    
		for(Room room : rooms)
	        nrRooms += room.getCapacity();
	    
	    return nrRooms;	    
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean canEnter(User user) {
		for(Room room : rooms)
			if(room.canEnter(user))
				return true;
		return false;
	}
	
}
