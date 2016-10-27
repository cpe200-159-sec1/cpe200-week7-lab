package cpe200;

/**
 * Created by pruet on 26/9/2559.
 */
public class DoubleOperand implements IOperand{
    private String value;
    public DoubleOperand(Double d) {
        String temp = Double.toString(d);
        temp = temp.indexOf(".") < 0 ? temp : temp.replaceAll("0*$", "").replaceAll("\\.$", "");
        this.value = temp;
    }

    @Override
    public String getOperand() {
        return this.value;
    }
}
