package leetcode.math;

public class LeetCode67_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // 100
        System.out.println(addBinary("1010", "1011")); // 10101
    }

    public static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLen; i++) {
            int bit1 = 0;
            int bit2 = 0;

            if (i < a.length()) {
                bit1 = Character.getNumericValue(a.charAt(a.length() - 1 - i));
            }

            if (i < b.length()) {
                bit2 = Character.getNumericValue(b.charAt(b.length() - 1 - i));
            }

            int sum = bit1 + bit2 + carry;

            sb.append(sum % 2);
            carry = sum/2;
        }

        if(carry > 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
