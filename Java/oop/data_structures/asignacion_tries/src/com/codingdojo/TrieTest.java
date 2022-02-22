package com.codingdojo;

public class TrieTest {

	public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        trie.insertWord("abel");
        
        //System.out.println(trie.isPrefixValid("chi"));
        //System.out.println(trie.isWordValid("chip"));
        
        trie.printAllKeysOfKidsNodes(trie.root);
	}

}
