package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public DecimalCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(operand.getOperand());
    }


    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(operand.getOperand());
    }

    public String add() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = firstOperand.add(secondOperand);
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return x.toString();
    }

    public String subtract() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = firstOperand.subtract(secondOperand);
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return x.toString();
    }

    public String multiply() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        BigDecimal x = firstOperand.multiply(secondOperand);
        x = x.setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return x.toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() {
        if (firstOperand.doubleValue() < 0 || secondOperand.doubleValue() < 0)
            throw new RuntimeException("Error");
        else if (secondOperand == BigDecimal.ZERO)
            throw new ArithmeticException("Error");
        BigDecimal x = firstOperand.divide(secondOperand, 5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return x.toString();
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
        return x.toString();
    }

}
