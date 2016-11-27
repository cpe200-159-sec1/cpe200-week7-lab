package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    String DOperand; //DoubleOperand

    public DoubleOperand(Double d)
    {
        this.DOperand = d.toString();
    }

    @Override
    public String getOperand() {
        return DOperand;
    }
}
