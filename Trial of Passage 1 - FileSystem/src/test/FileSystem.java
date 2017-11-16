package test;

public class FileSystem {
	
	protected String type;
	protected Folder root;


	public FileSystem(String type) {
		super();
		this.type = type;
		this.root = root;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Folder getRoot() {
		return root;
	}

	public void setRoot(Folder root) {
		this.root = root;
	}
	
	
	
}
