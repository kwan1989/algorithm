package leetcode.etc;

public class LeetCode08_StringToInteger {

    public static void main(String[] args) {

        //int result = myAtoi("4193 with words");
        //int result = myAtoi("   -42");
        //int result = myAtoi("words and 987");
//        int result = myAtoi("-91283472332");

        //int result = myAtoi("3.14159");
        //int result = myAtoi("-");
        //int result = myAtoi("+-12");

        //int result = myAtoi("  -0012a42");

        //int result = myAtoi("20000000000000000000");
//        System.out.println(result);


//        System.out.println(myAtoi_retry("42"));
//        System.out.println(myAtoi_retry(" -42"));
//        System.out.println(myAtoi_retry("4193 with words"));
//        System.out.println(myAtoi_retry("words and 987"));
//        System.out.println(myAtoi_retry("-91283472332"));
//        System.out.println(myAtoi_retry("3.14159"));
//        System.out.println(myAtoi_retry("+-12"));

//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("words and 987"));

    }

    public static int myAtoi(String s) {
        boolean isNegative = s.contains("-");
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            int value = Character.getNumericValue(sb.charAt(sb.length() - i - 1));
            int digit = (int) Math.pow(10, i);
            result += value * digit;
        }

        return isNegative ? result * -1 : result;
    }

    public static int myAtoi_retry(String s) {
        s = s.trim();
        boolean isNegative = s.contains("-");
        boolean isNumberEnd = false;
        if (!checkedFirst(s)) {
            return 0;
        }


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
                isNumberEnd = true;
            } else if (isNumberEnd && !Character.isDigit(s.charAt(i))) {
                break;
            }
        }


        try {
            int result = Integer.parseInt(stringBuilder.toString());
            return isNegative ? -result : result;
        } catch (NumberFormatException e) {
            // 정수로 변환할 수 없는 경우
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static boolean checkedFirst(String s) {
        char first = s.charAt(0);

        if (Character.isDigit(first)) {
            return true;
        }

        if (first == '-' || first == '+') {
            return true;
        }

        return false;
    }

    public static int myAtoi1(String s) {

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

            if (s.charAt(i) == '+') {
                isPositive = true;
            } else {
                isPositive = false;
            }

            i++;
        }
        // Loop all the digital numbers // 모든 디지털 숫자를 루프
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digital = s.charAt(i++) - '0';

            if (isPositive && result <= (Integer.MAX_VALUE - digital) / 10) {
                result = result * 10 + digital;

            } else if (!isPositive && result >= (Integer.MIN_VALUE + digital) / 10) {
                result = result * 10 - digital;

            } else {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            }
        }
        return result;
    }
}
