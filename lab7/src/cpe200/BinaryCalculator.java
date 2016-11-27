package cpe200;



/**
 * Created by Asuka on 27/11/2559.
 */
public class BinaryCalculator extends BaseCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    public BinaryCalculator()
    {
        firstOperand = new IntegerOperand(0);
        secondOperand = new IntegerOperand(0);
    }

    public void setFirsteOperand(IOperand operand)
    {
        firstOperand = new StringOperand(toBinary(operand));
    }

    public void setSecondOperand(IOperand operand)
    {
        secondOperand = new StringOperand(toBinary(operand));
    }



    private String toBinary(IOperand operand) {
        String sBinary = "";
        String[] split = operand.getOperand().split("\\.");
        Integer iDecimal;
        if (split[0].matches("^-.+")) {
            sBinary = "-";
            iDecimal = Integer.parseInt(split[0].split("-")[1]);
        } else
            iDecimal = Integer.parseInt(split[0]);
        sBinary += Integer.toBinaryString(iDecimal);
        if (split.length > 1)
        {
            if (split[1].matches("^0+$"))
            {
                sBinary += ".00000";
                return sBinary;
            }
            else
            {
                int i = 0;
                sBinary += ".";
                do
                {
                    split[1] = "0." + split[1];
                    Double dDecimal = Double.parseDouble(split[1]);
                    dDecimal *= 2;
                    split[1] = dDecimal.toString();
                    split = split[1].split("\\.");
                    sBinary += split[0];
                    i++;
                }
                while ( i < 5);
            }

        }
        else
            sBinary += ".00000";
        return sBinary;
    }
}
