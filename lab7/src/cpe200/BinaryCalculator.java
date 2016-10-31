package cpe200;

public class BinaryCalculator extends BaseCalculator{
    private IOperand firstOperand;
    private IOperand secondOperand;

    private int binaryToInt(String operand){
        return Integer.parseInt(operand, 2);
    }

    public BinaryCalculator() {

    }
@Override
    public void setFirstOperand(IOperand operand) {
        for(int i=0;i<operand.getOperand().length();i++){
            if(operand.getOperand().charAt(i)!='0'){
                if(operand.getOperand().charAt(i)!= '1'){
                    throw new ArithmeticException();
                }
            }
        }
        firstOperand= operand;
    }
@Override
    public void setSecondOperand(IOperand operand) {
        for(int i=0;i<operand.getOperand().length();i++){
                if(operand.getOperand().charAt(i) !='0'){
                    if(operand.getOperand().charAt(i)!= '1'){
                        throw new ArithmeticException();
                    }
                }
            }
        secondOperand= operand;
    }
@Override
    public String add() throws RuntimeException {
        int first;
        int second;
        int out;
        first = binaryToInt(firstOperand.getOperand());
        second = binaryToInt(secondOperand.getOperand());
        out = first+second;
        return Integer.toBinaryString(out);
    }
@Override
    public String subtract() throws RuntimeException {
        int first;
        int second;
        int out;
        first = binaryToInt(firstOperand.getOperand());
        second = binaryToInt(secondOperand.getOperand());
        out= first-second;
        return Integer.toBinaryString(out);
    }

 @Override   public String multiply() throws RuntimeException {
        int first;
        int second;
        int out;
        first = binaryToInt(firstOperand.getOperand());
        second = binaryToInt(secondOperand.getOperand());
        out = first*second;
        return Integer.toBinaryString(out);
    }

    /* This method should throw an exception when divide by zero */
    @Override
    public String division() throws RuntimeException {
        int first;
        int second;
        int out;
        first = binaryToInt(firstOperand.getOperand());
        second = binaryToInt(secondOperand.getOperand());
        out = first/second;
        return Integer.toBinaryString(out);
    }
@Override
    public String power() throws RuntimeException {
        int first;
        int second;
        int out;
        first = binaryToInt(firstOperand.getOperand());
        second = binaryToInt(secondOperand.getOperand());
        out = (int)Math.pow((double) first,(double) second);
        return Integer.toBinaryString(out);
    }

}