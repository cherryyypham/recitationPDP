package view;

public class View {
	public void init() {
		System.out.println("Welcome to Recitation 1: Build a console calculator!");
	}
	
	//Right now, the view class has one method that prints a welcome message
	//when the program starts up.
	//Is there a better way to organize the data that the View class will need
	//to access (as in, all those print statements in the Controller class
	//so that we don't need to write a unique method for every 
	//possible scenario?
	//How do we design this to be more modular?
	public void calculatorInterface() {
        System.out.print("Please enter your equation: ");
    }

    public void displayError(String error) {
        System.out.println(error);
    }

    public void displayResult(double result) {
        System.out.println("The result is: " + result + "!");
    }

    public void terminate() {
        System.out.println("Calculation terminated!");
    }
}
