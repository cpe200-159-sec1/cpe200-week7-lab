package cpe200;

import java.math.BigDecimal;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    private Double Operand;
    public DoubleOperand(Double d)
    {
        this.Operand = d;
    }

    @Override
    public String getOperand()
    {
        return Double.toString(this.Operand);
    }

    @Override
    public String getBinary()
    {
        BigDecimal number = new BigDecimal(getOperand());
        int intNum = number.intValue();
        IntegerOperand translate = new IntegerOperand(intNum);
        String part1 = translate.getBinary();

        Double DoubleNum = number.doubleValue()-intNum;
        if(DoubleNum==0) {
           return part1;
        }
        else {
            String part2 = "";
            String temp;
            do {
                DoubleNum *= 2;
                temp = Double.toString(DoubleNum);
                part2 += temp.charAt(0);
            } while (temp.charAt(0) == '0');
            return part1 + "." + part2;
        }
    }
}
