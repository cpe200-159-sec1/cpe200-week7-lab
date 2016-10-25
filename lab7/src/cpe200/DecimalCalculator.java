package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator {
    /*private IOperand firstOperand;
    private IOperand secondOperand;*/
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public DecimalCalculator() {
        firstOperand = new BigDecimal(0);
        secondOperand = new BigDecimal(0);
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(operand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(operand.getOperand());
    }

    public String add() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.add(secondOperand).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.subtract(secondOperand).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.multiply(secondOperand).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if(isNegative()|| secondOperand.doubleValue() == 0)
            throw new ArithmeticException();
        return firstOperand.divide(secondOperand, 5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.pow(secondOperand.intValue()).stripTrailingZeros().toString();
    }

    private boolean isNegative()
    {
        return firstOperand.doubleValue()<0|| secondOperand.doubleValue()<0;
    }
}
