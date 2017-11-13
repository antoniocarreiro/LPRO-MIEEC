package circuit.logic;

public class LogicVariable {

	protected String name;
	protected boolean value;
	
	public LogicVariable(String name, boolean value) {
		this.name = name;
		this.value = value;
	}
	
	public LogicVariable(String name) {
		this(name, false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		LogicVariable newObj = (LogicVariable) obj;
		return this.name.equals(newObj.name);
	}
	
}
