package com.codingdojo;

public class Pintura extends Arte {
	
	private String tipoPintura;
	
	public Pintura(String titulo, String autor, String descripcion, String tipoPintura) {
		super(titulo, autor, descripcion);
		this.tipoPintura = tipoPintura;
	}
	
	public void verArte() {
		System.out.println("Hola, soy una Pintura :)");
		System.out.println("Titulo: "+ this.getTitulo() + " - Autor: " + this.getAutor() + " - Descripcion: " + this.getDescripcion() + " - Tipo de Pintura: " + tipoPintura);
	}

	public String getTipoPintura() {
		return tipoPintura;
	}

	public void setTipoPintura(String tipoPintura) {
		this.tipoPintura = tipoPintura;
	}
}
