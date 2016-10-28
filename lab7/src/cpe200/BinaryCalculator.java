package cpe200;

import java.math.BigDecimal;

import static java.lang.Math.pow;
import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_UP;

/**
 * Created by pruet on 5/9/2559.
 */

public class BinaryCalculator extends BaseCalculator {

    @Override
    public void setFirstOperand(IOperand operand) {
        if (operand.getOperand().matches("[01]+")) {
            firstOperand = BigDecimal.valueOf(Integer.parseInt(operand.getOperand(), 2));
        } else {
            throw new ArithmeticException("operand is not Binary");
        }
    }

    public String stringToBinaryString(String in) {
        return Integer.toBinaryString(Integer.parseInt(in));
    }

    @Override
    public void setSecondOperand(IOperand operand) {
        if (operand.getOperand().matches("[01]+")) {
            secondOperand = BigDecimal.valueOf(Integer.parseInt(operand.getOperand(), 2));
        } else {
            throw new ArithmeticException("operand is not Binary");
        }
    }

    public String add() {
        CheckNegativeOperand();
        return stringToBinaryString(firstOperand.add(secondOperand)
                .stripTrailingZeros().toString());
    }

    public String subtract() {
        CheckNegativeOperand();
        return stringToBinaryString(firstOperand.subtract(secondOperand)
                .stripTrailingZeros().toString());
    }

    public String multiply() {
        CheckNegativeOperand();
        return stringToBinaryString(firstOperand.multiply(secondOperand)
                .stripTrailingZeros().toString());
    }

    @Override
    public String division() {
        if (secondOperand.equals(ZERO))
            throw new ArithmeticException();
        CheckNegativeOperand();
        return stringToBinaryString(firstOperand.divide(secondOperand, 5, HALF_UP)
                .stripTrailingZeros().toString());
    }

    public String power() {
        CheckNegativeOperand();
        return stringToBinaryString(BigDecimal.valueOf(
                pow(
                        firstOperand.doubleValue(),
                        secondOperand.doubleValue()
                )
        ).stripTrailingZeros().toString());
    }


    private void CheckNegativeOperand() {
        if (firstOperand.compareTo(ZERO) < 0 || secondOperand.compareTo(ZERO) < 0) {
            throw new RuntimeException("Operand must greater than ZERO");
        }
    }
}
