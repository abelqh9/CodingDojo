package com.codingdojo;

public class PruebaLista {

	public static void main(String[] args) {
        ListaSimpleEnlazada sll = new ListaSimpleEnlazada();
        
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        
        //sll.add(15);
        //sll.add(2);
        //sll.remove();
        //sll.remove();
        
        sll.eliminarEn(3);
        
        sll.printValues();
        
        //Nodo n = (Nodo) sll.encontrar(4);
        //System.out.println(n.value);
	}
}