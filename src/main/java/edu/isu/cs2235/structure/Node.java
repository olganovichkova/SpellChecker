package edu.isu.cs2235.structure;

import edu.isu.cs2235.structure.impl.TrieNode;

import java.util.Map;

/*
*  @author Olga Novichkova
*
* Interface for the implementation of the TrieNode class
* */
public interface Node {

    /*
     *The getIsEndOfWord() method returns boolean.
     * True if it is the end of the word,
     * otherwise it returns false.
     * */
    boolean getIsEndOfWord();


    /*
     *The setIsEndOfWord() method accepts boolean
     * for isEndOfWord and changes it to true if
     * there is a short word which also is part
     * of a longer word.
     * */
    void setIsEndOfWord(boolean isEndOfWord);


    /*
     *The getChildren() method returns an array
     * out of TrieNodes which will represent the
     * children.
     * */
    Map<Character, TrieNode> getChildren();

    /*
     * The process() method accepts a String and an integer.
     * String is a word and the integer is the index on that
     *  word at which to start processing from. Create a new node
     * for each letter processed. Does not return anything.
     * */
    void process(String s, int startIndex);

}
