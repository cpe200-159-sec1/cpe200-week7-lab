package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class oparand implements IOperand{

    private String operand ;

    public oparand(Double d) {
        this.operand = Double.toString(d);
    }

    @Override
    public String getOperand() {
        return operand;
    }
}
