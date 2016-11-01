package cpe200;

import java.math.BigDecimal;


public class BaseCalculator {
    public IOperand firstOperand;
    public IOperand secondOperand;
    public String answer;
    public BaseCalculator() {
    }
    public void setFirstOperand(IOperand operand) {
        firstOperand = operand;
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;
    }


    public String add() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("error operan < 1");
        }
        setAns(d1.add(d2).stripTrailingZeros().toString());
        return getAnswer();
    }

    public String subtract() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("error operan < 1");
        }
        setAns(d1.subtract(d2).stripTrailingZeros().toString());
        return getAnswer();
    }

    public String multiply() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("error operan < 1");
        }
        setAns(d1.multiply(d2).stripTrailingZeros().toString());
        return getAnswer();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("error operan < 1");
        }
        if(d2.compareTo(BigDecimal.ZERO) == 0){
            throw  new  ArithmeticException("error operan < 1");
        }
        setAns( d1.divide(d2,5,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString());
        return getAnswer();
    }

    public String power() throws RuntimeException {
        BigDecimal d1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal d2 = new BigDecimal(secondOperand.getOperand());
        if(d1.compareTo(BigDecimal.ZERO) < 0 || d2.compareTo(BigDecimal.ZERO) < 0){
            throw  new  RuntimeException("error operan < 1");
        }

        d1 = d1.pow(d2.intValue());
        d1 = d1.stripTrailingZeros();
        setAns(d1.toString());
        return getAnswer();
    }

    public  String getAnswer()  throws RuntimeException {
        return  answer;
    }
    public  void setAns(String answer)  throws RuntimeException {
        this.answer = answer;
    }

}