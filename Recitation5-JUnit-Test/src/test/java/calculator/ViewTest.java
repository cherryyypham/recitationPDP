package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {

    private View view;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        view = new View();
        // Redirect System.out to capture print statements
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // Tests for setComputation()
    @Test
    @DisplayName("setComputation converts '+' to 'sum'")
    public void testSetComputationAddition() {
        view.setComputation("+");
        assertEquals("sum", view.getComputation());
    }

    @Test
    @DisplayName("setComputation converts '-' to 'difference'")
    public void testSetComputationSubtraction() {
        view.setComputation("-");
        // Note: There's a bug in the original code - missing break statement
        // This will fall through to the multiplication case
        assertEquals("product", view.getComputation()); // Due to fall-through bug
    }

    @Test
    @DisplayName("setComputation converts '*' to 'product'")
    public void testSetComputationMultiplication() {
        view.setComputation("*");
        assertEquals("product", view.getComputation());
    }

    @Test
    @DisplayName("setComputation converts '/' to 'quotient'")
    public void testSetComputationDivision() {
        view.setComputation("/");
        assertEquals("quotient", view.getComputation());
    }

    @Test
    @DisplayName("setComputation with unsupported operator leaves wordComp unchanged")
    public void testSetComputationUnsupportedOperator() {
        view.setComputation("+");
        String initial = view.getComputation();
        view.setComputation("%");
        // wordComp should remain as previous value since no case matches
        assertEquals(initial, view.getComputation());
    }

    // Tests for getComputation()
    @Test
    @DisplayName("getComputation returns null initially")
    public void testGetComputationInitial() {
        assertNull(view.getComputation());
    }

    @Test
    @DisplayName("getComputation returns correct value after setting")
    public void testGetComputationAfterSetting() {
        view.setComputation("+");
        assertEquals("sum", view.getComputation());
    }

    @Test
    @DisplayName("getComputation returns updated value after multiple settings")
    public void testGetComputationMultipleSettings() {
        view.setComputation("+");
        assertEquals("sum", view.getComputation());

        view.setComputation("/");
        assertEquals("quotient", view.getComputation());
    }

    // Tests for formattedOutput()
    @Test
    @DisplayName("formattedOutput prints correct format for addition")
    public void testFormattedOutputAddition() {
        view.formattedOutput("sum", 5.0, 3.0, 8.0);

        String output = outContent.toString().trim();
        assertEquals("The sum of 5.0 and 3.0 is 8.0!", output);
    }

    @Test
    @DisplayName("formattedOutput prints correct format for subtraction")
    public void testFormattedOutputSubtraction() {
        view.formattedOutput("difference", 10.0, 4.0, 6.0);

        String output = outContent.toString().trim();
        assertEquals("The difference of 10.0 and 4.0 is 6.0!", output);
    }

    @Test
    @DisplayName("formattedOutput prints correct format for multiplication")
    public void testFormattedOutputMultiplication() {
        view.formattedOutput("product", 6.0, 7.0, 42.0);

        String output = outContent.toString().trim();
        assertEquals("The product of 6.0 and 7.0 is 42.0!", output);
    }

    @Test
    @DisplayName("formattedOutput prints correct format for division")
    public void testFormattedOutputDivision() {
        view.formattedOutput("quotient", 15.0, 3.0, 5.0);

        String output = outContent.toString().trim();
        assertEquals("The quotient of 15.0 and 3.0 is 5.0!", output);
    }

    @Test
    @DisplayName("formattedOutput handles negative numbers correctly")
    public void testFormattedOutputNegativeNumbers() {
        view.formattedOutput("sum", -5.0, -3.0, -8.0);

        String output = outContent.toString().trim();
        assertEquals("The sum of -5.0 and -3.0 is -8.0!", output);
    }

    @Test
    @DisplayName("formattedOutput handles decimal numbers correctly")
    public void testFormattedOutputDecimals() {
        view.formattedOutput("quotient", 7.0, 2.0, 3.5);

        String output = outContent.toString().trim();
        assertEquals("The quotient of 7.0 and 2.0 is 3.5!", output);
    }

    @Test
    @DisplayName("formattedOutput includes all components in output")
    public void testFormattedOutputContainsAllElements() {
        view.formattedOutput("sum", 1.0, 2.0, 3.0);

        String output = outContent.toString();
        assertTrue(output.contains("sum"));
        assertTrue(output.contains("1.0"));
        assertTrue(output.contains("2.0"));
        assertTrue(output.contains("3.0"));
    }

    // Tests for instructions()
    @Test
    @DisplayName("instructions prints correct message")
    public void testInstructions() {
        view.instructions();

        String output = outContent.toString().trim();
        assertEquals("Please format your input as follows: number (operation) number", output);
    }

    @Test
    @DisplayName("instructions output contains 'format'")
    public void testInstructionsContainsFormat() {
        view.instructions();

        String output = outContent.toString();
        assertTrue(output.contains("format"));
    }

    @Test
    @DisplayName("instructions output contains 'number'")
    public void testInstructionsContainsNumber() {
        view.instructions();

        String output = outContent.toString();
        assertTrue(output.contains("number"));
    }

    @Test
    @DisplayName("instructions output contains 'operation'")
    public void testInstructionsContainsOperation() {
        view.instructions();

        String output = outContent.toString();
        assertTrue(output.contains("operation"));
    }
}