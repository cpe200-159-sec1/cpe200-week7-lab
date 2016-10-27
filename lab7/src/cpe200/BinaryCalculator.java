package cpe200;

import java.math.BigDecimal;

/**
 * Created by ICQCQ on 27-Oct-16.
 */
public class BinaryCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("[01+]")){
            firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }

    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("[01+]")){
            secondOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }


    public String add() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operan < 1");
        }

        return d1.add(d2).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operan < 1");
        }

        return d1.subtract(d2).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operan < 1");
        }

        return d1.multiply(d2).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operan < 1");
        }
        if(d2.compareTo(BigDecimal.ZERO) == 0){
            throw  new  ArithmeticException("operan < 1");
        }

        return d1.divide(d2,5,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operan < 1");
        }

        d1 = d1.pow(d2.intValue());
        d1 = d1.stripTrailingZeros();
        return d1.toString();
    }
}
