package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BinaryCalculator extends BaseCalculator{
    private IOperand firstOperand;
    private IOperand secondOperand;

    public BinaryCalculator() {
    }

    public void setFirstOperand(IOperand operand)
    {
        if(operand.getOperand().matches("[01]+"))
            firstOperand = new StringOperand(Integer.toString(Integer.parseInt(operand.getOperand(),2))) ;


        else
            throw new ArithmeticException("Operand is not binary");
    }


    public void setSecondOperand(IOperand operand)
    {
        if(operand.getOperand().matches("[01]+"))
            secondOperand = new StringOperand(Integer.toString(Integer.parseInt(operand.getOperand(),2))) ;
        else
            throw new ArithmeticException("Operand is not binary");

    }
}