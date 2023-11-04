package leetcode.twopointers;

import java.util.*;

public class LeetCode409_LongestPalindrome {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abccccdd"));
//        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindromeMap("bananas"));

//        System.out.println(longestPalindrome("ccc"));
//        System.out.println(longestPalindromeMap("ccc"));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) {
            return count * 2 + 1;
        }
        return count * 2;
    }

    public static int longestPalindromeMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        boolean hasOdd = false;
        for (int val : map.values()) {
            if (val % 2 == 0) {
                count += val;
            } else {
                count += (val / 2) * 2;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            count++;
        }

        return count;
    }
}
