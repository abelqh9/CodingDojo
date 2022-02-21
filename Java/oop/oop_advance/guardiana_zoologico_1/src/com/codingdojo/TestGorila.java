package com.codingdojo;

public class TestGorila {

	public static void main(String[] args) {
		Gorila newGorila = new Gorila();
		
		newGorila.mostrarEnergia();
		
		newGorila.lanzarAlgo("una roca");
		newGorila.lanzarAlgo("una rama");
		newGorila.lanzarAlgo("otra roca");
		
		newGorila.comerBananas();
		newGorila.comerBananas();
		
		newGorila.escalar();
		
		newGorila.mostrarEnergia();
	}

}
