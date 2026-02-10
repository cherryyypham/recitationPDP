package main;

import java.util.Scanner;

public class Controller {
	
	/**
	 * In the controller class, you should strive
	 * to make a simple program that allows someone
	 * to search for an element in a list using the 
	 * Scanner object to input an element and then iterate through
	 * a list.
	 */
	
	AlphabeticList listOfElements;
    Scanner input;
	
	/**
	 * In the main file, create a list holding at least 
	 * five elements that can be searched. Then construct the
	 * controller using that list.
	 * @param newList A list that ought to contain at least five
	 * elements.
	 */
	public Controller(AlphabeticList newList) {
		this.listOfElements = newList;
        this.input = new Scanner(System.in);
	}

    public void runBinarySearch() {
        while (true) {
            System.out.print("Enter number to search: ");
            String userInput = input.nextLine().trim();

            if (input.equals("q")) {
                break;
            }

            Node result = listOfElements.search(input);
            if (result != null) {
                System.out.println("Found "
                        + result.getNodeElement().getName());
            } else {
                System.out.println("Input Not Found :(");
            }
        }
    }
}
