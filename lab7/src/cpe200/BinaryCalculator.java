package cpe200;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BiFunction;

/**
 * Created by Aunpyz on 10/25/2016.
 */
public class BinaryCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;
    private BigDecimal st;
    private BigDecimal nd;

    public BinaryCalculator()
    {
        firstOperand = new IntegerOperand(0);
        secondOperand = new IntegerOperand(0);
    }

    public void setFirstOperand(IOperand operand)
    {
        firstOperand = new StringOperand(toBinary(operand));
        //st = toBigDecimal(firstOperand);
    }

    public void setSecondOperand(IOperand operand)
    {
        secondOperand = new StringOperand(toBinary(operand));
        //nd = toBigDecimal(secondOperand);
    }

    private BigDecimal toBigDecimal(String str)
    {
        double sum = 0;
        String split[] = str.split("\\.");
        //2cases 1.integer, 2.floting point
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
        return new BigDecimal(sum);
    }

    private double pow(double a, int b)
    {
        BigDecimal A = new BigDecimal(a);
        return A.pow(b).doubleValue();
    }

    private boolean isNegative()
    {
        return firstOperand.getOperand().matches("^-.+$")||secondOperand.getOperand().matches("^-.+$");
    }

    private String toBinary(IOperand operand)
    {
        String sBinary= "";
        String[] split = operand.getOperand().split("\\.");
        //check if negative number
        //toBinaryString method cannot convert negative number properly
        Integer iDecimal;
        if(split[0].matches("^-.+"))
        {
            sBinary = "-";
            iDecimal = Integer.parseInt(split[0].split("-")[1]);
        }
        else
            iDecimal = Integer.parseInt(split[0]);
        sBinary += Integer.toBinaryString(iDecimal);
        if(split.length > 1)//length can only be just 1 or 2
        {
            if(split[1].matches("^0+$"))
            {
                sBinary += ".00000";
                return sBinary;
            }
            else//floating point number
            {
                int i = 0;
                sBinary += ".";
                //loop
                do {
                    split[1] = "0."+split[1];
                    Double dDecimal = Double.parseDouble(split[1]);
                    dDecimal *= 2;
                    split[1] = dDecimal.toString();
                    split = split[1].split("\\.");
                    sBinary += split[0];
                    i++;
                }while(i<5);
            }
        }
        else
            sBinary += ".00000";
        return sBinary;
    }

    public String add() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();

        //split 2 operands
        String firstSplit[] = firstOperand.getOperand().split("\\.");
        String secondSplit[] = secondOperand.getOperand().split("\\.");

        String adder = "";
        boolean carry = false;
        if(!(firstSplit[1].matches("^0+$")&&secondSplit[1].matches("^0+$")))
        {
            for(int i = 4; i >= 0; i--)
            {
                if(firstSplit[1].split("")[i].equals("1")&&secondSplit[1].split("")[i].equals("1"))
                {
                    if(carry)
                    {
                        adder = "1"+adder;
                    }
                    else
                    {
                        carry = true;
                        adder =  "0"+adder;
                    }
                }
                else if(firstSplit[1].split("")[i].equals("1")||secondSplit[1].split("")[i].equals("1"))
                {
                    if(carry)
                    {
                        adder = "0"+adder;
                    }
                    else
                    {
                        adder = "1"+adder;
                    }
                }
                else//both 0
                {
                    if(carry)
                    {
                        carry = false;
                        adder = "1"+adder;
                    }
                    else
                        adder = "0"+adder;
                }
            }
            adder = "."+adder;
        }
        if(firstSplit[0].length() != secondSplit[0].length())
        {
            if(firstSplit[0].length()>secondSplit[0].length())
                secondSplit[0] = String.format("%"+(firstSplit[0].length()-secondSplit[0].length())+"s","").replace(" ",String.valueOf("0"))+secondSplit[0];
            else
                firstSplit[0] = String.format("%"+(secondSplit[0].length()-firstSplit[0].length())+"s","").replace(" ",String.valueOf("0"))+firstSplit[0];
        }

        for(int i = firstSplit[0].length()-1; i>=0; i--)
        {
            if(firstSplit[0].split("")[i].equals("1")&&secondSplit[0].split("")[i].equals("1"))
            {
                if(carry)
                {
                    adder="1"+adder;
                }
                else
                {
                    carry = true;
                    adder="0"+adder;
                }
            }
            else if(firstSplit[0].split("")[i].equals("1")||secondSplit[0].split("")[i].equals("1"))
            {
                if(carry)
                {
                    adder="0"+adder;
                }
                else
                    adder="1"+adder;;
            }
            else//both 0
            {
                if(carry)
                {
                    carry = false;
                    adder = "1"+adder;
                }
                else
                    adder = "0"+adder;
            }
        }
        if(carry)
            adder="1"+adder;

        return toBigDecimal(adder).stripTrailingZeros().toString();
    }

    public String subtract() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return st.subtract(nd).stripTrailingZeros().toString();
    }

    public String multiply() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return st.multiply(nd).stripTrailingZeros().toString();
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if(isNegative()|| nd.doubleValue() == 0)
            throw new ArithmeticException();
        return st.divide(nd, 5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
    }

    public String power() throws RuntimeException {
        if(isNegative())
            throw new RuntimeException();
        return st.pow(nd.intValue()).stripTrailingZeros().toString();
    }
}
