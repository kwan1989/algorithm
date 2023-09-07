package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class LeetCode208_ImplementTrie {

    class TrieNode {
        boolean isEnd = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }
    TrieNode root;

    public LeetCode208_ImplementTrie(){
        root = new TrieNode();
    }

    public static void main(String[] args) {
        LeetCode208_ImplementTrie temp = new LeetCode208_ImplementTrie();

        String word1 = "TEST";

        temp.insert(word1);
        System.out.println(temp.startsWith("TE"));
        System.out.println(temp.search(word1));
    }


    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        if (node == null || !node.isEnd) {
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null;
    }

    private TrieNode findNode(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }

}
