package cpe200;

/**
 * Created by ICQCQ on 27-Oct-16.
 */
public class BinaryCalculator extends BaseCalculator{
    private IOperand firstOperand;
    private IOperand secondOperand;

    public BinaryCalculator(){}

    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("[01]+")){
            super.firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("Not binary input");
        }
    }

    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("[01]+")){
            super.secondOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("Not binary input");
        }
    }
}
