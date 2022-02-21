package com.codingdojo;

public class Gorila extends Mamifero{
	
	public void lanzarAlgo(String cosa) {
		System.out.println("El gorila arrojó "+cosa+".");
		this.disminuirEnergia(5);
	}
	public void comerBananas() {
		System.out.println("El gorila comió una banana, está feliz.");
		this.aumentarEnergia(10);
	}
	public void escalar() {
		System.out.println("El gorila ha trepado un árbol.");
		this.disminuirEnergia(10);
	}
}
