package cpe200;

public class StringOperand implements Bigdecimal {
    private String operand;

    public StringOperand(String operand) {
        this.operand = operand;
    }

    @Override
    public String getOperand() {
        return operand;
    }
}
