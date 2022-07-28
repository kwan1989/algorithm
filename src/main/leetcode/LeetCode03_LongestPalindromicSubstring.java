package leetcode;

public class LeetCode03_LongestPalindromicSubstring {

    static int resultStartIndex;
    static int resultLength;

    public static void main(String[] args) {

        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "ac";

        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i))
                    if (dp[i + 1][j - 1] || j - i == 1) {
                        dp[i][j] = true;
                    }
                if (dp[i][j] && j - i > end - start) {
                    end = j;
                    start = i;
                }
            }
        }
        System.out.println(s.substring(start, end + 1));
    }
}
