package cpe200;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseCalculator {
    protected IOperand firstOperand;
    protected IOperand secondOperand;

    public BaseCalculator() {
    }
    public String add()
    {
        BigDecimal temp1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal temp2 = new BigDecimal(secondOperand.getOperand());
        if (temp1.compareTo(BigDecimal.ZERO) < 0 || temp2.compareTo(BigDecimal.ZERO) < 0)
            throw new RuntimeException();
        else
            temp1=temp1.add(temp2).stripTrailingZeros();
        return temp1.toString();
    }

    public String subtract()
    {
        BigDecimal temp1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal temp2 = new BigDecimal(secondOperand.getOperand());
        if (temp1.compareTo(BigDecimal.ZERO) < 0 || temp2.compareTo(BigDecimal.ZERO) < 0)
            throw new RuntimeException();
        return temp1.subtract(temp2).stripTrailingZeros().toString();
    }

    public String multiply()
    {
        BigDecimal temp1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal temp2 = new BigDecimal(secondOperand.getOperand());
        if (temp1.compareTo(BigDecimal.ZERO) < 0 || temp2.compareTo(BigDecimal.ZERO) < 0)
            throw new RuntimeException();
        return temp1.multiply(temp2).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division()
    {
        BigDecimal temp1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal temp2 = new BigDecimal(secondOperand.getOperand());
        if( temp1.compareTo(BigDecimal.ZERO) < 0 || temp2.compareTo(BigDecimal.ZERO) < 0)
            throw new RuntimeException();
        if(temp1.compareTo(BigDecimal.ZERO)==0)
            throw new ArithmeticException();
        temp2 = temp1.divide(temp2,5, RoundingMode.HALF_UP).stripTrailingZeros();
        return temp2.toString();
    }
    public String power() {
        BigDecimal temp1 = new BigDecimal(firstOperand.getOperand());
        BigDecimal temp2 = new BigDecimal(secondOperand.getOperand());
        if( temp1.compareTo(BigDecimal.ZERO) < 0 || temp2.compareTo(BigDecimal.ZERO) < 0)
            throw new RuntimeException();
        temp1 = temp1.pow(temp2.intValue()).stripTrailingZeros();
        return temp1.toString();
    }
}