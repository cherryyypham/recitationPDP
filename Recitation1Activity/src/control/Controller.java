package control;

//This package allows us to read an input from the
//command line. You will have to generate an object of it
//to take that input.
import java.util.Scanner;

//Because our controller is managing our two other
//classes, then it ought to have access to their
//package contents.
import model.*;
import view.*;

public class Controller {
	
	//Declare the class attributes.
	//Scanner is the object that we will store
	//user input to and pass appropriate commands
	//to other objects depending on that input.
	Scanner userInput;
	
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		userInput = new Scanner(System.in);
	}

    public String eqInputValidation (Scanner userInput) {
        while (true) {
            view.calculatorInterface();
            String input = userInput.nextLine().trim();
            if (input.equalsIgnoreCase("Q")) {
                view.terminate();
                break;
            } else if (!input.matches(".*[+\\-*/].*")) {
                view.displayError("Equation must contain an operator.");
                continue;
            } if (!input.isEmpty() && (!Character.isDigit(input.charAt(0)) && (input.charAt(0) != '-'))) {
                view.displayError("Equation must start with a valid number or an '-'.");
                continue;
            } if (!Character.isDigit(input.charAt(input.length() - 1))) {
                view.displayError("Equation must end with a valid number.");
            } if (input.matches(".*[+\\-/]{2,}.*")) {
                view.displayError("Invalid equation.");
            }
            return input;
        }
        return null;
    }
	
	//For notes on using Scanner for inputs, see:
	//https://www.w3schools.com/java/java_user_input.asp
	public void run() {
		// The view class is called to display the first message.
		view.init();

        // Calculator program loop
        while (true) {
            String input = eqInputValidation(userInput);
            double result = model.processEquation(input);
            view.displayResult(result);
        }
	}
	
}
