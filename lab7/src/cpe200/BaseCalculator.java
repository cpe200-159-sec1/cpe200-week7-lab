package cpe200;

import java.math.BigDecimal;

/**
 * Created by Chetsada Chaiprasop on 10/26/2016.
 */
public class BaseCalculator {
    protected IOperand firstOperand;
    protected IOperand secondOperand;
    protected BigDecimal first;//have for check number
    protected BigDecimal second;//have for check number

    public void setFirstOperand(IOperand operand) {
        firstOperand = operand;
        first = new BigDecimal(firstOperand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;
        second = new BigDecimal(secondOperand.getOperand());
    }
}
