package edu.isu.cs2235;


import edu.isu.cs2235.structure.SpellCheck;
import edu.isu.cs2235.structure.impl.Trie;

import java.io.*;
import java.util.List;
import java.util.Scanner;


/*
* ispell and aspell for generating the correctly spelled words(should be a list)
*
*
* */
public class SpellChecker implements SpellCheck {

    public static final String DICTIONARY = "en-US.dic.txt";    //txt file with the dictionary
    public static final String SHORT_DICTIONARY = "testDic.txt";    //txt file with shorter version of dictionary for testing

    public Trie trie;

    //constructor
    public SpellChecker(){
        trie = new Trie();
    }



    @Override
    public String spellCheck(String sentence) {
        String fixedSentence = "";
        String[] words = sentence.split(" ");


        for(int i = 0; i < words.length; i++){
            String word = words[i].trim();
            String cWord = "";
            if(!word.equals("")) {
                String postfix = "";
                String prefix = "";
                if (Character.compare(word.charAt(0), '.') == 0 ||
                    Character.compare(word.charAt(0), '?') == 0 ||
                    Character.compare(word.charAt(0), '!') == 0) {
                    prefix = "" + word.charAt(0);
                    word = word.substring(1);
                }
                if (Character.compare(word.charAt(word.length() - 1), '.') == 0 ||
                    Character.compare(word.charAt(word.length() - 1), '?') == 0 ||
                    Character.compare(word.charAt(word.length() - 1), '!') == 0) {
                    postfix = "" + word.charAt(word.length() - 1);
                    word = word.substring(0, word.length() - 1);
                }

                if(trie.search(word)){
                    cWord = word;
                } else {
                    String wordBefore = "";
                    String wordAfter = "";
                    if(i == 1){
                        wordBefore = words[0] + " ";
                    } else if(i >= 2){
                        wordBefore = "... " + words[i-1] + " ";
                    }
                    if(i == words.length - 2){
                        wordAfter =" " + words[words.length - 1];
                    } else if(i <= words.length - 3){
                        wordAfter = " " + words[i+1] +  " ...";
                    }

                    System.out.println("Misspelling found : \"" + word + "\" in " + wordBefore + word + wordAfter);
                    cWord = correctWord(word);

                    System.out.println("Replaced \"" + wordBefore + word + wordAfter + "\" with \"" + wordBefore + cWord + wordAfter + "\"");
                }
                fixedSentence += prefix + cWord + postfix + " ";
            }
        }
        return fixedSentence;
    }

    public String correctWord(String word) {
        String newWord = "";
        System.out.println("Replace with : ");
        List<String> suggestions = trie.findSuggestion(word);
        for(int i = 0; i < suggestions.size(); i++){
            System.out.println("" + (i+1) + ". " + suggestions.get(i));
        }
        System.out.println("" + (suggestions.size() + 1) + ". Manual Entry");
        System.out.println("" + (suggestions.size() + 2) + ". Skip");
        System.out.println("Enter choice : ");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        if(suggestions.size() == 0){
            while(!choice.equals("1") && !choice.equals("2")){
                System.out.println("Invalid. Enter choice again : ");
                choice = in.nextLine();
            }
        }
       if(suggestions.size() == 1){
           while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){
               System.out.println("Invalid. Enter choice again : ");
               choice = in.nextLine();
           }
       }
        if(suggestions.size() == 2){
            while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")){
                System.out.println("Invalid. Enter choice again : ");
                choice = in.nextLine();
            }
        }
        if(suggestions.size() == 3){
            while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5")){
                System.out.println("Invalid. Enter choice again : ");
                choice = in.nextLine();
            }
        }
            //to do user input validation
        switch (choice) {
            case "1":
                if (suggestions.size() == 0) {    //no suggestions were found so first option becomes manual entry
                    newWord = manualCorrect(word);
                } else {
                    newWord = suggestions.get(0);
                }
                break;
            case "2":
                if (suggestions.size() == 0) {
                    newWord = word;
                } else if (suggestions.size() == 1) {
                    newWord = manualCorrect(word);
                } else {
                    newWord = suggestions.get(1);
                }
                break;
            case "3":
                if (suggestions.size() == 1) {
                    newWord = word;
                } else if (suggestions.size() == 2) {
                    newWord = manualCorrect(word);
                } else {
                    newWord = suggestions.get(2);
                }
                break;
            case "4":
                if (suggestions.size() == 2) {
                    newWord = word;
                } else if (suggestions.size() == 3) {
                    newWord = manualCorrect(word);
                }
                break;
            case "5":
                if (suggestions.size() == 3) {
                    newWord = word;
                }
                break;
            default:
                newWord = word;
        }

        return newWord;
    }

    private String manualCorrect(String word){
        String userWord = "";

        System.out.println("Manual entry for \"" + word + "\" : ");
        Scanner in = new Scanner(System.in);
        userWord = in.nextLine();

        return userWord;
    }


    @Override
    public void load() {
        System.out.println("Loading Dictionary...");
        try{
            BufferedReader br = new BufferedReader(new FileReader(DICTIONARY));
            for(String line = br.readLine(); line != null; line = br.readLine()){
                trie.insert(line);
//                System.out.println(line);
//                System.out.println(trie.search("a"));
            }
            System.out.println("Dictionary successfully loaded.");
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
