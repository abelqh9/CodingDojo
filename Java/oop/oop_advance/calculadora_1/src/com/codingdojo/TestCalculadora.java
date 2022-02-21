package com.codingdojo;

public class TestCalculadora {

	public static void main(String[] args) {
		
		Calculadora newCalculadora = new Calculadora();
		
		newCalculadora.setOperandoUno(10.5);

		newCalculadora.setOperacion("+");

		newCalculadora.setOperandoDos(5.2);

		newCalculadora.realizarOperacion();

		System.out.println(newCalculadora.getResultados());
	}
}
