package calculator;

import java.util.Scanner;

public class Calculator {

    Model m;
    View v;
    Scanner in;

    double numA;
    double numB;
    double total;
    String comp;

    /**
     * Please write a series of tests that verify each of the objects
     * initialized inside the calculator.Calculator() constructor do not
     * initialize as null.
     */

    public Calculator() {
        m = new Model();
        v = new View();
        in = new Scanner(System.in);
    }

    /**
     * This method is difficult to test.
     *
     * You will need to have separate tests for each of the components, and then
     * write a test that stages the required information
     * and runs the test version of the method. The resulting
     * output of this method doesn't actually return anything
     * but it should activate all the lines of code inside it.
     */
    public void run() {
        v.instructions();

        numA = in.nextDouble();
        m.setA(numA);

        comp = in.next();
        m.setComputation(comp);
        v.setComputation(comp);

        numB = in.nextDouble();
        m.setB(numB);

        v.formattedOutput(v.getComputation(), m.getA(), m.getB(), m.compute());
    }

}