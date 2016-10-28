package test;

/**
 * Created by ather on 26/10/2559.
 */
public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        int quotient = 0;
        int a = 300;
        int b = 5;
        int bfirst = b;
        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        int aLength = a1.length();
        int bLength = b1.length();
        int power = aLength - bLength;
        b =(int) (b * Math.pow(2, power));
        System.out.println(aLength + " " + bLength + " " + power);

        while(a >= bfirst) {
           // System.out.print(a + " ");
            //System.out.print(b + " ");
            //System.out.println(quotient);
            if(a >= b) {
                aLength = Integer.toBinaryString(a).length();
                bLength = Integer.toBinaryString(b).length();
                int bfirstLength = Integer.toBinaryString(bfirst).length();
                a = a-b;
                System.out.println("rrr"+a);
                quotient = quotient*2+1;
                b = b/2;
                if (a < bfirst) {
                    quotient = quotient * (int)Math.pow(2, bLength - bfirstLength);
                }
            } else {
                quotient = quotient*2;
                b = b/2;
            }
        }
        System.out.println(quotient);

    }

}
