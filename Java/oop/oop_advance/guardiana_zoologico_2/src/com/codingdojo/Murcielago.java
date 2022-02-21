package com.codingdojo;

public class Murcielago extends Mamifero {
	
	public Murcielago(){
		this.setNivelDeEnergia(300);
	}
	
	public void volar() {
		System.out.println("*Sonido de murcielago despegando*");
		this.disminuirEnergia(50);
	}
	
	public void comerHumanos() {
		System.out.println("*Sonido de murcielago comiendose un humano*");
		this.aumentarEnergia(25);		
	}
	
	public void atacarPueblo() {
		System.out.println("*Sonido de pueblo en llamas*");
		this.disminuirEnergia(100);
	}
}