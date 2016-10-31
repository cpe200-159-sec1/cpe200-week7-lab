package cpe200;

/**
 * Created by 123 on 31/10/2559.
 */
public class BinaryCalculator extends BaseCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    public BinaryCalculator(){

    }

    private int  binaryToint(String operand){
        return Integer.parseInt(operand,2);
    }

    @Override
    public void setFirstOperand(IOperand operand){
        for (int i=0;i<operand.getOperand().length();i++){
            if (operand.getOperand().charAt(i) != '0'){
                if (operand.getOperand().charAt(i) != '1'){
                    throw new ArithmeticException();
                }
            }
        }
        firstOperand = operand;
    }

    @Override
    public void setSecondOperand(IOperand operand){
        for (int i=0;i<operand.getOperand().length();i++){
            if (operand.getOperand().charAt(i) != '0'){
                if (operand.getOperand().charAt(i) != '1'){
                    throw new ArithmeticException();
                }
            }
        }
        secondOperand = operand;
    }

    @Override
    public String add() throws  RuntimeException{
        int first,second;
        first = binaryToint(firstOperand.getOperand());
        second = binaryToint(secondOperand.getOperand());
        return Integer.toBinaryString(first+second);
    }

    @Override
    public String subtract() throws  RuntimeException{
        int first,second;
        first = binaryToint(firstOperand.getOperand());
        second = binaryToint(secondOperand.getOperand());
        return Integer.toBinaryString(first-second);
    }

    @Override
    public String multiply() throws RuntimeException {
        int first,second;
        first = binaryToint(firstOperand.getOperand());
        second = binaryToint(secondOperand.getOperand());
        return Integer.toBinaryString(first*second);
    }

    @Override
    public String division() throws RuntimeException{
        int first,second;
        first = binaryToint(firstOperand.getOperand());
        second = binaryToint(secondOperand.getOperand());
        if (second == 0){
            throw new ArithmeticException();
        }
        return Integer.toBinaryString(first/second);
    }

    @Override
    public String power() throws RuntimeException{
        int first,second;
        first = binaryToint(firstOperand.getOperand());
        second = binaryToint(secondOperand.getOperand());
        return Integer.toBinaryString((int)Math.pow((double) first, (double) second));
    }


}
