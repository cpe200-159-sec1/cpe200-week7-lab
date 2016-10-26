package cpe200Test;

import cpe200.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;


public class BinaryCalculatorTest {
    IOperand firstOperand;
    IOperand secondOperand;
    BinaryCalculator binaryCalculator;

    @Before
    public void setUp() throws Exception {
        binaryCalculator = new BinaryCalculator();
    }

    @Test
    public void addStringSimple() throws Exception {
        firstOperand = new StringOperand("1");
        secondOperand = new StringOperand("1");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("2", binaryCalculator.add());
    }

    @Test
    public void addStringSimpleException() throws Exception {
        try {
            firstOperand = new StringOperand("-1");
            secondOperand = new StringOperand("1");
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }
        try {
            binaryCalculator.add();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
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
    public void subtractStringSimpleException() throws Exception {
        try {
            firstOperand = new StringOperand("-1");
            secondOperand = new StringOperand("1");
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }
        try {
            binaryCalculator.subtract();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void multiplyStringSimple() throws Exception {
        firstOperand = new StringOperand("2");
        secondOperand = new StringOperand("3");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("6", binaryCalculator.multiply());
    }

    @Test
    public void multiplyStringSimpleException() throws Exception {
        try {
            firstOperand = new StringOperand("-1");
            secondOperand = new StringOperand("1");
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }
        try {
            binaryCalculator.multiply();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divideStringSimple() throws Exception {
        firstOperand = new StringOperand("6");
        secondOperand = new StringOperand("3");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("2", binaryCalculator.division());
    }

    @Test
    public void divideStringSimpleException() throws Exception {
        try {
            firstOperand = new StringOperand("-1");
            secondOperand = new StringOperand("1");
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }
        try {
            assertEquals("-1", binaryCalculator.division());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divideByZeroStringSimple() throws Exception {
        firstOperand = new StringOperand("2");
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
    public void divideByZeroStringSimpleException() throws Exception {
        try {
            firstOperand = new StringOperand("-1");
            secondOperand = new StringOperand("0");
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }
        try {
            binaryCalculator.division();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void powerStringSimple() throws Exception {
        firstOperand = new StringOperand("2");
        secondOperand = new StringOperand("3");
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("8", binaryCalculator.power());
    }

    @Test
    public void powerStringSimpleException() throws Exception {
        try {
            firstOperand = new StringOperand("-2");
            secondOperand = new StringOperand("3");
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }
        try {
            binaryCalculator.power();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void addIntSimple() throws Exception {
        firstOperand = new IntegerOperand(1);
        secondOperand = new IntegerOperand(1);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("2", binaryCalculator.add());
    }

    @Test
    public void addIntSimpleException() throws Exception {
        try {
            firstOperand = new IntegerOperand(-1);
            secondOperand = new IntegerOperand(1);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            assertEquals("0", binaryCalculator.add());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
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
    public void subtractIntSimpleException() throws Exception {
        try {
            firstOperand = new IntegerOperand(-1);
            secondOperand = new IntegerOperand(1);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            assertEquals("-2", binaryCalculator.subtract());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void multiplyIntSimple() throws Exception {
        firstOperand = new IntegerOperand(2);
        secondOperand = new IntegerOperand(3);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("6", binaryCalculator.multiply());
    }

    @Test
    public void multiplyIntSimpleException() throws Exception {
        try {
            firstOperand = new IntegerOperand(-1);
            secondOperand = new IntegerOperand(1);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            assertEquals("-1", binaryCalculator.multiply());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divisionIntSimple() throws Exception {
        firstOperand = new IntegerOperand(6);
        secondOperand = new IntegerOperand(3);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("2", binaryCalculator.division());
    }

    @Test
    public void divisionIntSimpleException() throws Exception {
        try {
            firstOperand = new IntegerOperand(-1);
            secondOperand = new IntegerOperand(1);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            assertEquals("-1", binaryCalculator.division());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divideByZeroIntSimple() throws Exception {
        firstOperand = new IntegerOperand(6);
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
    public void divideByZeroIntSimpleException() throws Exception {
        try {
            firstOperand = new IntegerOperand(-1);
            secondOperand = new IntegerOperand(0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            binaryCalculator.division();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void powerIntSimple() throws Exception {
        firstOperand = new IntegerOperand(2);
        secondOperand = new IntegerOperand(3);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("8", binaryCalculator.power());
    }

    @Test
    public void powerIntSimpleException() throws Exception {
        try {
            firstOperand = new IntegerOperand(-2);
            secondOperand = new IntegerOperand(3);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            assertEquals("-8", binaryCalculator.power());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void addDoubleSimple() throws Exception {
        firstOperand = new DoubleOperand(3.0);
        secondOperand = new DoubleOperand(1.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("4", binaryCalculator.add());
    }

    @Test
    public void addDoubleSimpleException() throws Exception {
        try {
            firstOperand = new DoubleOperand(-1.0);
            secondOperand = new DoubleOperand(1.0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            assertEquals("0", binaryCalculator.add());
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void subtractDoubleSimple() throws Exception {
        firstOperand = new DoubleOperand(3.0);
        secondOperand = new DoubleOperand(2.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("1", binaryCalculator.subtract());
    }

    @Test
    public void subtractDoubleSimpleException() throws Exception {
        try {
            firstOperand = new DoubleOperand(-1.0);
            secondOperand = new DoubleOperand(1.0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            binaryCalculator.subtract();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void multiplyDoubleSimple() throws Exception {
        firstOperand = new DoubleOperand(3.0);
        secondOperand = new DoubleOperand(2.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("6", binaryCalculator.multiply());
    }

    @Test
    public void multiplyDoubleSimpleException() throws Exception {
        try {
            firstOperand = new DoubleOperand(-1.0);
            secondOperand = new DoubleOperand(1.0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            binaryCalculator.multiply();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divisionDoubleSimple() throws Exception {
        firstOperand = new DoubleOperand(6.0);
        secondOperand = new DoubleOperand(3.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("2", binaryCalculator.division());
    }

    @Test
    public void divisionDoubleSimpleException() throws Exception {
        try {
            firstOperand = new DoubleOperand(-1.0);
            secondOperand = new DoubleOperand(1.0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            binaryCalculator.division();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divideByZeroDoubleSimple() throws Exception {
        firstOperand = new DoubleOperand(6.0);
        secondOperand = new DoubleOperand(0.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        try {
            binaryCalculator.division();
            fail("The operation must raise an exception");
        } catch (Exception ex) {
            assertTrue(true);
        }
    }

    @Test
    public void divideByZeroDoubleSimpleException() throws Exception {
        try {
            firstOperand = new DoubleOperand(-1.0);
            secondOperand = new DoubleOperand(0.0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            binaryCalculator.division();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void powerDoubleSimple() throws Exception {
        firstOperand = new DoubleOperand(3.0);
        secondOperand = new DoubleOperand(2.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("9", binaryCalculator.power());
    }

    @Test
    public void powerDoubleSimpleException() throws Exception {
        try {
            firstOperand = new DoubleOperand(-2.0);
            secondOperand = new DoubleOperand(3.0);
            binaryCalculator.setFirstOperand(firstOperand);
            binaryCalculator.setSecondOperand(secondOperand);
        } catch (Exception ex) {
            fail("Not expect exception here");
        }

        try {
            binaryCalculator.power();
            fail("Expect an exception to be thrown before here");
        } catch (RuntimeException ex) {
            assertTrue(true);
        } catch (Exception ex) {
            fail("Expect runtime exception, but the other is thrown");
        }
    }

    @Test
    public void divisionDoubleWithRemainder() throws Exception {
        firstOperand = new DoubleOperand(5.0);
        secondOperand = new DoubleOperand(3.0);
        binaryCalculator.setFirstOperand(firstOperand);
        binaryCalculator.setSecondOperand(secondOperand);
        assertEquals("1.66667", binaryCalculator.division());
    }

    @Test
    public void operandDirectAccess() throws Exception {
        Field field = DoubleOperand.class.getDeclaredField("operand");
        assertFalse(Modifier.isPublic(field.getModifiers()));

        field = BinaryCalculator.class.getDeclaredField("firstOperand");
        assertFalse(Modifier.isPublic(field.getModifiers()));

        field = BinaryCalculator.class.getDeclaredField("secondOperand");
        assertFalse(Modifier.isPublic(field.getModifiers()));
    }


}
