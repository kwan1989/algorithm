package leetcode.math;

public class LeetCode68_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // 100
//        System.out.println(addBinary("1010","1011")); // 10101
    }

    public static String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int bit1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int bit2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
