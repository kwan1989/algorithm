package leetcode.hashmap;

import java.util.*;

public class LeetCode692_TopKFrequentWords {

    public static void main(String[] args) {
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;


        System.out.println(topKFrequent(words1, k1));
        System.out.println(topKFrequent(words2, k2));

    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        return keySet.subList(0,k);
    }



}
