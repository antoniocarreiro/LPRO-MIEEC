package circuit.logic;


public class GateNot extends LogicGate{
	
	LogicVariable i1;
	protected String gateType;
	
	public GateNot(LogicVariable w1, LogicVariable i1) throws ColisionException, CycleException{
		super(w1, i1);
		this.i1 = i1;

		this.gateType = "NOT";
	}

	//No need for Override, that's abstract's function. G2K
	public String getSymbol() {
		return gateType;
	}
	
	@Override
	public boolean getValue() {
		return !i1.getValue();
	}
	
	@Override
	public LogicVariable[] getInputs() {
		return new LogicVariable[] {i1};
	}
}
