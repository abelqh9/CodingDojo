package com.codingdojo;

public class ListaSimpleEnlazada {

    public Nodo head;
    
    public ListaSimpleEnlazada() {
        this.head = null;
    }
    
    // Los métodos de SLL van aquí. Para empezar, te mostraremos cómo agregar un nodo a la lista.
    public void add(int value) {
        Nodo newNodo = new Nodo(value);
        if(head == null) {
            head = newNodo;
        } else {
            Nodo runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNodo;
        }
    }
    
    public void remove() {
        if(head != null) {
        	if (head.next != null) {
        		Nodo runner = head;
        		while(runner.next.next != null) {
        			runner = runner.next;
        		}
        		runner.next = null;        		
        	}else {
        		this.head = null; 
        	}
        }
    }
    
    public void printValues() {
        if(head != null) {
        	Nodo runner = head;
        	while(runner != null) {
        		System.out.println(runner.value);
        		runner = runner.next;        		
        	}
        }
    }
    
    public Object encontrar(int value) {
        if(head != null){
            Nodo runner = head;
            while(runner.next != null) {
            	//System.out.println(runner.value + " " + value);
            	if (runner.value == value) {
                	//System.out.println(runner.value);
            		return runner;
            	}
                runner = runner.next;
            }
            if (runner.value == value) {
            	return runner;
            }else {
            	return null;            	
            }
        }else {
        	return null;
        }
    }
    
    public void eliminarEn(int n) {
        if(head != null){
        	if(n == 0) {
        		this.head = head.next;
        	}
        	Nodo runner = head;
        	for(int i = 0; i<=n; i++) {
        		if (i == n-1) {
        			runner.next = runner.next.next;
        		}else {
        			if (runner.next != null) {
        				runner = runner.next;
        			}else {break;}
        		}        			
        	}
        }
    }
}
