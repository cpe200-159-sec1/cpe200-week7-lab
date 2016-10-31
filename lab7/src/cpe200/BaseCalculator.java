package cpe200;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.math.BigDecimal;

/**
 * Created by com on 31/10/2559.
 */
public class BaseCalculator {
    protected IOperand firstOperand;
    protected IOperand secondOperand;
    protected String answer;

    public void setFirstOperand(IOperand operand){
        firstOperand = operand;
    }
    public void setSecondOperand(IOperand operand){
        secondOperand = operand;
    }
    public String add() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operand < 1");
        }

        this.setAnswer(d1.add(d2).stripTrailingZeros().toString());
        return this.getAnswer();
    }

    public String subtract() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("operand < 1");
        }
        this.setAnswer(d1.subtract(d2).stripTrailingZeros().toString());
        return this.getAnswer();
    }

    public String multiply() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operand < 1");
        }

        this.setAnswer(d1.multiply(d2).stripTrailingZeros().toString());
        return this.getAnswer();

    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operand < 1");
        }
        if(d2.compareTo(BigDecimal.ZERO) == 0){
            throw  new  ArithmeticException("operand < 1");
        }

        this.setAnswer(d1.divide(d2,5,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString());
        return this.getAnswer();
    }

    public String power() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("operand < 1");
        }

        d1 = d1.pow(d2.intValue());
        d1 = d1.stripTrailingZeros();
        this.setAnswer(d1.toString());
                return this.getAnswer();
    }

    public void setAnswer(String ans){
        this.answer = ans;    }

    public String getAnswer(){
        return this.answer;
    }

}


