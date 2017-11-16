package test;

public class Folder {

	protected Folder parent = null;
	protected String name;
	
	public Folder() {
		this.parent = null;
		this.name = "root";
	}

	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
