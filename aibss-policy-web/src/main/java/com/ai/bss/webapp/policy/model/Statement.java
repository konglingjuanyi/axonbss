package com.ai.bss.webapp.policy.model;

public class Statement {
	private String leftType;
	private String rightType;
	private String operatorCode;
	private Variable leftVariable;
	private ConstValue leftConstValue;
	private EnumValue leftEnumValue;
	private FunctionValue leftFunctionValue;
	private Variable rightVariable;
	private ConstValue rightConstValue;
	private EnumValue rightEnumValue;
	private FunctionValue rightFunctionValue;
	public Statement() {
		// TODO Auto-generated constructor stub
	}
	public String getLeftType() {
		return leftType;
	}
	public void setLeftType(String leftType) {
		this.leftType = leftType;
	}
	public String getRightType() {
		return rightType;
	}
	public void setRightType(String rightType) {
		this.rightType = rightType;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public Variable getLeftVariable() {
		return leftVariable;
	}
	public void setLeftVariable(Variable leftVariable) {
		this.leftVariable = leftVariable;
	}
	public ConstValue getLeftConstValue() {
		return leftConstValue;
	}
	public void setLeftConstValue(ConstValue leftConstValue) {
		this.leftConstValue = leftConstValue;
	}
	public EnumValue getLeftEnumValue() {
		return leftEnumValue;
	}
	public void setLeftEnumValue(EnumValue leftEnumValue) {
		this.leftEnumValue = leftEnumValue;
	}
	public FunctionValue getLeftFunctionValue() {
		return leftFunctionValue;
	}
	public void setLeftFunctionValue(FunctionValue leftFunctionValue) {
		this.leftFunctionValue = leftFunctionValue;
	}
	public Variable getRightVariable() {
		return rightVariable;
	}
	public void setRightVariable(Variable rightVariable) {
		this.rightVariable = rightVariable;
	}
	public ConstValue getRightConstValue() {
		return rightConstValue;
	}
	public void setRightConstValue(ConstValue rightConstValue) {
		this.rightConstValue = rightConstValue;
	}
	public EnumValue getRightEnumValue() {
		return rightEnumValue;
	}
	public void setRightEnumValue(EnumValue rightEnumValue) {
		this.rightEnumValue = rightEnumValue;
	}
	public FunctionValue getRightFunctionValue() {
		return rightFunctionValue;
	}
	public void setRightFunctionValue(FunctionValue rightFunctionValue) {
		this.rightFunctionValue = rightFunctionValue;
	}
	

}
