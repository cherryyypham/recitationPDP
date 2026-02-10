package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    private Model model;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        model = new Model();
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // Tests for initial values
    @Test
    @DisplayName("Model initializes with default double value (0.0) for 'a'")
    public void testInitialValueA() {
        assertEquals(0.0, model.getA(), 0.0001);
    }

    @Test
    @DisplayName("Model initializes with default double value (0.0) for 'b'")
    public void testInitialValueB() {
        assertEquals(0.0, model.getB(), 0.0001);
    }

    @Test
    @DisplayName("Model initializes with null for computation string")
    public void testInitialValueComputation() {
        assertNull(model.getComputation());
    }

    @Test
    @DisplayName("Model initializes with default double value (0.0) for total")
    public void testInitialValueTotal() {
        assertEquals(0.0, model.total, 0.0001);
    }

    // Tests for setters - correct values
    @Test
    @DisplayName("setA correctly sets positive value")
    public void testSetAPositive() {
        model.setA(7.5);
        assertEquals(7.5, model.getA(), 0.0001);
    }

    @Test
    @DisplayName("setA correctly sets negative value")
    public void testSetANegative() {
        model.setA(-3.2);
        assertEquals(-3.2, model.getA(), 0.0001);
    }

    @Test
    @DisplayName("setB correctly sets positive value")
    public void testSetBPositive() {
        model.setB(10.0);
        assertEquals(10.0, model.getB(), 0.0001);
    }

    @Test
    @DisplayName("setB correctly sets negative value")
    public void testSetBNegative() {
        model.setB(-5.5);
        assertEquals(-5.5, model.getB(), 0.0001);
    }

    @Test
    @DisplayName("setComputation correctly sets addition operator")
    public void testSetComputationAddition() {
        model.setComputation("+");
        assertEquals("+", model.getComputation());
    }

    @Test
    @DisplayName("setComputation correctly sets subtraction operator")
    public void testSetComputationSubtraction() {
        model.setComputation("-");
        assertEquals("-", model.getComputation());
    }

    // Tests for incorrect values (verify value is what it should be, not something else)
    @Test
    @DisplayName("setA with value 7 should equal 7, not 15")
    public void testSetANotIncorrectValue() {
        model.setA(7.0);
        assertNotEquals(15.0, model.getA());
        assertEquals(7.0, model.getA(), 0.0001);
    }

    @Test
    @DisplayName("setB with value 3 should equal 3, not 8")
    public void testSetBNotIncorrectValue() {
        model.setB(3.0);
        assertNotEquals(8.0, model.getB());
        assertEquals(3.0, model.getB(), 0.0001);
    }

    @Test
    @DisplayName("setComputation with '+' should equal '+', not '-'")
    public void testSetComputationNotIncorrectValue() {
        model.setComputation("+");
        assertNotEquals("-", model.getComputation());
        assertEquals("+", model.getComputation());
    }

    // Tests for getters
    @Test
    @DisplayName("getA returns the correct value after setting")
    public void testGetA() {
        model.setA(42.0);
        assertEquals(42.0, model.getA(), 0.0001);
    }

    @Test
    @DisplayName("getB returns the correct value after setting")
    public void testGetB() {
        model.setB(18.5);
        assertEquals(18.5, model.getB(), 0.0001);
    }

    @Test
    @DisplayName("getComputation returns the correct operator after setting")
    public void testGetComputation() {
        model.setComputation("*");
        assertEquals("*", model.getComputation());
    }

    // Tests for compute() method - Addition
    @Test
    @DisplayName("compute() correctly calculates addition")
    public void testComputeAddition() {
        model.setA(5.0);
        model.setB(3.0);
        model.setComputation("+");
        assertEquals(8.0, model.compute(), 0.0001);
    }

    @Test
    @DisplayName("compute() correctly calculates addition with negative numbers")
    public void testComputeAdditionNegative() {
        model.setA(-5.0);
        model.setB(-3.0);
        model.setComputation("+");
        assertEquals(-8.0, model.compute(), 0.0001);
    }

    // Tests for compute() method - Subtraction
    @Test
    @DisplayName("compute() correctly calculates subtraction")
    public void testComputeSubtraction() {
        model.setA(10.0);
        model.setB(4.0);
        model.setComputation("-");
        assertEquals(6.0, model.compute(), 0.0001);
    }

    @Test
    @DisplayName("compute() correctly calculates subtraction with negative result")
    public void testComputeSubtractionNegativeResult() {
        model.setA(3.0);
        model.setB(7.0);
        model.setComputation("-");
        assertEquals(-4.0, model.compute(), 0.0001);
    }

    // Tests for compute() method - Multiplication
    @Test
    @DisplayName("compute() correctly calculates multiplication")
    public void testComputeMultiplication() {
        model.setA(6.0);
        model.setB(7.0);
        model.setComputation("*");
        assertEquals(42.0, model.compute(), 0.0001);
    }

    @Test
    @DisplayName("compute() correctly calculates multiplication with zero")
    public void testComputeMultiplicationByZero() {
        model.setA(5.0);
        model.setB(0.0);
        model.setComputation("*");
        assertEquals(0.0, model.compute(), 0.0001);
    }

    // Tests for compute() method - Division
    @Test
    @DisplayName("compute() correctly calculates division")
    public void testComputeDivision() {
        model.setA(15.0);
        model.setB(3.0);
        model.setComputation("/");
        assertEquals(5.0, model.compute(), 0.0001);
    }

    @Test
    @DisplayName("compute() correctly calculates division with decimal result")
    public void testComputeDivisionDecimal() {
        model.setA(7.0);
        model.setB(2.0);
        model.setComputation("/");
        assertEquals(3.5, model.compute(), 0.0001);
    }

    // Test for ArithmeticException (division by zero)
    @Test
    @DisplayName("compute() handles division by zero (ArithmeticException scenario)")
    public void testComputeDivisionByZero() {
        model.setA(10.0);
        model.setB(0.0);
        model.setComputation("/");

        // Note: In Java, division by zero with doubles returns Infinity, not ArithmeticException
        // The catch block in the code won't actually be triggered, but we test the behavior
        double result = model.compute();
        assertTrue(Double.isInfinite(result) || result == 0.0);
    }

    // Test for NullPointerException
    @Test
    @DisplayName("compute() handles null computation (NullPointerException)")
    public void testComputeNullComputation() {
        model.setA(5.0);
        model.setB(3.0);
        // computation is null by default

        model.compute();

        String output = outContent.toString();
        assertTrue(output.contains("The computation could not be completed because one or more value is null"));
    }

    @Test
    @DisplayName("compute() with null computation returns 0.0")
    public void testComputeNullComputationReturnsZero() {
        model.setA(5.0);
        model.setB(3.0);
        // computation is null

        double result = model.compute();
        assertEquals(0.0, result, 0.0001);
    }

    // Edge case tests
    @Test
    @DisplayName("compute() with very large numbers")
    public void testComputeLargeNumbers() {
        model.setA(1000000.0);
        model.setB(2000000.0);
        model.setComputation("+");
        assertEquals(3000000.0, model.compute(), 0.0001);
    }

    @Test
    @DisplayName("compute() with very small decimal numbers")
    public void testComputeSmallDecimals() {
        model.setA(0.0001);
        model.setB(0.0002);
        model.setComputation("+");
        assertEquals(0.0003, model.compute(), 0.00001);
    }
}