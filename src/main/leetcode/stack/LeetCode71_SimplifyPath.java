package leetcode.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LeetCode71_SimplifyPath {

    public static void main(String[] args) {
//        String path = "/home/";
        String path = "/home//foo/";
//        String path = "/../";

        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        Set<String> exception = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String str : split) {
            if (!exception.contains(str)) {
                stack.push(str);
            } else if (str.equals("..") && !stack.empty()) {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();

        for (String str : stack) {
            result.append("/" + str);
        }

        return result.toString().isEmpty() ? "/" : result.toString();
    }
}
