package cpe200;


import java.math.BigDecimal;

public class DecimalCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;
    private BigDecimal first ;
    private BigDecimal sec;

    public DecimalCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        this.firstOperand = operand;
        first = new BigDecimal(firstOperand.getOperand());
    }


    public void setSecondOperand(IOperand operand) {
        this.secondOperand = operand;
        sec = new BigDecimal(secondOperand.getOperand());
    }

    public String add() throws RuntimeException {
        if (first.intValue() < 0 || sec.intValue() < 0) {
            throw new RuntimeException("Operand is negative");
        }
        return first.add(sec).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        if (first.intValue() < 0 || sec.intValue() < 0) {
            throw new RuntimeException("Operand is negative");
        }
        return first.subtract(sec).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        if (first.intValue() < 0 || sec.intValue() < 0) {
            throw new RuntimeException("Operand is negative");
        }
        return first.multiply(sec).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if (first.intValue() < 0 || sec.intValue() < 0) {
            throw new RuntimeException("Operand is negative");
        }
        if(sec.compareTo(BigDecimal.ZERO)==0) {
            throw new ArithmeticException("error");
        }
        return first.divide(sec,5,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        if (first.intValue() < 0 || sec.intValue() < 0) {
            throw new RuntimeException("Operand is negative");
        }
        return first.pow(sec.intValue()).stripTrailingZeros().toString();
    }

}