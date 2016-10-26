package cpe200;

import com.sun.deploy.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by ather on 25/10/2559.
 */
public class BinaryCalculator {
    private IOperand firstOperand;
    private IOperand secondOperand;

    private String x;
    private String y;
    private String carry;

    private int xpointLength = 0;
    private int ypointLength = 0;

    public BinaryCalculator() {
        x = "0";
        y = "0";
    }

    public void setFirstOperand(IOperand operand) {
        System.out.println("x was to Setting is : "+operand.getOperand());
        x = getFloat(operand.getOperand());
        //System.out.println(getFloat("3"));
        //System.out.println(rePointting("1000"));
        System.out.println("Now x is :  "+x);
        firstOperand = operand;
    }

    public void setSecondOperand(IOperand operand) {
        System.out.println("y was to Setting is : "+operand.getOperand());
        y = getFloat(operand.getOperand());
        secondOperand = operand;
    }

    public String add() throws RuntimeException {
        //Full Adder
        //Always Check balance if use Addition
        chkBalance();
        return inAdder(this.x, this.y);
    }

    public String subtract() throws RuntimeException {
        //full Subtract
        if(reFormmating(firstOperand.getOperand()).floatValue() >= 0){
            System.out.println("---------Subst MODULE-------");
            chkBalance();
            String subr = new String();
            String borr =  new String("0");
            for (int i=this.x.length()-1;i>=0; i--){
                subr += Integer.parseInt(borr) //Bi ^ (x ^ y)
                        ^(
                            Integer.parseInt(Character.toString(x.charAt(i)))
                            ^Integer.parseInt(Character.toString(y.charAt(i)))
                        );
                borr = Integer.toBinaryString( //~AB+Bi~(A^B)
                        (
                            Integer.parseInt(not(Character.toString(x.charAt(i))))
                            &Integer.parseInt(Character.toString(y.charAt(i)))
                        )|(Integer.parseInt(borr)
                                &Integer.parseInt(not(
                                            Integer.toBinaryString(
                                            Integer.parseInt(Character.toString(x.charAt(i)))
                                            ^Integer.parseInt(Character.toString(y.charAt(i)))
                                            )
                                        )
                                )
                            )
                    );System.out.println("i"+i+") "+subr+" "+borr);

            }
            String ress = reFormmating(rePointting(subr)).stripTrailingZeros().toString();
            System.out.println("\tSubst result : "+ress);
            return ress;

        }else {
            throw new RuntimeException();
        }

    }

    public String multiply() throws RuntimeException {
        //Binary multiply
        //Step0 : initial
        String numbr = new String();
        String multi = new String();
        System.out.println("---------multiply MODULE-------");
        //Step1 : Digit to loop count
        boolean isX = firstOperand.getOperand().equals(
                maxOperand(firstOperand.getOperand(),
                        secondOperand.getOperand()));
        //Switch for length counter , we know "numbr" always largest
        if(isX){
            numbr = x;
            multi = y;
        }else {
            numbr = y;
            multi = x;
        }
        int counter = multi.length();

        //Step2 : Loop and get Array of result
        ArrayList<String> arrSum = new ArrayList<String>();
        StringBuilder sumInLine = new StringBuilder();
        for(int i=multi.length()-1; i >= 0 ; i--){
            for (int j=numbr.length()-1; j>=0; j--){
                sumInLine.insert(0,Integer.parseInt(Character.toString(numbr.charAt(j)))
                        &Integer.parseInt(Character.toString(multi.charAt(i)))) ;
            }//System.out.println(sumInLine);
            arrSum.add(String.format("%-"+(multi.length()+(multi.length()-(i+1)))+"s", sumInLine).replace(' ','0'));
            sumInLine.delete(0,sumInLine.length());
        }
        //System.out.println(arrSum.get(0));

        //Step3 : Loop sum of Result
        return arrayAdder(arrSum);
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
        System.out.println("\t\tX is: "+this.x+" Y is: "+this.y);
    }

    public ArrayList<String> chkBalance(String x, String y) throws RuntimeException{
        x = String.format("%0"+y.length()+"d", Integer.parseInt(x));
        y = String.format("%0"+x.length()+"d", Integer.parseInt(y));
        System.out.println("case Check Balance");
        System.out.println("\t\tX is: "+x+" Y is: "+y);
        ArrayList<String> res = new ArrayList<>();
        res.add(x);
        res.add(y);
        System.out.println("\t\tX is: "+res.get(0)+" Y is: "+res.get(1)+" (arr)");
        return res;
    }

