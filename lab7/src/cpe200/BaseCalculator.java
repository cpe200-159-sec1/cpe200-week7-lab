package cpe200;

/**
 * Created by User on 31/10/2559.
 */

import java.math.BigDecimal;

public class BaseCalculator{
    private IOperand firstOperand;
    private IOperand secondOperand;

    public BaseCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand=operand;
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand=operand;
    }

    public String add() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.intValue()<0|| second.intValue()<0){
            throw new RuntimeException();
        }
        BigDecimal out = first.add(second);
        return out.stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.intValue()<0|| second.intValue()<0){
            throw new RuntimeException();
        }
        BigDecimal out = first.subtract(second);
        return out.stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.intValue()<0|| second.intValue()<0){
            throw new RuntimeException();
        }
        BigDecimal out = first.multiply(second);
        return out.stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.intValue()<0|| second.intValue()<0){
            throw new RuntimeException();
        }
        BigDecimal out = first.divide(second,5,5);
        return out.stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        BigDecimal first = new BigDecimal(firstOperand.getOperand());
        BigDecimal second = new BigDecimal(secondOperand.getOperand());
        if(first.intValue()<0|| second.intValue()<0){
            throw new RuntimeException();
        }
        BigDecimal out = first.pow(second.intValue());
        return out.stripTrailingZeros().toString();
    }

}

