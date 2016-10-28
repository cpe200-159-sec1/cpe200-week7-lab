package cpe200;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.math.BigDecimal;

/**
 * Created by qowie on 10/25/2016.
 */
public class BinaryCalculator extends BaseCalculator {

    private IOperand firstOperand;
    private IOperand secondOperand;

    @Override
    public void setFirstOperand(IOperand operand) {
        checkBinary(operand.getOperand());
        firstOperand = operand;


    }

    @Override
    public void setSecondOperand(IOperand operand) {
        checkBinary(operand.getOperand());
        secondOperand = operand;


    }

    @Override
    public String add() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());

        BigDecimal out = first.add(second);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());


    }
    @Override
    public String subtract() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());

        BigDecimal out = first.subtract(second);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());
    }
    @Override
    public String multiply() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());

        BigDecimal out = first.multiply(second);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());

    }
    @Override
    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());
        checkException(first, second);
        if (second.intValue() == 0) {
            throw new ArithmeticException();
        }

        BigDecimal out = first.divide(second, 5, 5);
        return Long.toBinaryString(out.stripTrailingZeros().longValue());

    }
    @Override
    public String power() throws RuntimeException {
        BigDecimal first = BinaryStringToBigDecimal(firstOperand.getOperand());
        BigDecimal second = BinaryStringToBigDecimal(secondOperand.getOperand());
        BigDecimal out = first.pow(second.intValue());
        return Long.toBinaryString(out.stripTrailingZeros().longValue());

    }

    private BigDecimal BinaryStringToBigDecimal(String bin) {
        BigDecimal out = new BigDecimal(Long.parseLong(bin, 2));
        return out;


    }


    private void checkBinary(String bin) {
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != '1') {
                if (bin.charAt(i) != '0')
                    throw new ArithmeticException();
            }
        }

    }
}

