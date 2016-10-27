package cpe200;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.math.BigDecimal;

/**
 * Created by qowie on 10/25/2016.
 */
public class BinaryCalculator {

    private IOperand firstOperand;
    private IOperand secondOperand;

    public BinaryCalculator() {

        firstOperand = null;
        secondOperand = null;
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = operand;
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        checkException(first,new BigDecimal(0));



    }


    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());
        checkException(second,new BigDecimal(0));

    }


    public String add() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());

        BigDecimal out = first.add(second);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());





    }

    public String subtract() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());

        BigDecimal out = first.subtract(second);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());
    }

    public String multiply() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());

        BigDecimal out = first.multiply(second);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());

    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());
        checkException(first,second);
        if (second.intValue() == 0){
            throw new ArithmeticException();
        }

        BigDecimal out = first.divide(second,5,5);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());

    }

    public String power() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());
        BigDecimal out = first.pow(second.intValue());
        return Long.toBinaryString(out.stripTrailingZeros().longValue());

    }

    private BigDecimal BinaryStringToBigDecimal(String bin) {
        Long decimal = new Long(0);
        int dot = findDot(bin);


        if (dot == -1) {
            int power = 0;
            for (int i = bin.length(); i >= 0; i--) {
                if (bin.charAt(i) == '1') decimal += (long)Math.pow(2, power);
                power++;
            }
            BigDecimal out = new BigDecimal(decimal.toString());
            return out;
        } else {
            int power = 0;
            for (int i = dot - 1; i >= 0; i--) {
                if (bin.charAt(i) == '1') decimal += (long)Math.pow(2, power);
                power++;
            }
            power = -1;
            for (int i = dot + 1; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') decimal += (long)Math.pow(2, power);
                power--;
            }
            BigDecimal out = new BigDecimal(decimal.toString());
            return out;
        }


    }

    private int findDot(String bin) {
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '.') {
                return i;
            }
        }
        return -1;
    }

    public void checkException(BigDecimal first, BigDecimal second) {
        if (first.intValue() < 0 || second.intValue() < 0) {
            throw new RuntimeException();
        }
    }
}

