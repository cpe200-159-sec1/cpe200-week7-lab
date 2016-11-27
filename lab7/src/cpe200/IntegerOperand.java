package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class IntegerOperand implements IOperand {
    String IOperand; // Integer Operand

    public IntegerOperand(Integer i) {
        this.IOperand = i.toString();

    }

    @Override
    public String getOperand() {
        return IOperand;
    }
}
