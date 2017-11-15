package circuit.logic;


public class GateAnd extends LogicGate {
	
	LogicVariable i1;
	LogicVariable i2;
	protected String gateType;
	
	public GateAnd(LogicVariable w1, LogicVariable i1, LogicVariable i2) throws ColisionException, CycleException{
		super(w1, i1, i2);
		this.i1 = i1;
		this.i2 = i2;
		gateType = "AND";
	}
	
	//No need for Override, that's abstract's function. G2K
	public String getSymbol() {
		return gateType;
	}
	
	@Override
	public boolean getValue() {
		return i1.getValue() && i2.getValue();
	}
	
	@Override
	public LogicVariable[] getInputs() {
		return new LogicVariable[] {i1, i2};
	}

}
