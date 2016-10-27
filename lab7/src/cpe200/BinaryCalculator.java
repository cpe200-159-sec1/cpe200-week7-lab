package cpe200;

import java.math.BigDecimal;

/**
 * Created by ICQCQ on 27-Oct-16.
 */
public class BinaryCalculator extends BaseCalculator{

    @Override
    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("[01+]")){
            super.firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }

    @Override
    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("[01+]")){
            super.secondOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }
}
