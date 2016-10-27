package cpe200;

public class decimalCalculator extends BaseCalculator{
    private IOperand firstOperand;
    private IOperand secondOperand;

    public decimalCalculator(){}

    public void setFirstOperand(IOperand operand) {
        super.firstOperand = operand;
    }

    public void setSecondOperand(IOperand operand) {
        super.secondOperand = operand;
    }
}
