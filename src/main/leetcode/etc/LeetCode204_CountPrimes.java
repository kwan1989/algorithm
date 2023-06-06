package leetcode.etc;

import java.util.Arrays;

public class LeetCode204_CountPrimes {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }

    public static int countPrimes(int n) {
        return findPrimes(n);
    }

    public static int findPrimes(int n) {

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;


        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    // Simple 많은 간격에서 타임아웃 간단하게 사용하기엔 좋음.
//    public static boolean isPrime(int n){
//        if (n < 2){
//            return false;
//        }
//
//        for (int i = 2 ; i<= Math.sqrt(n); i++){
//            if (n % i ==0){
//                return false;
//            }
//        }
//
//        return true;
//    }
}
