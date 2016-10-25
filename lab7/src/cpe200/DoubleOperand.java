package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    private Double Operand;
    public DoubleOperand(Double d) {
        this.Operand = d;
    }

    @Override
    public String getOperand()
    {
        return this.Operand.toString();
    }
}
