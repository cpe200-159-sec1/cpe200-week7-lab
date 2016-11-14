package cpe200;

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
    private int bPoint = 0;

    public BinaryCalculator() {
        x = "0";
        y = "0";
    }

    public void setFirstOperand(IOperand operand) {
        System.out.println("x was to Setting is : "+operand.getOperand());
        x = getFloat(operand.getOperand(), 'x');
        System.out.println("Now x is :  "+x);
        firstOperand = operand;
    }

    public void setSecondOperand(IOperand operand) {
        System.out.println("y was to Setting is : "+operand.getOperand());
        y = getFloat(operand.getOperand(), 'y');
        System.out.println("Now x is :  "+y);
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
            return inSubtract(this.x, this.y);
        }else {
            throw new RuntimeException();
        }

    }

    public String multiply() throws RuntimeException {
        //Binary multiply
        //Step0 : initial
        String numbr;
        String multi;
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
        if(reFormmating(rePointting(this.x)).intValue() < 0 || reFormmating(rePointting(this.y)).intValue() < 0){
            throw new RuntimeException("Operand must not negative");
        }return inDivision(x ,y);

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
            return reFormmating(rePointting(now)).stripTrailingZeros().toString();
        }
    }

    private String chkBalance(String a, String b, int sel){
        a = String.format("%0"+b.length()+"d", Integer.parseInt(a));
        b = String.format("%0"+a.length()+"d", Integer.parseInt(b));
        System.out.println("Check Balance with selector");
        System.out.println("\t\tX is: "+this.x+" Y is: "+this.y);
        return (sel == 1)?a:b;
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

    private String inSubtract(String a, String b){
        System.out.println("---------Subst MODULE-------");
        a = chkBalance(a, b, 1);
        b = chkBalance(a, b, 2);
        String subr = new String();
        String borr =  new String("0");
        for (int i=a.length()-1;i>=0; i--){
            subr += Integer.parseInt(borr) //Bi ^ (x ^ y)
                    ^(
                    Integer.parseInt(Character.toString(a.charAt(i)))
                            ^Integer.parseInt(Character.toString(b.charAt(i)))
            );
            borr = Integer.toBinaryString( //~AB+Bi~(A^B)
                    (
                            Integer.parseInt(not(Character.toString(a.charAt(i))))
                                    &Integer.parseInt(Character.toString(b.charAt(i)))
                    )|(Integer.parseInt(borr)
                            &Integer.parseInt(not(
                            Integer.toBinaryString(
                                    Integer.parseInt(Character.toString(a.charAt(i)))
                                            ^Integer.parseInt(Character.toString(b.charAt(i)))
                            )
                            )
                    )
                    )
            );System.out.println("i"+i+") "+subr+" "+borr);

        }
        String ress = reFormmating(rePointting(subr)).stripTrailingZeros().toString();
        System.out.println("\tSubst result : "+ress);
        return ress;
    }

    private String inDivision(String a, String b){
        //String a = Integer.toBinaryString(Integer.parseInt("10"));
        //String b = Integer.toBinaryString(Integer.parseInt("3"));
        System.out.println("---------Division MODULE-------");
        int a_oldLength = a.length();
        int bLength = b.length();
        int step = bLength;
        int fillzero = 0;

        String divided = a;
        int c=1;int i=0;

        int tryDigit = 30;
        boolean tried = false;
        boolean toggle = true;

        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder("");
        StringBuilder reminder = new StringBuilder("");
        String next = "";
        String temp = "";

        ArrayList<String> remHistory = new ArrayList<String>();

        boolean req = false;


        while (divided.length() >= 0){
            System.out.println("--------- Long Division -------");
            if ((divided.length() <= b.length()+1) && tryDigit >=0){
                divided += "0";
                if (tryDigit <= 0){
                    break;
                }
                tryDigit--;
            }else {
                //Stack porcess
                temp = divided.subSequence(0, c).toString();
                next = divided.subSequence(c,c+1).toString();
                stack.append(temp);

                if(reminder.length() > 0){
                    //Has reminder

                    if(isMoreThan(reminder.toString(), b)){
                        //Reminder can divided by B
                        result.append("1");
                        String t = reminder.toString();
                        reminder.delete(0, reminder.length());
                        reminder.append(intTobinString(inSubtract(t, b)));
                        remHistory.add(reminder.toString());
                        /*if(remHistory.size() > 0){
                            if(reminder.toString().equals(remHistory.get(remHistory.size()-1).toString())){
                                //Is in lastest history
                                StringBuilder g = new StringBuilder(result.toString().subSequence(
                                        result.length()-(reminder.toString().length()-1), result.length()
                                )).reverse();
                                result.append(
                                        g
                                );
                                break;
                            }

                        }*/
                        if(reFormmating(reminder.toString()).intValue() <= 0 || tryDigit <= 0){
                            break;
                        }
                    }else {
                        //Reminder can't divided by B

                        //Add stack in reminder
                        reminder.append(stack.toString());

                        //Pattern of division
                        String testRem = reminder.toString()+next;
                        if (testRem.length() <= b.length()){
                            if(isMoreThan(testRem, b)){
                                result.append("");
                            }

                        }



                        c=1;
                    }

                    //Stack clear in has reminder
                    stack.delete(0,stack.length());
                    divided = divided.substring(c, divided.length());

                }else {
                    //has'nt reminder

                    if(isMoreThan(stack.toString(), b)){
                        //Stack can devided by b
                        result.append("1");

                        //Subtract a with b return reminder
                        reminder.append(intTobinString(inSubtract(stack.toString(), b)));
                        divided = divided.substring(c, divided.length());
                        c=1;
                    }else {
                        result.append("0");
                        c++;
                    }
                    stack.delete(0,stack.length());
                }

            }


        }
        System.out.println(reFormmating(result.toString()));
        System.out.println(result.toString());
        int dg  = result.toString().length() - a.length();
        return reFormmating(rePointting(result.toString(), dg)).setScale(5, BigDecimal.ROUND_UP).stripTrailingZeros().toString();
    }
    private boolean isMoreThan(String a, String b){
        //a is array of Number ex 11/aaa and b is divisor ex bb/111 (in long divisor format)
        boolean x = Double.parseDouble(a) >= Double.parseDouble(b);
        System.out.println("\t\t"+a+" isMoreThan "+b+": "+x);
        return x;
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

    private String getFloat(String x,char cX){
        //Covert String of Double to String of Binary Double without point
        if (x.contains(".")){
            double f = Double.parseDouble("0."+x.split("[.]")[1]);

            //Find float Length
            String fText = floatToBinaryString(f);
            if(cX == 'x'){
                xpointLength = fText.length();
            }else {
                ypointLength = fText.length();
            }

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

    private String intTobinString(String decimal){
        if(Integer.parseInt(decimal) >= 0){
            return Integer.toBinaryString(Integer.parseInt(decimal));
        }else {
            throw new ArithmeticException("NOt negative input");
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
    private String rePointting(String numbr, int digit){
        if(digit > 0){
            String sNum = numbr.substring(0, numbr.length()-digit);
            String sPoint = numbr.substring(numbr.length()-digit, numbr.length());
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
        BigDecimal res = new BigDecimal(result);
        System.out.println("\t\tReformmat input : "+result+" as "+res);
        return res;
    }

    public String getCarry(){
        return this.carry;
    }


}
