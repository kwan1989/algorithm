package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290_WordPattern {

    public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";

        System.out.println(wordPattern(pattern1, s1));
        System.out.println(wordPattern(pattern2, s2));
        System.out.println(wordPattern(pattern3, s3));
        System.out.println(wordPattern(pattern4, s4));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] split = s.split("\\s");

        if (pattern.length() != split.length) {
            return false;
        }

        for (int i = 0; i < split.length; i++) {
            char c = pattern.charAt(i);

            if (map1.containsKey(c)) {
                if (!map1.get(c).equals(split[i])) {
                    return false;
                }
            } else if(map2.containsKey(split[i])){
                if (!map2.get(split[i]).equals(c)){
                    return false;
                }
            }else {
                map1.put(c, split[i]);
                map2.put(split[i], c);
            }
        }

        return true;
    }
}
