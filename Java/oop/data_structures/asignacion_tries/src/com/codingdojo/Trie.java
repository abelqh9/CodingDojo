package com.codingdojo;

public class Trie {
	
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        Node currentNode = this.root;
        
        for(int i = 0; i < word.length(); i++) {
            Character currentLetter = word.charAt(i);
            
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    
    public boolean isPrefixValid(String prefix) {
    	boolean valid = true;
        Node currentNode = this.root;
    	
        for(int i = 0; i < prefix.length(); i++) {
        	
            Character currentLetter = prefix.charAt(i);
            
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
            	valid = false;
            	break;
            }else {
                currentNode = child;
            }
        }
        
    	return valid;
    }
    
    public boolean isWordValid(String word) {
    	boolean valid = true;
        Node currentNode = this.root;
    	
        for(int i = 0; i < word.length(); i++) {
        	
            Character currentLetter = word.charAt(i);
            
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
            	valid = false;
            	break;
            }else {
                currentNode = child;
            }
        }
        
        if(!currentNode.isCompleteWord) {
        	valid = false;
        }
    	
    	return valid;
    }
    

    
    public void printAllKeysOfKidsNodes(Node currentNode) {
        for(Character key : currentNode.children.keySet()) {
        	System.out.println(key);
        	printAllKeysOfKidsNodes(currentNode.children.get(key));
        }
    }
}
