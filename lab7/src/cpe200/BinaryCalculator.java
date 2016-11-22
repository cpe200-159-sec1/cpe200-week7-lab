package cpe200;

/**
 * Created by Nickky on 9/11/2559.
 */
public class BinaryCalculator extends BaseCalculator {
    public IOperand firstOperand;
    public IOperand secondOperand;

    int x;
    int y;

    public BinaryCalculator() {
    }
    private int binaryToInt(String operand){
        return Integer.parseInt(operand,2);
    }

    public void setFirstOperand(IOperand operand) {
        for (int i=0; i<operand.getOperand().length(); i++){
            if (operand.getOperand().charAt(i) != '0'){
                if (operand.getOperand().charAt(i) != '1'){
                    throw new ArithmeticException();
                }
            }
        }
        x = binaryToInt(operand.getOperand());
        firstOperand = operand;


    }

    public void setSecondOperand(IOperand operand) {
        for (int i=0; i<operand.getOperand().length(); i++){
            if (operand.getOperand().charAt(i) != '0'){
                if (operand.getOperand().charAt(i) != '1'){
                    throw new ArithmeticException();
                }
            }
        }
        y = binaryToInt(operand.getOperand());
        secondOperand = operand;
    }

    public String add() throws RuntimeException {
        return Integer.toBinaryString(x + y);
    }

    public String subtract() throws RuntimeException {
        return Integer.toBinaryString(x - y);
    }

    public String multiply() throws RuntimeException {
        return Integer.toBinaryString(x * y);
    }

    /* This method should throw an exception when divide by zero */
    public String division() throws RuntimeException {
        return Integer.toBinaryString(x / y);
    }

    public String power() throws RuntimeException {
        return Integer.toBinaryString((int)Math.pow((double) x, (double) y));
    }
}
