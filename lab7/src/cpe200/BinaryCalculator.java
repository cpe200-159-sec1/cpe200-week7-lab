package cpe200;

/**
 * Created by ather on 25/10/2559.
 */
public class BinaryCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    private String x;
    private String y;
    private String carry;

    private int pointLength = 0;

    public BinaryCalculator() {
        x = "0";
        y = "0";
    }

    public void setFirstOperand(IOperand operand) {
        System.out.println("x was to Setting");
        /*try{
            System.out.println("Int was to Setting");
            x = Integer.toBinaryString(Integer.parseInt(operand.getOperand()));
        }catch (NumberFormatException e){
            System.out.println("Dounble was to Setting");
            x = toBinary(Double.parseDouble(operand.getOperand()), 10);
        }*/
        System.out.println(getFloat("3"));

        getFloat(operand.toString());
        System.out.println("rrrr:  "+x);

        firstOperand = operand;
    }

    public void setSecondOperand(IOperand operand) {
        System.out.println("y was to Setting");
        y = Integer.toBinaryString(Integer.parseInt(operand.getOperand()));
        secondOperand = operand;
    }

    public String add() throws RuntimeException {
        //Full Adder
        chkBalance();
        String sum = new String();
        String carry = new String("0");
        for (int i=this.x.length()-1;i>=0;i--){
            sum += Integer.parseInt(Character.toString(y.charAt(i)))
                    ^(Integer.parseInt(Character.toString(x.charAt(i)))
                    ^Integer.parseInt(carry));
            carry = Integer.toString(
                        (Integer.parseInt(Character.toString(y.charAt(i)))
                        &Integer.parseInt(Character.toString(x.charAt(i))))
                        |Integer.parseInt(carry)&
                        (Integer.parseInt(Character.toString(y.charAt(i)))
                        ^Integer.parseInt(Character.toString(x.charAt(i))))
                    );
        }
        this.carry = carry;
        return Integer.toString(Integer.parseInt(carry+sum, 2));
    }

    public String subtract() throws RuntimeException {
        //one_complement
        if(Integer.parseInt(firstOperand.getOperand()) >= 0){
            chkBalance();
            String complement_y = one_complement(y);
            IOperand f1 = new StringOperand(x);
            IOperand f2 = new StringOperand(complement_y);
            BinaryCalculator numerator = new BinaryCalculator();
            numerator.setFirstOperand(f1);
            numerator.setSecondOperand(f2);
            String res = numerator.add();
            if (numerator.getCarry().equals(1)){
                f1 = new StringOperand(res);
                f2 = new StringOperand("1");
                numerator = new BinaryCalculator();
                numerator.setFirstOperand(f1);
                numerator.setSecondOperand(f2);
                return numerator.add();
            }else {
                return one_complement(res);
            }
        }else {
            throw new RuntimeException();
        }
    }

    public String multiply() throws RuntimeException {
        return "";
    }

    /* This method should throw an exception when divide by zero*/
    public String division() throws RuntimeException {
        return "";
    }

    public String power() throws RuntimeException {
        return "";
    }

    public void chkBalance() throws RuntimeException{
        this.x = String.format("%0"+this.y.length()+"d", Integer.parseInt(this.x));
        this.y = String.format("%0"+this.x.length()+"d", Integer.parseInt(this.y));
        System.out.println("Check Balance");
    }

    public String one_complement(String base) throws RuntimeException{
        String res = new String();
        for (int i=0;i<base.length();i++){
            res += (base.charAt(i) == '0')?"1":"0";
        }
        return res;
    }
    private String use_adder(){
        return "";
    }

    private String getFloat(String x){
        //Covert String of Double to String of Binary Double without point
        if (x.contains(".")){
            System.out.println("Yes has point");
            double f = Double.parseDouble("0."+x.split("[.]")[1]);

            //Find float Length
            String fText = floatToBinaryString(f);
            pointLength = fText.length();
            String s = x.split("[.]")[0];
            return Integer.toBinaryString(Integer.parseInt(s))+fText;
        }else {
            System.out.println("No point has");
            return Integer.toBinaryString(Integer.parseInt(x));
        }
    }

    private String floatToBinaryString( double n ) {
        String val = "";
        int i = 0;
        while ( n > 0 && i < 10) {
            double r = n * 2;
            if( r >= 1 ) {
                val += "1";
                n = r - 1;
            }else{
                val += "0";
                n = r;
            }
            i++;
        }
        return val;
    }

    public String getCarry(){
        return this.carry;
    }


}
