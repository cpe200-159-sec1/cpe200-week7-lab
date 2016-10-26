package cpe200;

import java.math.BigDecimal;

import static java.lang.Math.pow;

/**
 * Created by Chetsada Chaiprasop on 10/25/2016.
 */
public class BinaryCalculator extends BaseCalculator{

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
            if(first.doubleValue()==second.doubleValue())
            {
                return convertToDecimal(result);
            }
            return (first.doubleValue()>second.doubleValue()? convertToDecimal(result):'-'+convertToDecimal(result));
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
            if(first.doubleValue()%second.doubleValue()==0) {
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
        String part1 = Integer.toString(new BigDecimal(input).intValue());
        int countPlus = 0;
        int intResult= 0;
        for (int i=part1.length()-1;i>=0;i--) {
            if (part1.charAt(i) == '1') {
                intResult += pow(2,countPlus);
                countPlus++;
            }
            else
            {
                countPlus++;
            }
        }
        if(input.indexOf('.')==-1) {
            return Integer.toString(intResult);
        }
        else  {
            String part2 = input.substring(input.indexOf('.')+1);
            int countDecrease = -1;
            Double doubleResult = 0.0;
            for (int i=0;i<part2.length();i++) {
                if (part2.charAt(i) == '1') {
                    doubleResult += pow(2,countDecrease);
                    countDecrease--;
                }
                else
                {
                    countDecrease--;
                }
            }
            return Double.toString(intResult+doubleResult);
        }
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
            if(temp.charAt(i)=='.')
            {
                result = '.'+result;
                continue;
            }
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
