package leetcode.hashmap;

import java.util.ArrayList;
import java.util.List;

public class LeetCode202_HappyNumber {

    public static void main(String[] args) {
//        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);

            if (fast == 1){
                return true;
            }
        } while (slow != fast);

        return false;
    }

    private static int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
