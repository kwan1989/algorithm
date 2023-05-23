package leetcode.etc;

import java.util.Arrays;

public class LeetCode14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = deleteSuffix(pre);
            }
            System.out.println(pre);
            i++;
        }
        return pre;
    }

    public static String deleteSuffix(String str) {
        return str.substring(0, str.length() - 1);
    }
}
