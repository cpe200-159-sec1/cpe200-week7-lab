package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;
    private BigDecimal FOP;
    private BigDecimal SOP;

    public DecimalCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = operand;
        FOP = new BigDecimal(firstOperand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;
        SOP = new BigDecimal(secondOperand.getOperand());
    }

    public String add() throws RuntimeException {
        return null;
    }

    public String subtract() throws RuntimeException {
        return null;
    }

    public String multiply() throws RuntimeException {
        return null;
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        return null;
    }

    public String power() throws RuntimeException {
        return null;
    }

}
