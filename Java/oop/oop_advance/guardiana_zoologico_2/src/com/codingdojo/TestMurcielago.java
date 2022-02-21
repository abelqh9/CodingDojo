package com.codingdojo;

public class TestMurcielago {

	public static void main(String[] args) {
		Murcielago newMurcielago = new Murcielago();
		
		newMurcielago.mostrarEnergia();
		
		newMurcielago.atacarPueblo();
		newMurcielago.atacarPueblo();
		newMurcielago.atacarPueblo();
		
		newMurcielago.comerHumanos();
		newMurcielago.comerHumanos();
		
		newMurcielago.volar();
		newMurcielago.volar();
		
		newMurcielago.mostrarEnergia();
	}
}
