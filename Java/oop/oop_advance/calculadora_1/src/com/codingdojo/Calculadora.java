package com.codingdojo;

public class Calculadora implements java.io.Serializable {
	
	private double operandoUno;
	private String operacion;
	private double operandoDos;
	private double resultados;
	
	
	public Calculadora() {
	}
	
	
	public double getOperandoUno() {
		return operandoUno;
	}
	public void setOperandoUno(double operandoUno) {
		this.operandoUno = operandoUno;
	}
	
	
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
	public double getOperandoDos() {
		return operandoDos;
	}
	public void setOperandoDos(double operandoDos) {
		this.operandoDos = operandoDos;
	}
	
	
	public double getResultados() {
		return resultados;
	}
	public void setResultados(double resultados) {
		this.resultados = resultados;
	}
	
	
	public void realizarOperacion() {
		if ( this.operacion.equals("+") ) {
			this.resultados = this.operandoUno + this.operandoDos;
			return;
		}
		if ( this.operacion.equals("-") ) {
			this.resultados = this.operandoUno - this.operandoDos;
			return;
		}
	}
}
