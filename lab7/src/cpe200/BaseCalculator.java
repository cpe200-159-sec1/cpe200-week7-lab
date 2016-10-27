package cpe200;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by zalzer on 10/27/2016 AD.
 */
public abstract class BaseCalculator {

    protected BigDecimal firstOperand;
    protected BigDecimal secondOperand;

    public BaseCalculator() {
        firstOperand = BigDecimal.ZERO;
        secondOperand = BigDecimal.ZERO;
    }

    public BigDecimal getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(operand.getOperand());
    }

    public BigDecimal getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(operand.getOperand());
    }

    public abstract String add();

    public abstract String subtract();

    public abstract String multiply();

    /* This method should throw an exception when divide by zero */
    public abstract String division();


    public abstract String power();
}
