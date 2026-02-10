package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        if (calculator != null && calculator.in != null) {
            calculator.in.close();
        }
    }

    // Tests for constructor initialization
    @Test
    @DisplayName("Model object is not null after initialization")
    public void testModelNotNull() {
        assertNotNull(calculator.m, "Model should not be null after initialization");
    }

    @Test
    @DisplayName("View object is not null after initialization")
    public void testViewNotNull() {
        assertNotNull(calculator.v, "View should not be null after initialization");
    }

    @Test
    @DisplayName("Scanner object is not null after initialization")
    public void testScannerNotNull() {
        assertNotNull(calculator.in, "Scanner should not be null after initialization");
    }

    // Tests for initial values of instance variables
    @Test
    @DisplayName("numA initializes to 0.0")
    public void testNumAInitialValue() {
        assertEquals(0.0, calculator.numA, 0.0001);
    }

    @Test
    @DisplayName("numB initializes to 0.0")
    public void testNumBInitialValue() {
        assertEquals(0.0, calculator.numB, 0.0001);
    }

    @Test
    @DisplayName("total initializes to 0.0")
    public void testTotalInitialValue() {
        assertEquals(0.0, calculator.total, 0.0001);
    }

    @Test
    @DisplayName("comp initializes to null")
    public void testCompInitialValue() {
        assertNull(calculator.comp);
    }

    // Tests for run() method with mocked input for different operations
    @Test
    @DisplayName("run() method executes with addition operation")
    public void testRunWithAddition() {
        // Prepare input: 5.0 + 3.0
        String input = "5.0\n+\n3.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        // Verify the output contains expected result
        String output = outContent.toString();
        assertTrue(output.contains("sum"));
        assertTrue(output.contains("5.0"));
        assertTrue(output.contains("3.0"));
        assertTrue(output.contains("8.0"));
    }

    @Test
    @DisplayName("run() method executes with subtraction operation")
    public void testRunWithSubtraction() {
        String input = "10.0\n-\n4.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        assertTrue(output.contains("10.0"));
        assertTrue(output.contains("4.0"));
        assertTrue(output.contains("6.0"));
    }

    @Test
    @DisplayName("run() method executes with multiplication operation")
    public void testRunWithMultiplication() {
        String input = "6.0\n*\n7.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        assertTrue(output.contains("product"));
        assertTrue(output.contains("6.0"));
        assertTrue(output.contains("7.0"));
        assertTrue(output.contains("42.0"));
    }

    @Test
    @DisplayName("run() method executes with division operation")
    public void testRunWithDivision() {
        String input = "15.0\n/\n3.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        assertTrue(output.contains("quotient"));
        assertTrue(output.contains("15.0"));
        assertTrue(output.contains("3.0"));
        assertTrue(output.contains("5.0"));
    }

    @Test
    @DisplayName("run() method calls instructions()")
    public void testRunCallsInstructions() {
        String input = "1.0\n+\n1.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        assertTrue(output.contains("Please format your input"));
    }

    @Test
    @DisplayName("run() method sets numA correctly")
    public void testRunSetsNumA() {
        String input = "7.5\n+\n2.5\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        assertEquals(7.5, calculator.numA, 0.0001);
    }

    @Test
    @DisplayName("run() method sets numB correctly")
    public void testRunSetsNumB() {
        String input = "7.5\n+\n2.5\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        assertEquals(2.5, calculator.numB, 0.0001);
    }

    @Test
    @DisplayName("run() method sets comp correctly")
    public void testRunSetsComp() {
        String input = "7.5\n+\n2.5\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        assertEquals("+", calculator.comp);
    }

    @Test
    @DisplayName("run() method updates Model's values")
    public void testRunUpdatesModel() {
        String input = "3.0\n*\n4.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        assertEquals(3.0, calculator.m.getA(), 0.0001);
        assertEquals(4.0, calculator.m.getB(), 0.0001);
        assertEquals("*", calculator.m.getComputation());
    }

    @Test
    @DisplayName("run() method updates View's computation")
    public void testRunUpdatesView() {
        String input = "5.0\n+\n5.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        assertEquals("sum", calculator.v.getComputation());
    }

    @Test
    @DisplayName("run() method produces formatted output")
    public void testRunProducesFormattedOutput() {
        String input = "2.0\n*\n3.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        // Check that formattedOutput was called with correct pattern
        assertTrue(output.contains("The") && output.contains("of") &&
                output.contains("and") && output.contains("is"));
    }

    @Test
    @DisplayName("run() method handles negative numbers")
    public void testRunWithNegativeNumbers() {
        String input = "-5.0\n+\n-3.0\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        assertTrue(output.contains("-5.0"));
        assertTrue(output.contains("-3.0"));
        assertTrue(output.contains("-8.0"));
    }

    @Test
    @DisplayName("run() method handles decimal numbers")
    public void testRunWithDecimals() {
        String input = "7.5\n/\n2.5\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        calculator.in = new java.util.Scanner(inContent);

        calculator.run();

        String output = outContent.toString();
        assertTrue(output.contains("7.5"));
        assertTrue(output.contains("2.5"));
        assertTrue(output.contains("3.0"));
    }
}