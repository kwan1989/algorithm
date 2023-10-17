package leetcode.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LeetCode50_Pow {

    public static void main(String[] args)
    {
//        System.out.println(myPow(2.00000, 1));
//        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }

//    public static double myPow(double x, int n)
//    {
//        BigDecimal base = BigDecimal.valueOf(x);
//
//        if (n < 0) {
//            base = BigDecimal.ONE.divide(base);
//            n = -n;
//        }
//        return base.pow(n).doubleValue();
//    }


    public static double myPow(double x, int n)
    {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return Math.pow(x,n);
    }
}
