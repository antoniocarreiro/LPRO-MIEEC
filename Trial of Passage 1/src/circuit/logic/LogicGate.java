package circuit.logic;


public abstract class LogicGate {
	
	protected LogicVariable output;
	protected LogicVariable[] inputs;
	
	public LogicGate(LogicVariable output, LogicVariable ... inputs) throws ColisionException, CycleException {
		if(output.getCalculatedBy() != null)
			throw new ColisionException();
		this.output = output;
		this.inputs = inputs;
		output.setCalculatedBy(this);
		
		for(LogicVariable input : inputs)
			if(input.getCalculatedBy() == output.gate)
				throw new CycleException();
	}
	
	protected LogicVariable out;
	
	public LogicVariable getOutput() {
		return out;
	}
	
	public abstract Object[] getInputs();
	
	public abstract String getSymbol();
	
	public String getFormula() {
		String str = getSymbol() + "(";
		for (int i = 0; i < input.length; i++) {
			if(i > 0)
				str = str + ",";
			str = str + input[i].getFormula();
		}
		return str+")";
	}
}
