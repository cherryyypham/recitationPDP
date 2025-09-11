package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	//you're building a calculator for this
	//recitation, so you need to be able to
	//store two numbers and the computation
	//that those numbers will perform (+, -, /, *)

	//you also need a constructor for your model.
	//there is an example constructor in the controller
	//class. If your model does not need any parameters
	//when it is generated, then you do not need to write
	//a constructor, and it will automatically generate
	//a default constructor.
	
	//finally, you need to write your setters, getters,
	//and operations--the methods that will perform the
	//desired computations.
    public List<String> tokenize(String eq) {
        // Handle cases when spaces are not added diligently
        // This might be unnecessarily long, but I'm in too deep
        List<String> tokens =  new ArrayList<String>();
        StringBuilder number = new StringBuilder();
        
        for (int i = 0; i < eq.length(); i++) {
            char c = eq.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                number.append(c);
            } else if ("+-*/".indexOf(c) != -1) {
                // Flush longer number into array list once reached an operator
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                } if (c == '-') {
                    number.append(c);
                } else {
                    tokens.add(String.valueOf(c));
                }
            } else if (Character.isWhitespace(c)) {
                continue;
            } else {
                // Handle NaNs and non-operator cases
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
        if (number.length() > 0) {
            // Trailing longer number without an operator signal to flush
            tokens.add(number.toString());
        }
        return tokens;
    }

    public List<String> negativeSeparator(List<String> tokens) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            String s = tokens.get(i);
            if (s.startsWith("-") && i != 0) {
                result.add("-");
                result.add(s.substring(1));
            } else {
                result.add(s);
            }
        }
        return result;
    }

    public double opProcessor(String op, double a, double b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0.0) throw new ArithmeticException("Division by 0");
                return a / b;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + op);
        }
    }

    public double processEquation(String eq) {
        List<String> tokens = tokenize(eq);
        // Perform multiplication and division first
        for (int i = 0; i < tokens.size(); i++) {
            String op = tokens.get(i);
            if (op.equals("*") || op.equals("/")) {
                double a = Double.parseDouble(tokens.get(i - 1));
                double b = Double.parseDouble(tokens.get(i + 1));

                // Replace leftmost position with result and get rid of extras
                tokens.set(i - 1, String.valueOf(opProcessor(op, a, b)));
                tokens.remove(i);
                tokens.remove(i);
                i--; // Reset position
            }
        }

        // Perform addition and subtraction from left to right
        double res = Double.parseDouble(tokens.get(0));
        List<String> newTokens = negativeSeparator(tokens);
        for (int i = 1; i < newTokens.size(); i+=2) {
            String op = newTokens.get(i);
            double num = Double.parseDouble(newTokens.get(i+1));
            res = opProcessor(op, res, num);
        }
        return res;
    }
}
