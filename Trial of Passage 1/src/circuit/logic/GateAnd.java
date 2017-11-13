package circuit.logic;

public class GateAnd extends LogicGate {
	
	LogicVariable i1;
	LogicVariable i2;
	protected String gateType;
	
	public GateAnd(LogicVariable w1, LogicVariable i1, LogicVariable i2) {
		this.i1 = i1;
		this.i2 = i2;
		this.out = w1;
		gateType = "AND";
	}
	
	public String getSymbol() {
		return gateType;
	}
	
	@Override
	public LogicVariable[] getInputs() {
		return new LogicVariable[] {i1, i2};
	}

}