    public String one_complement(String base) throws RuntimeException{
        String res = new String();
        for (int i=0;i<base.length();i++){
            res += (base.charAt(i) == '0')?"1":"0";
        }
        return res;
    }
    private String arrayAdder(ArrayList<String> arr){
        if(arr.size() <= 1){
            return arr.get(0);
        }else {
            ArrayList<String> chk;
            String now = "0";
            for(int i=0; i<arr.size();i++){
                chk = chkBalance(now,arr.get(i));
                System.out.println("\tArray at i: "+arr.get(i));
                now = Integer.toBinaryString(Integer.parseInt(inAdder(chk.get(0), chk.get(1))));
                System.out.println("\tNow: "+now);
            }
            return Integer.toString(Integer.parseInt(now,2));
        }


    }

    private String inAdder(String x, String y){
        System.out.println("---------ADD MODULE-------");
        String sum = new String();

        StringBuilder sums = new StringBuilder();
        String carry = new String("0");
        System.out.println("\tX is: "+x+" Y is: "+y);
        for (int i=x.length()-1;i>=0;i--){

            sum = Integer.toString(
                    Integer.parseInt(Character.toString(y.charAt(i)))
                            ^(Integer.parseInt(Character.toString(x.charAt(i)))
                            ^Integer.parseInt(carry))
            );
            sums.append(sum);
            carry = Integer.toString(
                    (Integer.parseInt(Character.toString(y.charAt(i)))
                            &Integer.parseInt(Character.toString(x.charAt(i))))
                            |Integer.parseInt(carry)&
                            (Integer.parseInt(Character.toString(y.charAt(i)))
                                    ^Integer.parseInt(Character.toString(x.charAt(i))))
            );
        }

        this.carry = carry;
        String repoint = rePointting(carry+sums.reverse().toString());
        System.out.println("\tAddition rePoint: "+repoint);
        String ress = reFormmating(repoint).stripTrailingZeros().toString();
        System.out.println("\taddition result : "+ress);
        return ress;
    }

    private String maxOperand(String a, String b){
        if(reFormmating(a).doubleValue() > reFormmating(b).doubleValue()){
            return a;
        }else {
            //Dont worry in cast equal more than
            return b;
        }
    }

    private String not(String b){
        return (b.equals("1"))?"0":"1";
    }

    private String getFloat(String x){
        //Covert String of Double to String of Binary Double without point
        if (x.contains(".")){
            double f = Double.parseDouble("0."+x.split("[.]")[1]);

            //Find float Length
            String fText = floatToBinaryString(f);
            xpointLength = fText.length();
            String s = x.split("[.]")[0];

            String re = Integer.toBinaryString(Integer.parseInt(s))+fText;
            System.out.println("\tYes has point : "+re);
            return re;
        }else {
            String re = Integer.toBinaryString(Integer.parseInt(x));
            System.out.println("\tNo hasnt point : "+re);
            return re;
        }
    }

    private String binaryToIntergerString(String binary){
        return rePointting(binary);
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
        return (val.equals(""))?"0":val;
    }

    private String rePointting(String numbr){
        if(xpointLength > 0){
            String sNum = numbr.substring(0, numbr.length()-xpointLength);
            String sPoint = numbr.substring(numbr.length()-xpointLength, numbr.length());
            String n = Integer.toString(Integer.parseInt(sNum,2));
            String p = Integer.toString(Integer.parseInt(sPoint,2));
            //Result of p.n is Double
            System.out.println("\t\tRepoint : "+n+"."+p);
            //return to Decimal with float
            return n+"."+p;
        }else {
            System.out.println("\t\t\tIn rePoint not rePoint : "+numbr);
            String n = Integer.toString(Integer.parseInt(numbr,2));
            System.out.println("\t\tNot repoint : "+n);
            //Return to decimal
            return n;
        }
    }

    private BigDecimal reFormmating(String result){
        System.out.println("\t\tReformmat input : "+result);
        BigDecimal res = new BigDecimal(result);
        return res;
    }

    public String getCarry(){
        return this.carry;
    }


}
