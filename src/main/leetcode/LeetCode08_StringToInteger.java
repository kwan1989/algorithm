package leetcode;

public class LeetCode08_StringToInteger {

    public static void main(String[] args) {

        //int result = myAtoi("4193 with words");
        //int result = myAtoi("   -42");
        //int result = myAtoi("words and 987");
        int result = myAtoi("-91283472332");

        //int result = myAtoi("3.14159");
        //int result = myAtoi("-");
        //int result = myAtoi("+-12");

        //int result = myAtoi("  -0012a42");

        //int result = myAtoi("20000000000000000000");
        System.out.println(result);
    }

    public static int myAtoi(String s) {

        int result = 0;
        int i = 0;
        boolean isPositive = true;
        // skip all the space // 모든 공백 건너뛰기
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // Pick either + or - // + 또는 -를 선택
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            //isPositive = s.charAt(i) == '+' ? true: false;

            if ( s.charAt(i) == '+'){
                isPositive = true;
            } else{
                isPositive = false;
            }

            i++;
        }
        // Loop all the digital numbers // 모든 디지털 숫자를 루프
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digital = s.charAt(i++) - '0';

            if (isPositive && result <= (Integer.MAX_VALUE - digital)/10) {
                result = result * 10 + digital;

            } else if (!isPositive && result >= (Integer.MIN_VALUE + digital)/10) {
                result = result * 10 - digital;

            } else {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            }
        }
        return result;
    }
}
