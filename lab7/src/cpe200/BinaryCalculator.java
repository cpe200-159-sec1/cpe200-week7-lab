package cpe200;

import java.math.BigDecimal;

/**
 * Created by Nickky on 9/11/2559.
 */
public class BinaryCalculator extends BaseCalculator {
    public IOperand firstOperand;
    public IOperand secondOperand;


    private BigDecimal binaryToInt(String operand){
        return new  BigDecimal(Integer.parseInt(operand,2));
    }

    public void setFirstOperand(IOperand operand) {
        for (int i=0; i<operand.getOperand().length(); i++){
            if (operand.getOperand().charAt(i) != '0'){
                if (operand.getOperand().charAt(i) != '1'){
                    throw new ArithmeticException();
                }
            }
        }
        super.setx(binaryToInt(operand.getOperand()));
        firstOperand = operand;


    }

    public void setSecondOperand(IOperand operand) {
        for (int i=0; i<operand.getOperand().length(); i++){
            if (operand.getOperand().charAt(i) != '0'){
                if (operand.getOperand().charAt(i) != '1'){
                    throw new ArithmeticException();
                }
            }
        }
        super.sety(binaryToInt(operand.getOperand()));
        secondOperand = operand;
    }

    public String add() throws RuntimeException {
        return Integer.toBinaryString(Integer.parseInt(super.add()));
    }

    public String subtract() throws RuntimeException {
        return Integer.toBinaryString(Integer.parseInt(super.subtract()));
    }

    public String multiply() throws RuntimeException {
        return Integer.toBinaryString(Integer.parseInt(super.multiply()));
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        return Integer.toBinaryString(Integer.parseInt(super.division()));
    }

    public String power() throws RuntimeException {
        return Integer.toBinaryString(Integer.parseInt(super.power()));
    }
}
