package astNodes;

public class ParamCallFunction {
	
	private String returnType;
	private String variableType;
		
	public ParamCallFunction(String returnType, String variableType) {
		super();
		this.returnType = returnType;
		this.variableType = variableType;
	}
	
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getVariableType() {
		return variableType;
	}
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

	@Override
	public String toString() {
		return "ParamCallFunction [returnType=" + returnType + ", variableType=" + variableType + "]";
	}
	
	
	

}
