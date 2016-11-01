package cpe200;


import java.math.BigDecimal;

public class BinaryCalculator extends BaseCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    public BinaryCalculator() {

    }

    @Override
    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("^[01]+]")){
            super.firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new ArithmeticException("The input isn't binary format.");
        }
    }

    @Override
    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("^[01]+]")){
            super.secondOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new ArithmeticException("The input isn't binary format.");
        }
    }




}
