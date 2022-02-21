package com.codingdojo;

public class Gorila extends Mamifero{
	
	public void lanzarAlgo(String cosa) {
		System.out.println("El gorila arroj� "+cosa+".");
		this.disminuirEnergia(5);
	}
	public void comerBananas() {
		System.out.println("El gorila comi� una banana, est� feliz.");
		this.aumentarEnergia(10);
	}
	public void escalar() {
		System.out.println("El gorila ha trepado un �rbol.");
		this.disminuirEnergia(10);
	}
}
