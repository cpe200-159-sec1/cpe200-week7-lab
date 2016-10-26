package cpe200;

import java.math.BigDecimal;

import static java.lang.Math.pow;

/**
 * Created by Chetsada Chaiprasop on 10/25/2016.
 */
public class BinaryCalculator {
    public  IOperand firstOperand;
    public IOperand secondOperand;
    public  BigDecimal first;//have for check number
    public BigDecimal second;//have for check number

    public BinaryCalculator() {
    }

    public void setFirstOperand(IOperand operand) {
        firstOperand = operand;
        first = new BigDecimal(firstOperand.getOperand());
    }

    public void setSecondOperand(IOperand operand) {
        secondOperand = operand;
        second = new BigDecimal(secondOperand.getOperand());
    }

    public String add() throws RuntimeException {
        if(first.intValue()<0||second.intValue()<0)
        {
            throw new RuntimeException("Operand is negative");
        }
        else
        {
            String result = addBinary(firstOperand.getBinary(),secondOperand.getBinary());
            return convertToDecimal(result);
        }
    }

    public String subtract() throws RuntimeException {
        if(first.intValue()<0||second.intValue()<0)
        {
            throw new RuntimeException("Operand is negative");
        }
        else
        {
            String result = subBinary(firstOperand.getBinary(),secondOperand.getBinary());
            if(first.intValue()==second.intValue())
            {
                return convertToDecimal(result);
            }
            return (first.intValue()>second.intValue()? convertToDecimal(result):'-'+convertToDecimal(result));
        }
    }

    public String multiply() throws RuntimeException {
        if(first.intValue()<0||second.intValue()<0)
        {
            throw new RuntimeException("Operand is negative");
        }
        else
        {
            String result = multiBinary(firstOperand.getBinary(),secondOperand.getBinary());
            return convertToDecimal(result);
        }
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        if(first.intValue()<0||second.intValue()<0)
        {
            throw new RuntimeException("Operand is negative");
        }
        else if(second.intValue()==0)
        {
            throw new ArithmeticException("ERROR divisor is zero");
        }
        else
        {
            if(first.intValue()%second.intValue()==0) {
                String result = divideBinary(firstOperand.getBinary(), secondOperand.getBinary());
                return convertToDecimal(result);
            }
            else
            {
                BigDecimal Dnum1 = new BigDecimal(convertToDecimal(firstOperand.getBinary()));
                BigDecimal Dnum2 = new BigDecimal(convertToDecimal(secondOperand.getBinary()));
                return Dnum1.divide(Dnum2,5,5).stripTrailingZeros().toString();
            }
        }
    }

    public String power() throws RuntimeException {
        if (first.intValue() < 0 || second.intValue() < 0) {
            throw new RuntimeException("Operand is negative");
        } else {
            BigDecimal Dnum1 = new BigDecimal(convertToDecimal(firstOperand.getBinary()));
            BigDecimal Dnum2 = new BigDecimal(convertToDecimal(secondOperand.getBinary()));
            double doubleNum1 = Dnum1.doubleValue();
            double doubleNum2 = Dnum2.doubleValue();
            DoubleOperand temp = new DoubleOperand(pow(doubleNum1,doubleNum2));
            BigDecimal sent = new BigDecimal(temp.getOperand());
            return sent.stripTrailingZeros().toString();
        }
    }

    private String convertToDecimal(String input)
    {
        int count = 0;
        int result= 0;
        for (int i=input.length()-1;i>=0;i--) {
            if (input.charAt(i) == '1') {
                result += pow(2,count);
                count++;
            }
            else
            {
                count++;
            }
        }
        return Integer.toString(result);
    }

    private String addBinary(String num1,String num2)
    {
        BigDecimal Dnum1 = new BigDecimal(num1);
        BigDecimal Dnum2 = new BigDecimal(num2);
        String temp = Dnum1.add(Dnum2).toString();

        String result = "";
        String carryIn = "0";
        for(int i=temp.length()-1;i>=0;i--)
        {
            BigDecimal intcarryIn = new BigDecimal(carryIn);
            BigDecimal intchar = new BigDecimal(temp.charAt(i)+"");
            int inttemp = intcarryIn.intValue()+intchar.intValue();
            if(inttemp>1)
            {
                result = Integer.toString(inttemp%2)+result;
                carryIn = Integer.toString(inttemp/2);
            }
            else
            {
                result = temp.charAt(i)+result;
                carryIn = "0";
            }
        }
        result = carryIn+result;
        return result;
    }

    private String subBinary(String num1, String num2) {
        BigDecimal Dnum1 = new BigDecimal(num1);
        BigDecimal Dnum2 = new BigDecimal(num2);
        String temp;
        if(Dnum1.intValue()>Dnum2.intValue()) {
            temp = Dnum1.subtract(Dnum2).toString();
        }
        else
        {
            temp = Dnum2.subtract(Dnum1).toString();
        }

        String result ="";
        for(int i=temp.length()-1;i>=0;i--)
        {
            if(temp.charAt(i)=='9')
            {
                result = '1'+result;
            }
            else
            {
                result = temp.charAt(i)+result;
            }
        }
        return result;
    }

    private String multiBinary(String num1, String num2) {
        BigDecimal Dnum1 = new BigDecimal(num1);
        BigDecimal Dnum2 = new BigDecimal(num2);
        String temp = Dnum1.multiply(Dnum2).toString();
        String result = addBinary(temp,"0");
        return result;
    }

    private String divideBinary(String num1, String num2) {
        BigDecimal Dnum1 = new BigDecimal(num1);
        BigDecimal Dnum2 = new BigDecimal(num2);
        String temp = Dnum1.divide(Dnum2).toString();
        return temp;
    }
}
