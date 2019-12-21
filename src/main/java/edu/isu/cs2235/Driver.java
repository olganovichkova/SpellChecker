package edu.isu.cs2235;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        SpellChecker spellchecker = new SpellChecker();
        spellchecker.load();

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        String userInput = "";
        String fixedInput = "";
        while(!userInput.equals("-1")) {
            System.out.println("Enter a sentence to spellcheck (-1 to quit) :  ");

            userInput = scanner.nextLine();  // Read user input
            if(!userInput.equals("-1")){
                fixedInput = spellchecker.spellCheck(userInput);
                System.out.println("Spelling Check Complete!");
                System.out.println("Results: " + fixedInput);  // Output user input
            }

        }
        System.out.println("You have quit the spellchecker.");
        System.out.println("Thank you!");


    }
}
