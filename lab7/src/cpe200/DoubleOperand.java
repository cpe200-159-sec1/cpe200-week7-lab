package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    String dOperand;
    public DoubleOperand(Double d) {
        this.dOperand = d.toString();
    }

    @Override
    public String getOperand() {
        return dOperand;
    }
}
