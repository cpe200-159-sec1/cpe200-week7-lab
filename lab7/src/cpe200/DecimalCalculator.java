package cpe200;

import java.math.BigDecimal;

public class DecimalCalculator {
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public DecimalCalculator() {
        firstOperand = new BigDecimal(0);
        secondOperand = new BigDecimal(0);
    }

    public void setFirstOperand(Bigdecimal operand) {
        this.firstOperand = new BigDecimal(operand.getOperand());
    }

    public void setSecondOperand(Bigdecimal operand) {
        this.secondOperand = new BigDecimal(operand.getOperand());
    }

    public String add() throws RuntimeException {
        if (firstOperand.compareTo(BigDecimal.ZERO) < 0 || secondOperand.compareTo(BigDecimal.valueOf(-1)) == 0  )
            throw new RuntimeException("Value is negative");
        return firstOperand.add(secondOperand).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        if (firstOperand.compareTo(BigDecimal.ZERO) < 0 || secondOperand.compareTo(BigDecimal.ZERO) < 0  )
            throw new RuntimeException("Value is negative");
        return firstOperand.subtract(secondOperand).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        if (firstOperand.compareTo(BigDecimal.ZERO) < 0 || secondOperand.compareTo(BigDecimal.ZERO) < 0  )
            throw new RuntimeException("Value is negative");
        return firstOperand.multiply(secondOperand).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if( secondOperand.compareTo(BigDecimal.ZERO) == 0 ){
            throw new ArithmeticException("Argument 'divisor' is 0");}
        if (firstOperand.compareTo(BigDecimal.ZERO) < 0 || secondOperand.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Argument 'divisor' is negative");}

        secondOperand = firstOperand.divide(secondOperand,5,BigDecimal.ROUND_HALF_UP).stripTrailingZeros();

        return secondOperand.toString();
    }

    public String power() throws RuntimeException {
        if (firstOperand.compareTo(BigDecimal.ZERO) < 0 || secondOperand.compareTo(BigDecimal.ZERO) < 0  )
            throw new RuntimeException("Value is negative");
        return BigDecimal.valueOf(Math.pow(firstOperand.doubleValue(),secondOperand.doubleValue())).stripTrailingZeros().toString();
    }

}
