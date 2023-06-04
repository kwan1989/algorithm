package leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * <p>
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * <p>
 * <p>
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * <p>
 * <p>
 * Success
 * Runtime: 125 ms, faster than 5.09% of Java online submissions for Word Break.
 * Memory Usage: 39.3 MB, less than 55.86% of Java online submissions for Word Break.
 */
public class LeetCode139_WordBreak {

    public static void main(String[] args) {
        // TC-1
//        String s = "leetcode";
//        List<String> wordDict   String s = "leetcode";

        String s = "cars";
        List<String> wordDict = Arrays.asList("car", "ca", "rs");


        // TC-2
        //String s = "applepenapple";
        //List<String> wordDict = Arrays.asList("apple","pen");

//        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak_retry(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        // dp
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 문자열 검색
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(j + " | " + i);

                // 마지막 값이 true 후, 이어지는 값이 해당 문자열에 포함되어 있다면 마지막 dp 인덱스 true
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    System.out.println("[dp[j(" + j + ")] : " + dp[j] + "]  [s.substring[j(" + j + "), i(" + i + ")] : " + s.substring(j, i) + "]");
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static boolean wordBreak_retry(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[s.length()];
    }
}
