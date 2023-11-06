package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
//        System.out.println(lengthOfLongestSubstring("bbbbb"));   // 1
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(left < s.length()){
            char c = s.charAt(left);
            if(!set.contains(c)){
                set.add(c);
                max = Math.max(max, set.size());
                left++;
            } else {
                set.remove(s.charAt(right));
                right++;
            }
        }
        return max;
    }
}
