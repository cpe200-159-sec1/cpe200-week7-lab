package cpe200Test;

import cpe200.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryCalculatorTest {
    IOperand firstOperand;
    IOperand secondOperand;
    cpe200.BinaryCalculator BinaryCalculator;

    @Before
    public void setUp() throws Exception {
        BinaryCalculator = new BinaryCalculator();
    }

    @Test
    public void addStringSimple() throws Exception {
        firstOperand = new StringOperand("1");
        secondOperand = new StringOperand("1");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", BinaryCalculator.add());
    }

    @Test
    public void subtractStringSimple() throws Exception {
        firstOperand = new StringOperand("1");
        secondOperand = new StringOperand("1");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("0", BinaryCalculator.subtract());
    }

    @Test
    public void multiplyStringSimple() throws Exception {
        firstOperand = new StringOperand("10");
        secondOperand = new StringOperand("011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("110", BinaryCalculator.multiply());
    }

    @Test
    public void divideStringSimple() throws Exception {
        firstOperand = new StringOperand("0110");
        secondOperand = new StringOperand("011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", BinaryCalculator.division());
    }

    @Test
    public void divideByZeroStringSimple() throws Exception {
        firstOperand = new StringOperand("10");
        secondOperand = new StringOperand("0");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        try {
            BinaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerStringSimple() throws Exception {
        firstOperand = new StringOperand("10");
        secondOperand = new StringOperand("011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("1000", BinaryCalculator.power());
    }

    @Test
    public void addIntSimple() throws Exception {
        firstOperand = new IntegerOperand(1);
        secondOperand = new IntegerOperand(1);
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", BinaryCalculator.add());
    }

    @Test
    public void subtractIntSimple() throws Exception {
        firstOperand = new IntegerOperand(1);
        secondOperand = new IntegerOperand(1);
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("0", BinaryCalculator.subtract());
    }

    @Test
    public void multiplyIntSimple() throws Exception {
        firstOperand = new IntegerOperand(10);
        secondOperand = new IntegerOperand(11);
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("110", BinaryCalculator.multiply());
    }

    @Test
    public void divisionIntSimple() throws Exception {
        firstOperand = new IntegerOperand(110);
        secondOperand = new IntegerOperand(11);
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", BinaryCalculator.division());
    }

    @Test
    public void divideByZeroIntSimple() throws Exception {
        firstOperand = new IntegerOperand(110);
        secondOperand = new IntegerOperand(0);
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        try {
            BinaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerIntSimple() throws Exception {
        firstOperand = new IntegerOperand(10);
        secondOperand = new IntegerOperand(11);
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("1000", BinaryCalculator.power());
    }

    @Test
    public void addStringComplicated() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("110011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11101001", BinaryCalculator.add());
    }

    @Test
    public void subtractStringComplicated() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("110011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10000011", BinaryCalculator.subtract());
    }

    @Test
    public void multiplyStringComplicated() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("110011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010001000010", BinaryCalculator.multiply());
    }

    @Test
    public void divideStringComplicated() throws Exception {
        firstOperand = new StringOperand("1111110100");
        secondOperand = new StringOperand("100");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11111101", BinaryCalculator.division());
    }

    @Test
    public void divideByZeroStringComplicated() throws Exception {
        firstOperand = new StringOperand("11100110");
        secondOperand = new StringOperand("0000");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        try {
            BinaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerStringComplicated() throws Exception {
        firstOperand = new StringOperand("1100");
        secondOperand = new StringOperand("10");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010000", BinaryCalculator.power());
    }

    @Test
    public void addStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("00110011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11101001", BinaryCalculator.add());
    }

    @Test
    public void subtractStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("0110011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10000011", BinaryCalculator.subtract());
    }

    @Test
    public void multiplyStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("010110110");
        secondOperand = new StringOperand("000110011");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010001000010", BinaryCalculator.multiply());
    }

    @Test
    public void divideStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("1111110100");
        secondOperand = new StringOperand("000100");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11111101", BinaryCalculator.division());
    }

    @Test
    public void divideByZeroStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("0011100110");
        secondOperand = new StringOperand("0000");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        try {
            BinaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("001100");
        secondOperand = new StringOperand("10");
        BinaryCalculator.setFirstOperand(firstOperand);
        BinaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010000", BinaryCalculator.power());
    }
}