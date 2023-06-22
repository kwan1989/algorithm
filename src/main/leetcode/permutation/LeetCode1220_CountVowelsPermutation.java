package leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1220_CountVowelsPermutation {

    public static void main(String[] args) {
        int n = 144;
        System.out.println(countVowelPermutation(n));
    }

    public static int countVowelPermutation(int n) {
        final char[] characters = {'a', 'e', 'i', 'o', 'u'};
        List<List<Character>> result = new ArrayList<>();

        permutation(characters, new ArrayList<>(), result, n);

        printResult(result);

        return result.size();
    }

    /**
     * 아래 순열로는 n = 144 / timeOut 발생 dp로 풀어야..
     * @param characters
     * @param curr
     * @param result
     * @param length
     */
    public static void permutation(char[] characters,
                                   List<Character> curr,
                                   List<List<Character>> result,
                                   int length) {
        if (curr.size() == length) {
            if (nextCharChecker(curr)) {
                result.add(new ArrayList<>(curr));
            }
        } else {
            for (char character : characters) {
                curr.add(character);
                permutation(characters, curr, result, length);
                curr.remove(curr.size() - 1);
            }
        }
    }

    /**
     * 모음 'a'는 'e'로만 뒤에 올 수 있습니다.
     * 모음 'e'는 'a' 또는 'i'로만 뒤에 올 수 있습니다.
     * 모음 'i'는 다른 'i'가 뒤에 올 수 없습니다.
     * 모음 'o'는 'i' 또는 'u'로만 뒤에 올 수 있습니다.
     * 모음 'u'는 'a'로만 뒤에 올 수 있습니다.
     *
     * @param curr
     * @return
     */
    public static boolean nextCharChecker(List<Character> curr) {
        for (int i = 0; i < curr.size() - 1; i++) {
            char curChar = curr.get(i);
            char nextChar = curr.get(i + 1);

            if ((curChar == 'a' && nextChar != 'e')
                    || (curChar == 'e' && nextChar != 'a' && nextChar != 'i')
                    || (curChar == 'i' && nextChar == 'i')
                    || (curChar == 'o' && nextChar != 'i' && nextChar != 'u')
                    || (curChar == 'u' && nextChar != 'a')) {
                return false;
            }
        }

        return true;
    }

    public static void printResult(List<List<Character>> result) {
        for (List<Character> list : result) {
            System.out.print("[");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
