package com.codingdojo;

import java.util.ArrayList;

public class Calculadora implements java.io.Serializable {
	
	private ArrayList<Object> operandos = new ArrayList<Object>();
	
	public Calculadora() {
	}
	
	public void realizarOperacion(Object operando) {
		operandos.add(operando);
	}
	
	public double getResultados() {
		System.out.println(operandos);
		while(operandos.contains("*") || operandos.contains("/")) {			
			for (int i = 0; i<operandos.size(); i++) {
				if (operandos.get(i) == "*" || operandos.get(i) == "/") {
					double op1 = (double) operandos.get(i-1);
					double op2 = (double) operandos.get(i+1);
					if(operandos.get(i) == "*") {
						operandos.set(i-1, op1*op2);
					}
					if(operandos.get(i) == "/") {
						operandos.set(i-1, op1/op2);
					}
					operandos.remove(i+1);
					operandos.remove(i);
				}
			}
		}
		System.out.println(operandos);
		while(operandos.contains("+") || operandos.contains("-")) {			
			for (int i = 0; i<operandos.size(); i++) {
				if (operandos.get(i) == "+" || operandos.get(i) == "-") {
					double op1 = (double) operandos.get(i-1);
					double op2 = (double) operandos.get(i+1);
					if(operandos.get(i) == "+") {
						operandos.set(i-1, op1+op2);
					}
					if(operandos.get(i) == "-") {
						operandos.set(i-1, op1-op2);
					}
					operandos.remove(i+1);
					operandos.remove(i);
				}
			}
		}
		
		System.out.println(operandos);
		return (double) operandos.get(0);
	}	
}