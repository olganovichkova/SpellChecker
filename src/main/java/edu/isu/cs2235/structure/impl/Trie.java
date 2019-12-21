package edu.isu.cs2235.structure.impl;

import edu.isu.cs2235.structure.TrieI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Trie implements TrieI {

    public static final String DICTIONARY = "en-US.dic.txt";    //txt file with the dictionary

    public TrieNode root = null;    //variable to store the root

    //method which creates a new trieNode and returns it
    private TrieNode createTrieNode(char letter, boolean isEndOfWord){

        return new TrieNode(letter, isEndOfWord);
    }

    //constructor which sets the root
    public Trie(){
        root = new TrieNode(null, true);
    }


    @Override
    public boolean search(String word) {
        TrieNode runner = root; //variable to run through the trie levels(depth)
        for(int i = 0; i < word.length(); i++){ //loop to run through each letter of the word
            Character curr = word.charAt(i);    //get the letter at the current index
           if(runner.getChildren().get(curr) == null){
               return false;
           } else{
               runner = runner.getChildren().get(curr);
           }
            if((i + 1) == word.length() && runner.getIsEndOfWord() != true){    //if index of provided word is on the last letter
                return false;                                                   //but the runner is not at the end of word
            }
        }
        return true; //if none of the above applies then the word exists in trie
    }


    @Override
    public void insert(String word) {
        root.process(word, 0);  //set startIndex to zero so process starts from first letter of word
    }


    @Override
    public List<String> findSuggestion(String word) {
        String prefix = "";
        List<String> words = new ArrayList<>(); //create new empty list for storing words which include provided word
        TrieNode runner = root; //set variable runner to the start point(root)
        for(int i = 0; i < word.length(); i++){   //loop to run through each letter of the word
            Character curr = word.charAt(i);  //get the letter at the current index

            if(runner.getChildren().get(curr) == null){ //if runner does not find letter
                break;
            } else {
                runner = runner.getChildren().get(curr);    //runner variable moves down to next trie level
                prefix += curr; //build the prefix off of the word
            }
        }

        if(!prefix.isEmpty()) {
            collectWords(prefix, runner, words);    //recursion
        }


        return words;   //returns the list of all words which include the word
    }

// recursion function which builds onto the prefix
    private List<String> collectWords(String prefix, TrieNode runner, List<String> list){   //parameter accepts the prefix, runner, and list
        if(runner.getIsEndOfWord() == true) { //if the runner reaches the end of a word
            list.add(prefix);   //add the prefix to list
        }

        Iterator<TrieNode> it = runner.getChildren().values().iterator();   //variable to represent the iterator for the hashmap

        while(it.hasNext()){
            TrieNode child = it.next();
            if(list.size() < 3){    //the list size is max 3
                String buildWord = prefix + child.getLetter();  //variable buildWord builds letter onto the prefix
                collectWords(buildWord, child, list);   //call itself and set prefix to buildWord, runner to the runner child
            }
        }
        return list;    //return created list of the build words
    }




}
