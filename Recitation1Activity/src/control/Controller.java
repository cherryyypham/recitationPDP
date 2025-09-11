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
	String next;
	
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		userInput = new Scanner(System.in);
	}
	
	//For notes on using Scanner for inputs, see:
	//https://www.w3schools.com/java/java_user_input.asp
	public void run() {
		
		//The view class is called to display the first message.
		view.init();
		
		//We initialize our program loop as well as an end condition.
		next = userInput.nextLine();
		while (!next.equals("Q")){
			
			//All of these print statements are technically part of the
			//program's 'view' system. So how should we re-design
			//this program loop to work with the View class?
			System.out.println(next);
			
			System.out.println("next entry: ");
			next = userInput.nextLine();
		
		}
		//This statement prints when the program terminates.
		//It should probably be handed by the View class.
		System.out.println("goodbye");
	}
	
}
