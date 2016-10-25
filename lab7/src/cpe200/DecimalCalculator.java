package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    private BigDecimal x;
    private BigDecimal y;

    public DecimalCalculator() {
        x = new BigDecimal(0);
        y = new BigDecimal(0);
    }

    public void setFirstOperand(IOperand operand) {
        x = new BigDecimal(operand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        y = new BigDecimal(operand.getOperand());
    }

    public String add() throws RuntimeException {
        if(x.intValue() < 0 || y.intValue() < 0){
            throw new RuntimeException("Not negative");
        }return x.add(y).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        if(x.intValue() < 0 || y.intValue() < 0){
            throw new RuntimeException("Not negative");
        }return x.subtract(y).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        if(x.intValue() < 0 || y.intValue() < 0){
            throw new RuntimeException("Not negative");
        }return x.multiply(y).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if(x.intValue() < 0 || y.intValue() < 0){
            throw new RuntimeException("Not negative");
        }return x.divide(y, 5, BigDecimal.ROUND_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        if(x.intValue() < 0 || y.intValue() < 0){
            throw new RuntimeException("Not negative");
        }return x.pow(y.intValue()).stripTrailingZeros().toString();
    }

}
