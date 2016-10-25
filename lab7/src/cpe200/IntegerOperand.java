package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class IntegerOperand implements IOperand {
    String iOperand;
    public IntegerOperand(Integer i) {
        this.iOperand = i.toString();
    }

    @Override
    public String getOperand() {
        return iOperand;
    }
}
