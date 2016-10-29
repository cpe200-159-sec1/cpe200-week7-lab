package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */

public class IntegerOperand implements IOperand {
    private int Operand;
    public IntegerOperand(int d) {
        this.Operand = d;
    }

    @Override
    public String getOperand()
    {
        return Integer.toString(this.Operand);
    }

    @Override
    public String getBinary() {
        return Integer.toBinaryString(this.Operand);
    }
}
