package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LeetCode383_RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for (char c : ransomNote.toCharArray()){
            if (map.containsKey(c)){
                if(map.get(c)-1 > 0){
                    map.put(c, map.get(c)-1);
                } else {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct_1(String ransomNote, String magazine) {
        Map<Character, Integer> map =new HashMap<>();

        for (char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (char c: ransomNote.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) -1);

                if (map.get(c) < 0){
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }


}
