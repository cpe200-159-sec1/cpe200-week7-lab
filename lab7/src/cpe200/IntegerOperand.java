package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class IntegerOperand implements IOperand {
    private String operand;
    public IntegerOperand(int i) {
        String tmp = Integer.toString(i);
        this.operand = tmp;
    }

    @Override
    public String getOperand() {
        return operand;
    }
}
