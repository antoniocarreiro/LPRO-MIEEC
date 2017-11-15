package logic;

public class User {

	protected String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		User that = (User) obj;
		return this.getName() == that.getName();
	}
	
}
