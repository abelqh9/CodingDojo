package com.codingdojo;

public class Escultura extends Arte {
	
	private String material;

	public Escultura(String titulo, String autor, String descripcion, String material) {
		super(titulo, autor, descripcion);
		this.material = material;
	}
	
	public void verArte() {
		System.out.println("Hola, soy una Escultura :)");
		System.out.println("Titulo: "+ this.getTitulo() + " - Autor: " + this.getAutor() + " - Descripcion: " + this.getDescripcion() + " - Tipo de Pintura: " + material);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}
