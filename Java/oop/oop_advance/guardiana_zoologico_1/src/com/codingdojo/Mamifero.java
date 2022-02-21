package com.codingdojo;

public class Mamifero {
	
	private int nivelDeEnergia;
	
	public Mamifero() {
		this.nivelDeEnergia = 100;
	}
	
	public int getNivelDeEnergia() {
		return nivelDeEnergia;
	}
	
	public void aumentarEnergia(int energia) {
		this.nivelDeEnergia += energia;
	}

	public void disminuirEnergia(int energia) {
		this.nivelDeEnergia -= energia;
	}

	public int mostrarEnergia() {
		System.out.println(nivelDeEnergia);
		return nivelDeEnergia;
	}
}
