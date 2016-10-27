package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by pruet on 5/9/2559.
 */

public class BinaryCalculator {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public BinaryCalculator() {
        firstOperand = BigDecimal.ZERO;
        secondOperand = BigDecimal.ZERO;
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(operand.getOperand());
    }


    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(operand.getOperand());
    }

    public String add() {
        CheckNegativeOperand();
        return firstOperand.add(secondOperand)
                .stripTrailingZeros().toString();
    }

    public String subtract() {
        CheckNegativeOperand();
        return firstOperand.subtract(secondOperand)
                .stripTrailingZeros().toString();
    }

    public String multiply() {
        CheckNegativeOperand();
        return firstOperand.multiply(secondOperand)
                .stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() {
        if (secondOperand.equals(BigDecimal.ZERO))
            throw new ArithmeticException();
        CheckNegativeOperand();
        return firstOperand.divide(secondOperand, 5, RoundingMode.HALF_UP)
                .stripTrailingZeros().toString();
    }


    public String power() {
        CheckNegativeOperand();
        return BigDecimal.valueOf(
                Math.pow(
                        firstOperand.doubleValue(),
                        secondOperand.doubleValue()
                )
        ).stripTrailingZeros().toString();
    }

    private void CheckNegativeOperand() {
        if (firstOperand.compareTo(BigDecimal.ZERO) < 0 || secondOperand.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Operand must greater than ZERO");
        }
    }
}
