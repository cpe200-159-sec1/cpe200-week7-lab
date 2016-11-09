package cpe200;

import sun.security.x509.IPAddressName;

/**
 * Created by MSI GP72 on 3/11/2559.
 */
public class BinaryCalculator extends BaseCalculator{

    @Override
    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("^[01]+$")){
            super.firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }

    @Override
    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("^[01]+$")){
            super.secondOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }

    @Override
    public String getAnswer(){
        return Integer.toBinaryString(Integer.parseInt(super.answer));
    }
}