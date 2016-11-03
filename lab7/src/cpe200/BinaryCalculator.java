package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Khimmy on 11/2/2016.
 */
public class BinaryCalculator {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public BinaryCalculator() {
        firstOperand = new BigDecimal(0);
        secondOperand = new BigDecimal(0);
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = BinToDec(operand.getOperand(), firstOperand);
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = BinToDec(operand.getOperand(), secondOperand);
    }

    private BigDecimal BinToDec(String k, BigDecimal x) {
        int power = -1;
        for (int i = k.length() - 1; i >= 0; i--) {
            power++;
            if (k.charAt(i) == '0')
                continue;
            else if (k.charAt(i) == '1')
                x = x.add(new BigDecimal(Double.toString(Math.pow(2, power))));
            else
                throw new ArithmeticException("Error");
        }
        return x;
    }

    private String DecToBin(int x) {
        String ans = "";

        while (x != 0) {
            ans = Integer.toString(x % 2) + ans;
            x /= 2;
        }
        if (ans == "") ans = "0";

        return ans;
    }

    public String add() throws RuntimeException {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0) {
            throw new RuntimeException("ERROR");
        } else {
            return DecToBin(firstOperand.add(secondOperand).stripTrailingZeros().intValue());
        }
    }

    public String subtract() throws RuntimeException {

        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0) {
            throw new RuntimeException("ERROR");
        } else {

            return DecToBin(firstOperand.subtract(secondOperand).stripTrailingZeros().intValue());
        }

    }

    public String multiply() throws RuntimeException {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0) {
            throw new RuntimeException("ERROR");
        } else {

            return DecToBin(firstOperand.multiply(secondOperand).stripTrailingZeros().intValue());
        }
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0) {
            throw new RuntimeException("ERROR");
        } else if (secondOperand.intValue() == 0) {
            throw new ArithmeticException("devide by zero");
        }
        return DecToBin(firstOperand.divide(secondOperand, 5, RoundingMode.HALF_UP).stripTrailingZeros().intValue());
    }

    public String power() throws RuntimeException {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0) {
            throw new RuntimeException("ERROR");
        } else {
            String ans = Double.toString(Math.pow(firstOperand.doubleValue(), secondOperand.doubleValue()));
            firstOperand = new BigDecimal(ans);
            return DecToBin(firstOperand.stripTrailingZeros().intValue());
        }

    }

}

