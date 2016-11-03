package cpe200;

import java.math.BigDecimal;

/**
 * Created by User on 2/11/2559.
 */
public class BinaryCalculator {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(0);
        firstOperand = BinToDec(operand.getOperand(), firstOperand);
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(0);
        secondOperand = BinToDec(operand.getOperand(), secondOperand);
    }

    private BigDecimal BinToDec(String check, BigDecimal x) {
        int power = -1;
        for (int i = check.length() - 1; i >= 0; i--) {
            power++;
            if (check.charAt(i) == '0')
                continue;
            else if (check.charAt(i) == '1')
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

    public String add() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = firstOperand.add(secondOperand);
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return DecToBin(x.intValue());
    }

    public String subtract() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = firstOperand.subtract(secondOperand);
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return DecToBin(x.intValue());
    }

    public String multiply() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = firstOperand.multiply(secondOperand);
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return DecToBin(x.intValue());
    }

    /* This method should throw an exception when divide by zero */
    public String division() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        else if (secondOperand == BigDecimal.ZERO)
            throw new ArithmeticException("Error");
        BigDecimal x = firstOperand.divide(secondOperand, 5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return DecToBin(x.intValue());
    }

    public String power() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = new BigDecimal(
                Double.toString(
                        Math.pow(firstOperand.doubleValue(), secondOperand.doubleValue())
                )
        );
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
        return DecToBin(x.intValue());
    }
}
