package com.codingdojo;

public class DLL {
	
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    public void push(Node newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        Node current = this.head;
        
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
        Node current = this.tail;
        
        while(current != null) {
            System.out.println(current.value);
            current = current.previous;
        }
    }
    
    public Node pop() {
    	Node nodeToRemove = this.tail;
    	this.tail = this.tail.previous;
        this.tail.next = null;
        return nodeToRemove;
    }
    
    public boolean contains(Integer value) {
        Node current = this.head;
        
        while(current != null) {
        	if(current.value == value) {
        		return true;
        	}
            current = current.next;
            
        }
        
        return false;
    }
    
    public int size() {
    	int sizeToReturn = 0;
    	
    	if(this.head != null) {
    		Node current = this.head;
    		
    		while(current != null) {
    			current = current.next;
    			sizeToReturn++;
    		}
    	}
        
		return sizeToReturn;
    }
    
    public void insertAt(Node newNode, int index) {
    	if(index == 0) {
    		Node oldHead = this.head;
    		this.head = newNode;
    		this.head.next = oldHead;
    		oldHead.previous = this.head;
    		
    	}else {
    		Node current = this.head;   	
    		
    		for (int i = 0; i<index-1; i++) {
    			current = current.next;
    		}
    		newNode.next = current.next;
    		newNode.previous = current;
    		current.next.previous = newNode;
    		current.next = newNode;    		
    	}
    }
    
    public void removeAt(int index) {
    	Node current = this.head;
    	
		if (current != null) {
			if(index == 0) {
				this.head.next.previous = null;
				this.head = this.head.next;
			}else {
				for (int i = 0; i < index; i++) {
					current = current.next;
				}
				current.previous.next = current.next;
				current.next.previous = current.previous;    		
			}			
		}
    	
    }
}
