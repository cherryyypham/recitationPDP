package calculator;

public class View {

    String wordComp;

    /**
     * Write a test that verifies the appropriate parameter
     * is returned based on a given input.
     *
     * @param in The computation that the user inputs to compute a value between numbers
     */
    public void setComputation(String in) {
        switch(in) {
            case "+":
                wordComp = "sum";
                break;
            case "-":
                wordComp = "difference";
            case "*":
                wordComp = "product";
                break;
            case "/":
                wordComp = "quotient";
                break;
        }
    }

    /**
     * Write tests that will verify "getComputation" works correctly
     * @return the value currently stored inside the attribute wordComp
     */
    public String getComputation() { return this.wordComp; }


    /**
     * Writing tests for void methods are difficult. Think about how you
     * might test what the method println is doing and if there is a way to
     * test what it does.
     * @param result
     * @param a
     * @param b
     * @param total
     */
    public void formattedOutput(String result, double a, double b, double total) {
        System.out.println("The " + result + " of " + a + " and " + b + " is " + total + "!");
    }

    public void instructions() {
        System.out.println("Please format your input as follows: "
                + "number (operation) number");
    }

}