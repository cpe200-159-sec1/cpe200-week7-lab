package cpe200;

import java.math.BigDecimal;
import static java.lang.Math.pow;

/**
 * Created by Asuka on 27/11/2559.
 */
public class BinaryCalculator {
    private IOperand x ; //firstOperand
    private IOperand y ; //secondOperand
    private BigDecimal firstOperand;
    private BigDecimal secondOperand;

    public BinaryCalculator()
    {
        x = new IntegerOperand(0);
        y = new IntegerOperand(0);
    }

    public void setFirsteOperand(IOperand operand)
    {
        x = new StringOperand(toBinary(operand));
        String a = x.getOperand();
        firstOperand = toBigDecimal(x.getOperand());
    }

    public void setSecondOperand(IOperand operand)
    {
        y = new StringOperand(toBinary(operand));
        secondOperand = toBigDecimal(y.getOperand());
    }

    private BigDecimal toBigDecimal(String str)
    {
        double sum = 0;
        boolean neg = false;
        if(str.matches("^-.+$"))
        {
            neg = true;
            str = str.split("-")[1];
        }
        String split[] = str.split("\\.");
        switch (split.length)
        {
            case 1:
                split = split[0].split("");
                for(int i = 0; i < split.length; i++)
                    sum += Integer.parseInt(split[i])*pow(2,split.length-(i+1));
                break;
            case 2://floating point number
                String iSplit[] = split[0].split("");
                for(int i = 0; i < iSplit.length; i++)
                    sum += Integer.parseInt(iSplit[i])*pow(2,iSplit.length-(i+1));
                iSplit = split[1].split("");
                for(int i =0; i < iSplit.length; i++)
                    sum += Integer.parseInt(iSplit[i])*pow(0.5,(i+1));
                break;
        }
        return new BigDecimal(sum*((neg)?-1:1));
    }

    private boolean isNegative()
    {
        return firstOperand.doubleValue()<0||secondOperand.doubleValue()<0;
    }

    private String toBinary(IOperand operand) {
        String sBinary = "";
        String[] split = operand.getOperand().split("\\.");
        //check if negative number
        //toBinaryString method cannot convert negative number properly
        Integer iDecimal;
        if (split[0].matches("^-.+")) {
            sBinary = "-";
            iDecimal = Integer.parseInt(split[0].split("-")[1]);
        } else
            iDecimal = Integer.parseInt(split[0]);
        sBinary += Integer.toBinaryString(iDecimal);
        if (split.length > 1)//length can only be just 1 or 2
        {
            if (split[1].matches("^0+$")) {
                return sBinary;
            } else {
                int i = 0;
                sBinary += ".";
                do {
                    split[1] = "0." + split[1];
                    Double dDecimal = Double.parseDouble(split[1]);
                    dDecimal *= 2;
                    split[1] = dDecimal.toString();
                    split = split[1].split("\\.");
                    sBinary += split[0];
                    i++;
                }
                while (!split[1].matches("^0+$") && i < 5);
            }

        }
        return sBinary;
    }


    public String add() throws RuntimeException
    {
        if (isNegative())
            throw new RuntimeException();
        return firstOperand.add(secondOperand).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return firstOperand.subtract(secondOperand).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
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
