package cpe200;

/**
 * Created by kawewut on 10/27/2016 AD.
 */
public class DoubleOperand implements IOperand {
    private String operand;
    public DoubleOperand(Double d) {
        this.operand = Double.toString(d);
    }

    @Override
    public String getOperand() {
        return operand;
    }

}
