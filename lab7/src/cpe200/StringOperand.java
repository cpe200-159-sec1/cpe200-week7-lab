package cpe200;

import java.math.BigDecimal;

public class StringOperand implements IOperand {
    private String operand;

    public StringOperand(String operand) {
        this.operand = operand;
    }

    @Override
    public String getOperand() {
        return operand;
    }

    @Override
    public String getBinary() {
        BigDecimal num = new BigDecimal(getOperand());
        int intNum = num.intValue();
        Double doubleNum = num.doubleValue();
        IntegerOperand part1 = new IntegerOperand(intNum);
        DoubleOperand part2 = new DoubleOperand(doubleNum-intNum);
        return part1.getBinary()+part2.getBinary().substring(1);
    }
}
