package main;

public class Controller {
	
	/**
	 * In the controller class, you should strive
	 * to make a simple program that allows someone
	 * to search for an element in a list using the 
	 * Scanner object to input an element and then iterate through
	 * a list.
	 */
	
	AlphabeticList listOfElements;
	
	/**
	 * In the main file, create a list holding at least 
	 * five elements that can be searched. Then construct the
	 * controller using that list.
	 * @param newList A list that ought to contain at least five
	 * elements.
	 */
	public Controller(AlphabeticList newList) {
		this.listOfElements = newList;
	}

}
