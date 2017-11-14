package circuit.logic;


public class GateNot extends LogicGate{
	
	LogicVariable i1;
	protected String gateType;
	
	public GateNot(LogicVariable w1, LogicVariable i1) throws ColisionException{
		super(w1, i1);
		this.i1 = i1;
		this.out = w1;
		this.gateType = "NOT";
	}

	public String getSymbol() {
		return gateType;
	}
	
	@Override
	public LogicVariable[] getInputs() {
		return new LogicVariable[] {i1};
	}
}
