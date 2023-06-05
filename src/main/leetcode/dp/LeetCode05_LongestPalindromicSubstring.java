package leetcode.dp;

public class LeetCode05_LongestPalindromicSubstring {

    public static void main(String[] args) {
        //String s = "babad";
        //String s = "cbbd";
        String s = "ac";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String palindromeOdd = findPalindrome(s, i,i);
            String palindromeEven = findPalindrome(s, i,i+1);


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


//    public static String longestPalindrome(String s) {
//        if (s == null || s.length() < 2) {
//            return s;
//        }
//
//        String longest = "";
//
//        for (int i = 0; i < s.length(); i++) {
//            String palindrome = expandAroundCenter(s, i, i);
//
//            if (palindrome.length() > longest.length()) {
//                longest = palindrome;
//            }
//
//        }
//        return longest;
//    }
//
//    private static String expandAroundCenter(String s, int left, int right) {
//
//        // s 의 길이가 짝수인경우 [1,1,1,1] 중앙 시작점을 찾기 어렵다. 그러므로 우측열 +1
//        if(s.length() % 2 == 0){
//            right++;
//        }
//
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//
//        System.out.println(s.substring(left + 1, right));
//        return s.substring(left + 1, right);
//    }
}