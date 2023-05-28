package leetcode.dp;

public class LeetCode509_FibonacciNumber {

    public static void main(String[] args) {
        int n = 0;
        System.out.println(fib(n));
    }

    public static int fib(int n) {

        if (n==0){
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);

    }
}
