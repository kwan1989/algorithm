package leetcode.etc;

import java.math.BigInteger;

public class LeetCode172_FactorialTrailingZeroes {

    public static void main(String[] args) {
        int n = 7021;
        System.out.println(trailingZeroes(n));
    }
    public static int trailingZeroes(int n) {
        int result = 0;

        while (n >0){
            n /= 5;
            result += n;
        }
        return result;
    }

    /**
     * 5! = 120
     * 10! = 3628800
     * 15! = 1307674368000
     *
     * 순차적으로 증가하는 가 싶었지만 25!에서 Trailing Zeroes 갯수는 5가 아니라 6이다.
     * 이를 어떻게 규칙으로 만들 수 있을까?
     * 나눗셈을 한번 더 적용하면 된다.
     *
     * 25/5 = 5 여기서 5를 한번 더 나누면 5/5 = 1이다.
     * 총 5+1로 6을 찾아낼 수 있다.
     *
     * 50!으로해봐도 동일한 결과가 나온다.
     *
     * 즉 규칙은 n이 0보다 클때까지 계속 5로 나누어주는 것이다.
     * 그리고 몫을 누적한 값을 리턴하면 된다.
     *
     * 팩토리얼	Trailing Zeroes갯수
     * 5!	            1
     * 10!	            2
     * 15!	            3
     * 20!	            4
     * 24!	            4
     * 25!	            6
     * 25!	            6
     * 30!	            7
     * 50!	            12
     */

    // 실패 케이스
//    public static int trailingZeroes(int n) {
//
//        BigInteger factorialVal = factorial(n);
//
//        int result = 0;
////        BigInteger ten = BigInteger.TEN;
////        while (factorialVal.mod(ten) == BigInteger.ZERO && factorialVal != BigInteger.ZERO) {
////            result++;
////            factorialVal = factorialVal.divide(ten);
////        }
//
//        String factorial = factorialVal.toString();
//
//        for (int i = factorial.length() - 1; i >= 0; i--) {
//            if (factorial.charAt(i) == '0'){
//                result++;
//            } else{
//                break;
//            }
//        }
//
//
//        return result;
//    }
//
//    public static BigInteger factorial(int n) {
//        if (n <= 1) {
//            return BigInteger.ONE;
//        }
//
//        BigInteger result = BigInteger.valueOf(n);
//        return result.multiply(factorial(n - 1));
//    }
}
