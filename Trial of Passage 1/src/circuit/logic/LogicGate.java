package circuit.logic;


public abstract class LogicGate {
	
	protected LogicVariable output;
	protected LogicVariable[] input;
	
	public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
		if(output.getCalculatedBy() != null)
			throw new ColisionException();
		this.output = output;
		this.input[0] = input1;
		this.input[1] = input2;
		output.setCalculatedBy(this);
		
		for(LogicVariable input : input)
			if(input.getCalculatedBy() == output.gate)
				throw new CycleException();
	}
	
	public LogicGate(LogicVariable output, LogicVariable input1) throws ColisionException {
		if(output.getCalculatedBy() != null)
			throw new ColisionException();
		this.output = output;
		this.input[0] = input1;
		output.setCalculatedBy(this);
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
