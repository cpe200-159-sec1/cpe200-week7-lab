package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    String Operand;
    public DoubleOperand(Double d) {
        this.Operand = d.toString();
    }

    @Override
    public String getOperand() {
        return Operand;
    }
}