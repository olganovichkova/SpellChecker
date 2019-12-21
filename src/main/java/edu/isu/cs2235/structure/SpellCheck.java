package edu.isu.cs2235.structure;


/*
*  @author Olga Novichkova
*
* Interface for the implementation of the SpellChecker class
* */
public interface SpellCheck {

    /*
    * Techniques for generating suggestions
    * -swapping each adjacent pair of letters in a word
    * -in between each adjacent pair of letters insert a-z
    * -deleting each letter in the word
    *-
    * */


    String spellCheck(String sentence);


    /*
     * The load() method has no parameters. This method reads from
     * a file(dictionary in this case) and processes all the words
     * and builds a trie.
     * */
    void load();
}
