package cpe200Test;

import cpe200.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class binaryCalculatorTest {
    IOperand firstOperand;
    IOperand secondOperand;
    cpe200.binaryCalculator binaryCalculator;

    @Before
    public void setUp() throws Exception {
        binaryCalculator = new binaryCalculator();
    }

    @Test
    public void addStringSimple() throws Exception {
        firstOperand = new StringOperand("1");
        secondOperand = new StringOperand("1");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", binaryCalculator.add());
    }

    @Test
    public void subtractStringSimple() throws Exception {
        firstOperand = new StringOperand("1");
        secondOperand = new StringOperand("1");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("0", binaryCalculator.subtract());
    }

    @Test
    public void multiplyStringSimple() throws Exception {
        firstOperand = new StringOperand("10");
        secondOperand = new StringOperand("011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("110", binaryCalculator.multiply());
    }

    @Test
    public void divideStringSimple() throws Exception {
        firstOperand = new StringOperand("0110");
        secondOperand = new StringOperand("011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", binaryCalculator.division());
    }

    @Test
    public void divideByZeroStringSimple() throws Exception {
        firstOperand = new StringOperand("10");
        secondOperand = new StringOperand("0");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        try {
            binaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerStringSimple() throws Exception {
        firstOperand = new StringOperand("10");
        secondOperand = new StringOperand("011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("1000", binaryCalculator.power());
    }

    @Test
    public void addIntSimple() throws Exception {
        firstOperand = new IntegerOperand(1);
        secondOperand = new IntegerOperand(1);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", binaryCalculator.add());
    }

    @Test
    public void subtractIntSimple() throws Exception {
        firstOperand = new IntegerOperand(1);
        secondOperand = new IntegerOperand(1);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("0", binaryCalculator.subtract());
    }

    @Test
    public void multiplyIntSimple() throws Exception {
        firstOperand = new IntegerOperand(10);
        secondOperand = new IntegerOperand(11);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("110", binaryCalculator.multiply());
    }

    @Test
    public void divisionIntSimple() throws Exception {
        firstOperand = new IntegerOperand(110);
        secondOperand = new IntegerOperand(11);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10", binaryCalculator.division());
    }

    @Test
    public void divideByZeroIntSimple() throws Exception {
        firstOperand = new IntegerOperand(110);
        secondOperand = new IntegerOperand(0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        try {
            binaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerIntSimple() throws Exception {
        firstOperand = new IntegerOperand(10);
        secondOperand = new IntegerOperand(11);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("1000", binaryCalculator.power());
    }

    @Test
    public void addStringComplicated() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("110011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11101001", binaryCalculator.add());
    }

    @Test
    public void subtractStringComplicated() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("110011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10000011", binaryCalculator.subtract());
    }

    @Test
    public void multiplyStringComplicated() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("110011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010001000010", binaryCalculator.multiply());
    }

    @Test
    public void divideStringComplicated() throws Exception {
        firstOperand = new StringOperand("1111110100");
        secondOperand = new StringOperand("100");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11111101", binaryCalculator.division());
    }

    @Test
    public void divideByZeroStringComplicated() throws Exception {
        firstOperand = new StringOperand("11100110");
        secondOperand = new StringOperand("0000");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        try {
            binaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerStringComplicated() throws Exception {
        firstOperand = new StringOperand("1100");
        secondOperand = new StringOperand("10");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010000", binaryCalculator.power());
    }

    @Test
    public void addStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("00110011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11101001", binaryCalculator.add());
    }

    @Test
    public void subtractStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("10110110");
        secondOperand = new StringOperand("0110011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10000011", binaryCalculator.subtract());
    }

    @Test
    public void multiplyStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("010110110");
        secondOperand = new StringOperand("000110011");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010001000010", binaryCalculator.multiply());
    }

    @Test
    public void divideStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("1111110100");
        secondOperand = new StringOperand("000100");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("11111101", binaryCalculator.division());
    }

    @Test
    public void divideByZeroStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("0011100110");
        secondOperand = new StringOperand("0000");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        try {
            binaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (ArithmeticException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void powerStringZeroPadding() throws Exception {
        firstOperand = new StringOperand("001100");
        secondOperand = new StringOperand("10");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("10010000", binaryCalculator.power());
    }
}