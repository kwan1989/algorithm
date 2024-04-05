package leetcode.etc;

import java.util.HashSet;
import java.util.Set;

public class LeetCode03_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s3 = "aaaabaaaaaa";
        String s4 = "abb";

//        System.out.println(lengthOfLongestSubstring(s4));
//        System.out.println(lengthOfLongestSubstring_builder(s));
//        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));

        System.out.println(lengthOfLongestSubstring_1(s2));
    }

    public static int lengthOfLongestSubstring(String s) {
        int prev = 0;
        int idx = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        while (idx < s.length()) {

            char add = s.charAt(idx);

            if (set.add(add)) {
                max = Math.max(max, set.size());
                idx++;
            } else {
                set.remove(s.charAt(prev));
                prev++;
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring_builder(String s) {

        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (builder.indexOf(s.charAt(j) + "") != -1) {
                    break;
                }
                builder.append(s.charAt(j));
            }

            count = Math.max(count, builder.length());
            builder.setLength(0);
        }

        return count;
    }

    public static int lengthOfLongestSubstring_1(String s) {
        int left =0;
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
