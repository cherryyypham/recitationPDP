package main;

public class AlphabeticSort {
	
	int numericValue;
	
	public int Sort(String word) {
		
		//Write a method for converting an element of a string
		//that can be sorted alphabetically into a binary
		//tree
		
		//Some strategies
		//You can take a numeric score of all the characters added
		//up since their hex values can be translated to
		//integers. Or, you can add your own custom values to each
		//character and use any parsing method you want
		//to determine the value. You could even just have
		//a switch case or a series of enums. Play around.
		//See what works.
		
		//Your biggest challenge is going to be making sure that
		//you don't have duplicate values. What happens
		//if an element or node has the same ID as another
		//existing one? How are you going to handle that?

        for (int i=0; i<word.length(); i++) {
            // Take ASCII value of character
            int currChar = (int) word.charAt(i);
            // Add the unique 2 digit representation of the letter
            // to the to-be final numeric sequence
            numericValue = numericValue * 100 + currChar;
        }
		
		return numericValue;
	}

}
