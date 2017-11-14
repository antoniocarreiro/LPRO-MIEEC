package circuit.logic;


public class GateOr extends LogicGate{
	
	LogicVariable i1;
	LogicVariable i2;
	protected String gateType;
	
	public GateOr(LogicVariable w1, LogicVariable i1, LogicVariable i2) throws ColisionException, CycleException {
		super(w1, i1, i2);
		this.i1 = i1;
		this.i2 = i2;
		this.out = w1;
		this.gateType = "OR";
		
	}
	
	public String getSymbol() {
		return gateType;
	}
	
	@Override
	public LogicVariable[] getInputs() {
		return new LogicVariable[] {i1, i2};
	}

}
