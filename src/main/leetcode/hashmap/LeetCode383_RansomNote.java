package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeetCode383_RansomNote {

    public static void main(String[] args) {
        String ransomNote1 = "a";
        String magazine1 = "b";

        String ransomNote2 = "aa";
        String magazine2 = "ab";

        String ransomNote3 = "aa";
        String magazine3 = "aab";

        System.out.println(canConstruct(ransomNote1, magazine1));
        System.out.println(canConstruct(ransomNote2, magazine2));
        System.out.println(canConstruct(ransomNote3, magazine3));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapMagazine = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            mapMagazine.put(c, mapMagazine.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!mapMagazine.containsKey(c) || mapMagazine.get(c) == 0) {
                return false;
            } else {
                mapMagazine.put(c, mapMagazine.get(c) - 1);
            }
        }

        return true;
    }
}
