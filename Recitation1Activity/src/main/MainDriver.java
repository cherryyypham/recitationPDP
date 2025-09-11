/**
 * Your task for Recitation 1 is to develop an MVC calculator
 * that can add, subtract, multiply, and divide two numbers.
 * 
 * By the end of recitation, please turn in what you have managed to write
 * so far. It does not need to be complete, but should include your name
 * in a comment and perhaps some comments describing your strategy
 * for approaching this task.
 * 
 * Below is a default set-up for running the program. It does not
 * work as intended. You will need to make additions and alterations.
 **/
package main;

import model.*;
import control.*;
import view.*;

public class MainDriver {
	
	public static void main(String[] args) {
		
		Model model = new Model();
		View view = new View();
		Controller control = new Controller(model, view);
		
		control.run();
		
	}
	
}
