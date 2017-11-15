package circuit.logic;


public class LogicVariable {

	protected String name;
	protected boolean value;
	
	protected LogicGate gate = null;
	
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
		if(gate == null)
			return value;
		return gate.getValue();
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public LogicGate getCalculatedBy() {
		return gate;
	}

	public void setCalculatedBy(LogicGate gate) {
		this.gate = gate;
	}
	
	public boolean isChild(LogicVariable a) {
		if(gate == null)
			return false;
		return gate.isChild(a);
	}

	public String getFormula() {
		if(gate == null)
			return name;
		else
			return gate.getFormula();
	}
	
	@Override
	public boolean equals(Object obj) {
		LogicVariable newObj = (LogicVariable) obj;
		return this.name.equals(newObj.name);
	}
	
}
