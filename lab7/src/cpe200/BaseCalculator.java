package cpe200;

import java.math.BigDecimal;

/**
 * Created by zalzer on 10/27/2016 AD.
 */
public class BaseCalculator {

    protected BigDecimal firstOperand;
    protected BigDecimal secondOperand;

    public BaseCalculator() {
        firstOperand = BigDecimal.ZERO;
        secondOperand = BigDecimal.ZERO;
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(operand.getOperand());
    }


    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(operand.getOperand());
    }

}
