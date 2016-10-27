package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by pruet on 5/9/2559.
 */

public class DecimalCalculator extends BaseCalculator {

    @Override
    public String add() {
        CheckNegativeOperand();
        return firstOperand.add(secondOperand)
                .stripTrailingZeros().toString();
    }

    @Override
    public String subtract() {
        CheckNegativeOperand();
        return firstOperand.subtract(secondOperand)
                .stripTrailingZeros().toString();
    }

    @Override
    public String multiply() {
        CheckNegativeOperand();
        return firstOperand.multiply(secondOperand)
                .stripTrailingZeros().toString();
    }

    @Override
    public String division() {
        if (secondOperand.equals(BigDecimal.ZERO))
            throw new ArithmeticException();
        CheckNegativeOperand();
        return firstOperand.divide(secondOperand, 5, RoundingMode.HALF_UP)
                .stripTrailingZeros().toString();
    }

    @Override
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
