package leetcode.hashmap;

import java.util.*;

public class LeetCode49_GroupAnagram {

    public static void main(String[] args) {
        String[] str1 = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(str1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
