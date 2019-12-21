package edu.isu.cs2235.structure;

import java.util.List;


/*
 * @author Olga Novichkova
 *
 * Interface for the implementation of the Trie class
 * */
public interface TrieI {


    /*
     *The search() method accepts a String word and checks
     * if the word exists in the trie or not. Returns True if
     * word found, otherwise false.
     * */
    boolean search(String word);


    /*
     *The insert() method accepts a String word and inserts
     * it into the trie. The process function should be called
     * from the start point(root). Does not return anything.
     * */
    void insert(String word);


    /*
     *The findSuggestion() method accepts a String prefix and it returns
     * a list of all the String words from the trie that include
     * the prefix(all the children after the last letter of the prefix).
     * If there are no words that include teh prefix an empty list
     * is returned.
     * */
    List<String> findSuggestion(String prefix);
}
