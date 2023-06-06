package leetcode.etc;

public class LeetCode07_ReverseInteger {
    public static void main(String[] args) {
//        int x = 123;
        int x = -123;
//        int x = 120;
//        int x = 1534236469;

//        System.out.println(reverse(x));
        System.out.println(reverse_operation(x));
    }

    public static int reverse(int x) {
        return isNagative(x) ? toReverse(x) * -1 : toReverse(x);
    }

    private static boolean isNagative(int number) {
        return number < 0;
    }

    private static int toReverse(int number) {
        long val = Long.parseLong(new StringBuilder(Integer.toString(number).replace("-", "")).reverse().toString());

        if (val <= Integer.MAX_VALUE && val >= Integer.MIN_VALUE) {
            return (int) val;
        } else {
            return 0;
        }
    }

    public static int reverse_operation(int num) {

        long r = 0;

        while (num != 0) {
            // 현재값에 자리수를 증가하면서 현재값에서 해당 자리수의 나머지값을 더한다
            r = r * 10 + num % 10;
            num /= 10;

            System.out.println("r:" + r + " / num:" + num);
        }

        return (int) r;

    }

    public static int reverse_operation2(int num) {

        long curr = 0;

        while (num != 0) {
            curr = curr * 10 + num % 10;
            num /= 10;
        }

        return (int) curr;
    }

}
