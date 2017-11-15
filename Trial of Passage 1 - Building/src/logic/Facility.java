package logic;

public interface Facility {
	
	public abstract String getName();
	public abstract String toString();
	public abstract boolean canEnter(User user);
	
}
