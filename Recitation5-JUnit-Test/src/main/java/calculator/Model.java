package calculator;

public class Model {

    double a;
    double b;
    String computation;
    double total;

    /**
     * Please write JUnit tests that verify the calculator.Model class initializes
     * with null values for each of its attributes, and then verify
     * that each method that sets a value does it correctly.
     *
     * You should also write tests for the "getter" methods.
     *
     * At least half of the setter and getter methods should be tested
     * to verify that "incorrect" results are handled appropriately.
     *
     * For example, if you set a value to 7, it should equal 7 and not 15.
     */
    public Model() {}

    public void setA(double a) { this.a = a; }
    public void setB(double b) { this.b = b; }
    public void setComputation(String comp) { this.computation = comp; }

    public double getA() { return this.a; }
    public double getB() { return this.b; }
    public String getComputation() { return this.computation; }

    /**
     * Please write a suite of JUnit tests for this method that:
     * 1. verify that the try/catch block for the Arithmetic Exception works
     * 2. verify that the try/catch block for the Null Pointer Exception works
     * 3. verifies that the output of each mathematical calculation is done correctly
     * @return the calculated result of two numbers and a chosen operation.
     */
    public double compute() {
        try {
            switch(computation) {
                case "+":
                    total = a+b;
                    break;
                case "-":
                    total = a-b;
                    break;
                case "*":
                    total = a*b;
                    break;
                case "/":
                    try {
                        total = a/b;
                        break;
                    } catch (ArithmeticException e) {
                        System.out.println("Error. Cannot divide by 0.");
                    }
            }
        } catch (NullPointerException e) {
            System.out.println("The computation could not be completed because one or more value is null");
        }
        return this.total;
    }

}