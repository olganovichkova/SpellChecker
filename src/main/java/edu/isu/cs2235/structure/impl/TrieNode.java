package edu.isu.cs2235.structure.impl;

import edu.isu.cs2235.structure.Node;

import java.util.*;

public class TrieNode implements Node {

    private Character letter;   //variable for storing a letter
    private boolean isEndOfWord;    //variable for storing true or false based on if it is the end of the word or not

    //constructor
    public TrieNode(Character letter, boolean isEndOfWord) {
        this.letter = letter;
        this.isEndOfWord = isEndOfWord;
    }

    public Map<Character, TrieNode> children = new HashMap<>();

    public Character getLetter() {
        return letter;
    }

    public boolean getIsEndOfWord() {
        return isEndOfWord;
    }

    public void setIsEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void process(String s, int startIndex) {

        char curr = s.charAt(startIndex); //variable is assigned to a character at the index from the word
        boolean isEnd = false;
        if(s.length() == startIndex + 1){   //checks to see if it is the end of the word
            isEnd = true;
        }

        TrieNode node = children.get(curr);
        if(node == null){
            node = new TrieNode(curr, isEnd);
            children.put(curr, node);
        }

        if(isEnd){
            node.setIsEndOfWord(isEnd);
        } else {
            node.process(s, startIndex + 1);
        }
    }


}
