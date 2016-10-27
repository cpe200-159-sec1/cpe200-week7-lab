package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class IntegerOperand implements IOperand {

    private String operand;

    public IntegerOperand(int operand) {
        this.operand = Integer.toString(operand);
    }

    @Override
    public String getOperand() {
        return operand;
    }
}
