package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator extends BaseCalculator {
    private BigDecimal FOP;
    private BigDecimal SOP;

    public DecimalCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        super.firstOperand = operand;
        FOP = new BigDecimal(firstOperand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        super.secondOperand = operand;
        SOP = new BigDecimal(secondOperand.getOperand());
    }
}