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


    }


    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;

    }


    public String add() throws RuntimeException {


    }

    public String subtract() throws RuntimeException {

    }

    public String multiply() throws RuntimeException {


    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
    }

    public String power() throws RuntimeException {
    }

    private BigDecimal BinaryStringToBigDecimal(String bin) {
        Double decimal = new Double(0);
        int dot = findDot(bin);

        if (dot == -1) {
            int power = 0;
            for (int i = bin.length(); i >= 0; i--) {
                if (bin.charAt(i) == '1') decimal += Math.pow(2, power);
                power++;
            }
        } else {
            int power = 0;
            for (int i = dot - 1; i >= 0; i--) {
                if (bin.charAt(i) == '1') decimal += Math.pow(2, power);
                power++;
            }
            power = -1;
            for (int i = dot + 1; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') decimal += Math.pow(2, power);
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
    }
}

