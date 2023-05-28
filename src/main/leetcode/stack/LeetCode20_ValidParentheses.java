package leetcode.stack;

import java.util.Stack;

public class LeetCode20_ValidParentheses {

    public static void main(String[] args) {
//        String s = "(]";
//        String s = "()[]{}";
        String s = "]";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c== '(' || c =='{' || c == '['){
                stack.push(c);
            } else {

                if (stack.empty()){
                    return false;
                }

                if ( c== ')' && stack.peek() == '(') {
                    stack.pop();
                } else if ( c== '}' && stack.peek() == '{') {
                    stack.pop();
                }else if ( c== ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
