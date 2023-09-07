package leetcode.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCdoe648_ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary1 = Arrays.asList("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";

        List<String> dictionary2 = Arrays.asList("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";

        List<String> dictionary3 = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence3 = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

//        System.out.println(replaceWords(dictionary1, sentence1));
//        System.out.println(replaceWords(dictionary2, sentence2));
        System.out.println(replaceWords(dictionary3, sentence3));
    }

    private static class TreeNode {
        boolean isEnd = false;
        StringBuilder startWithTemp = new StringBuilder();
        Map<Character, TreeNode> children = new HashMap<>();
    }

    private static TreeNode root = new TreeNode();

    public static String replaceWords(List<String> dictionary, String sentence) {
        root.children.clear();
        StringBuilder result = new StringBuilder();

        for (String s : dictionary) {
            insert(s);
        }
        String[] strSplit = sentence.split("\\s");

        for (String s : strSplit) {
            result.append(startWith(s));
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void insert(String word) {
        TreeNode node = root;
        node.startWithTemp.setLength(0);
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TreeNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public static String startWith(String word) {
        TreeNode node = find(word);

        if (node.isEnd) {
            return node.startWithTemp.toString();
        } else {
            return word;
        }
    }

    public static TreeNode find(String word) {
        TreeNode node = root;
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                break;
            }
            stringBuilder.append(c);
            node = node.children.get(c);

            if (node.isEnd) { // 단어의 끝에 도달한 경우
                node.startWithTemp.setLength(0); // 기존 값 초기화
                node.startWithTemp.append(stringBuilder); // 새로운 값 설정
                break;
            }

        }

        return node;
    }

}
