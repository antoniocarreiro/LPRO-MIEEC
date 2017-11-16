package logic;

import java.util.ArrayList;

public class Room implements Facility{

	protected Building building;
	protected String number;
	protected int floor;
	protected int capacity;
	protected ArrayList<User> users = new ArrayList<>();
	
	public Room(Building building, String number, int floor) throws DuplicateRoomException {
		if(floor > building.getMaxFloor() || floor < building.getMinFloor())
			throw new IllegalArgumentException();
		
		this.building = building;
		this.number = number;
		this.floor = floor;
		
		for(Room room : this.building.rooms)
			if(this.equals(room))
				throw new DuplicateRoomException();
		
		this.building.rooms.add(this);
	}
	
	public Room(Building building, String number, int floor, int capacity) throws DuplicateRoomException {
		if(floor > building.getMaxFloor() || floor < building.getMinFloor())
			throw new IllegalArgumentException();
		
		this.building = building;
		this.number = number;
		this.floor = floor;
		this.capacity = capacity;
		
		
		for(Room room : this.getBuilding().rooms)
			if(this.equals(room))
				throw new DuplicateRoomException();
		
		this.building.rooms.add(this);
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return building.getName() + number;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public String toString(){
		return "Room(" + this.building.name + "," + this.number + ")";			
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void authorize(User user) {
		users.add(user);		
	}

	public boolean canEnter(User user) {
		for(User u : users)
			if(user.equals(u))
				return true;
		return false;
	}
}
