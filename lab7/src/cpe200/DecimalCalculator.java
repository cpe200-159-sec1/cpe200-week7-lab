package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    public DecimalCalculator() {
    }

    public void setFirstOperand(IOperand operand) { firstOperand = operand; }

    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;
    }

    public String add() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.compareTo(BigDecimal.ZERO) <= 0 || second.compareTo(BigDecimal.ZERO) <= 0)
            throw  new RuntimeException("non-negative");
        else return first.add(second).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.compareTo(BigDecimal.ZERO) <= 0 || second.compareTo(BigDecimal.ZERO) <= 0)
            throw  new RuntimeException("non-negative");
        else return first.subtract(second).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.compareTo(BigDecimal.ZERO) <= 0 || second.compareTo(BigDecimal.ZERO) <= 0)
            throw  new RuntimeException("non-negative");
        else return first.multiply(second).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.compareTo(BigDecimal.ZERO) <= 0 || second.compareTo(BigDecimal.ZERO) <= 0)
            throw  new ArithmeticException("ERROR");
        else return first.divide(second,5,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.compareTo(BigDecimal.ZERO) <= 0 || second.compareTo(BigDecimal.ZERO) <= 0)
            throw  new RuntimeException("non-negative");
        else return first.pow(second.intValue()).stripTrailingZeros().toString();
    }

}