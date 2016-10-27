package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;

/**
 * Created by pruet on 5/9/2559.
 */

public abstract class BinaryCalculator extends BaseCalculator {

    @Override
    public void setFirstOperand(IOperand operand) {
        if (operand.getOperand().matches("[01]+")) {
            super.firstOperand = new BigDecimal(operand.getOperand());
        } else {
            throw new ArithmeticException("operand is not Binary");
        }
    }

    @Override
    public void setSecondOperand(IOperand operand) {
        if (operand.getOperand().matches("[01]+")) {
            super.secondOperand = new BigDecimal(operand.getOperand());
        } else {
            throw new ArithmeticException("operand is not Binary");
        }
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