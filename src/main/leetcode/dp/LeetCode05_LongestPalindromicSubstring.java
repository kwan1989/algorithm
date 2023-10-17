package leetcode.dp;

public class LeetCode05_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        //String s = "cbbd";
//        String s = "ac";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String palindromeOdd = findPalindrome(s, i, i);
            String palindromeEven = findPalindrome(s, i, i + 1);


            if (result.length() < palindromeOdd.length()) {
                result = palindromeOdd;
            }

            if (result.length() < palindromeEven.length()) {
                result = palindromeEven;
            }

        }
        return result;
    }

    public static String findPalindrome(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}