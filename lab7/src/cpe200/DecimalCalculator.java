package cpe200;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalCalculator {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;


    public DecimalCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = new BigDecimal(operand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = new BigDecimal(operand.getOperand());
    }

    public String add() throws RuntimeException {

        if(firstOperand.doubleValue()<0 || secondOperand.doubleValue()<0){
            throw new RuntimeException("ERROR");
        }else {

            return firstOperand.add(secondOperand).stripTrailingZeros().toString();
        }
    }

    public String subtract() throws RuntimeException {

        if(firstOperand.doubleValue()<0 || secondOperand.doubleValue()<0){
            throw new RuntimeException("ERROR");
        }else {

            return firstOperand.subtract(secondOperand).stripTrailingZeros().toString();
        }

    }

    public String multiply() throws RuntimeException {
        if(firstOperand.doubleValue()<0 || secondOperand.doubleValue()<0){
            throw new RuntimeException("ERROR");
        }else {

            return firstOperand.multiply(secondOperand).stripTrailingZeros().toString();
        }
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if(firstOperand.doubleValue()<0 || secondOperand.doubleValue()<0) {
            throw new RuntimeException("ERROR");
        }else if (secondOperand.intValue() == 0 ){
            throw new ArithmeticException("devide by zero");
        }
        return firstOperand.divide(secondOperand,5, RoundingMode.HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        if(firstOperand.doubleValue()<0 || secondOperand.doubleValue()<0){
            throw new RuntimeException("ERROR");
        }else{
            String ans = Double.toString(Math.pow(firstOperand.doubleValue(),secondOperand.doubleValue()));
            firstOperand = new BigDecimal(ans);
            return firstOperand.stripTrailingZeros().toString();
        }

    }

}
