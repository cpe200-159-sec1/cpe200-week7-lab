package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by SatrarinSaejew on 10/25/2016 AD.
 */
public class BinaryCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("[01]+")){
            firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }
        else
            throw  new  RuntimeException("not binary number");
    }

    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("[01]+")){
            firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }
        else
            throw  new  RuntimeException("not binary number");
    }
}
