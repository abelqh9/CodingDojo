package com.codingdojo;

public class DLLTest {

	public static void main(String[] args) {
		
        DLL dll = new DLL();
        
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        
        System.out.println("==================");
        
        dll.printValuesBackward();
        
        System.out.println("==================");
        
        System.out.println("valor eliminado: " + dll.pop().value);
        dll.printValuesForward();
        
        System.out.println("==================");
        
        System.out.println(dll.contains(80));
        System.out.println(dll.contains(10));
        
        System.out.println("==================");
        
        System.out.println(dll.size());
        
        System.out.println("==================");
        
        dll.insertAt(n6, 1);
        dll.printValuesForward();
        
        System.out.println("==================");
        
        dll.removeAt(0);
        dll.printValuesForward();
	}
}