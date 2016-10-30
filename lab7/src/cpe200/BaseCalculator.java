package cpe200;


import java.math.BigDecimal;

/**
 * Created by Miztscyther on 10/27/2016.
 */
public class BaseCalculator {
    protected BigDecimal firstOperand;
    protected BigDecimal secondOperand;

    protected boolean isNegative()
    {
        return firstOperand.doubleValue()<0|| secondOperand.doubleValue()<0;
    }

    public String add() throws RuntimeException
    {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.add(secondOperand).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException
    {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.subtract(secondOperand).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException
    {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.multiply(secondOperand).stripTrailingZeros().toString();
    }

    public String division() throws RuntimeException {
        if(isNegative()|| secondOperand.doubleValue() == 0)
            throw new ArithmeticException();
        return firstOperand.divide(secondOperand, 5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.pow(secondOperand.intValue()).stripTrailingZeros().toString();
    }
}