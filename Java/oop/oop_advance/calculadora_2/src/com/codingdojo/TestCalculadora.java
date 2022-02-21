package com.codingdojo;

public class TestCalculadora {

	public static void main(String[] args) {
		
		Calculadora newCalculadora = new Calculadora();
		
		newCalculadora.realizarOperacion(10.5);

		newCalculadora.realizarOperacion("+");

		newCalculadora.realizarOperacion(5.2);

		newCalculadora.realizarOperacion("*");
		
		newCalculadora.realizarOperacion(10.0);
		
		System.out.println(newCalculadora.getResultados());
	}
}
