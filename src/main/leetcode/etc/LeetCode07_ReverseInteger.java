package leetcode.etc;

public class LeetCode07_ReverseInteger
{
    public static void main(String[] args)
    {
//        int x = 123;
//        int x = -123;
//        int x = 120;
        int x = 1534236469;

        System.out.println(reverse(x));
    }

    public static int reverse(int x)
    {
        return isNagative(x) ? toReverse(x) * -1 : toReverse(x);
    }

    private static boolean isNagative(int number)
    {
        return number < 0;
    }

    private static int toReverse(int number)
    {
        long val = Long.parseLong(new StringBuilder(Integer.toString(number).replace("-", "")).reverse().toString());

        if ( val <= Integer.MAX_VALUE && val>= Integer.MIN_VALUE){
            return (int) val;
        } else {
            return 0;
        }
    }
}
