package com.codingdojo;

import java.util.ArrayList;

public class Museo {

	public static void main(String[] args) {
		
		ArrayList<Arte> museo = new ArrayList<Arte> ();
		
		Pintura p1 = new Pintura("PINTURA1", "ABELQH", "LINDA PINTURA", "GOTICA");
		Pintura p2 = new Pintura("PINTURA2", "ABELQH", "LINDA PINTURA", "CLÁSICA");
		Pintura p3 = new Pintura("PINTURA3", "ABELQH", "LINDA PINTURA", "ACTUAL");
		
		Escultura e1 = new Escultura("ESCULTURA1", "LEOQH", "LINDA ESCULTURA", "ARCILLA");
		Escultura e2 = new Escultura("ESCULTURA2", "LEOQH", "LINDA ESCULTURA", "BARRO");
		
		museo.add(p1);
		museo.add(p2);
		museo.add(p3);
		
		museo.add(e1);
		museo.add(e2);
		
		p1.verArte();
		e1.verArte();
		p3.verArte();
		e2.verArte();
		p2.verArte();
	}
}
