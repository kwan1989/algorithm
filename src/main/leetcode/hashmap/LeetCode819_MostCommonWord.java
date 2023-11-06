package leetcode.hashmap;

import java.util.*;

public class LeetCode819_MostCommonWord {

    public static void main(String[] args) {
//        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?',;.]"," ");
        Map<String, Integer> map = new HashMap<>();
        String[] split = paragraph.split("\\s");
        for (String str : split) {
            String replace = getString(str);
            if (!isBanned(banned, replace) && !replace.isEmpty()) {
                map.put(replace, map.getOrDefault(replace, 0) + 1);
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (v1, v2) -> map.get(v2).compareTo(map.get(v1)));

        for (String key : keys) {
            return key;
        }
        return paragraph;
    }

    public static String getString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }

    public static boolean isBanned(String[] banned, String str) {
        for (String ban : banned) {
            if (ban.equals(str)) {
                return true;
            }
        }
        return false;
    }


}
