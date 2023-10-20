package leetcode.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode205_IsomorphicStrings {

    public static void main(String[] args)
    {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) {
                    return false;
                }
            } else if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
