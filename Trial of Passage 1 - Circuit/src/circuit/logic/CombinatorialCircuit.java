package circuit.logic;


public class CombinatorialCircuit {
	
	protected Variables variable = new Variables();
	
	public boolean addVariable(LogicVariable a) {
		if(variable.varName.contains(a.getName()))
			return false;
		variable.varName.add(a.getName());
		variable.logicVar.add(a);
		return true;
	}

	public LogicVariable getVariableByName(String varName) {
		if(variable.varName.contains(varName))
			return variable.logicVar.get(variable.varName.indexOf(varName));
		return null;
	}
}
