package cpe200;

public class BinaryCalculator extends BaseCalculator{

    @Override
    public void setFirstOperand(IOperand operand) {
        if(operand.getOperand().matches("^[01]+$")){                    //use to check input that binary ot not?
            super.firstOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }

    @Override
    public void setSecondOperand(IOperand operand) {
        if(operand.getOperand().matches("^[01]+$")){                    //use to check input that binary ot not?
            super.secondOperand = new IntegerOperand(Integer.parseInt(operand.getOperand(),2));
        }else{
            throw new RuntimeException("The input isn't binary format.");
        }
    }
    @Override
    public String getAnswer(){
        return Integer.toBinaryString(Integer.parseInt(super.getAnswer()));
    }

}