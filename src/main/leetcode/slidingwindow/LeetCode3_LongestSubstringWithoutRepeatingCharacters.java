package leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
//        System.out.println(lengthOfLongestSubstring("bbbbb"));   // 1
    }

    public static int lengthOfLongestSubstring(String s) {
        int idx = 0;
        int del = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if(!set.contains(c)){
                set.add(c);
                max = Math.max(max, set.size());
                idx++;
            } else {
                set.remove(s.charAt(del));
                del++;
            }
        }
        return max;
    }
}
