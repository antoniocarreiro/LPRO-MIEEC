package circuit.logic;

public abstract class LogicGate {
	
	protected LogicVariable out;
	protected String gateType;
	
	public LogicVariable getOutput() {
		return out;
	}
	
	public abstract Object[] getInputs();
	
	public abstract String getSymbol();
}
