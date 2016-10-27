package cpe200;

/**
 * Created by kawewut on 10/27/2016 AD.
 */
public class BinaryCalculator extends BaseCalculator{
    //LAB2
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
