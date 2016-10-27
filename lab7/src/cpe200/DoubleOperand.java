package cpe200;

import java.math.BigDecimal;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    private String operand;

    public DoubleOperand(double operand) {
        this.operand = Double.toString(operand);
    }

    @Override
    public String getOperand() {
        return operand;
    }
}
