package leetcode.queue;

import java.util.*;

public class LeetCode387_FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));
        System.out.println(firstUniqChar(s3));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (char key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                return s.indexOf(key);
            }
        }

        return -1;
    }
}
