package leetcode.stack;

import java.util.*;
import java.util.function.BiFunction;

public class LeetCode224_BasicCalculator {

    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "2147483647";
        String s5 = "  30";
        String s6 = "1-(     -2)";

        System.out.println(calculate(s1));
        System.out.println(calculate(s2));
        System.out.println(calculate(s3));
        System.out.println(calculate(s4));
        System.out.println(calculate(s5));
//        System.out.println(calculate(s6));        // 이 문제에서 터짐..

//        System.out.println(calculate1(s1));
//        System.out.println(calculate1(s2));
//        System.out.println(calculate1(s3));
//        System.out.println(calculate1(s4));
//        System.out.println(calculate1(s5));
//        System.out.println(calculate1(s6));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> operation = getOperation();

        String postfix = convertToPostfix(s);

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();

                stack.push(operation.get(String.valueOf(c)).apply(num1, num2));
            }
        }

        return postfix.length() == stack.size() ? Integer.valueOf(postfix) : stack.pop();
    }


    public static String convertToPostfix(String infix) {

        infix = removeSpaces(infix);

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {

                /**
                 * 만약 현재 문자가 닫는 괄호인 경우 (c == ')'),
                 * 스택이 비어있지 않고 스택의 top이 여는 괄호일 때까지 스택에서 pop하여 postfix에 추가합니다.
                 * 그리고 나서 여는 괄호를 제거하기 위해 한 번 더 pop을 수행합니다.
                 */
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                // 여는 괄호를 제거하기 위해 pop
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                /**
                 * 그 외의 경우, 즉 연산자인 경우입니다.
                 * 스택이 비어있지 않고, 스택의 top에 있는 연산자의 우선순위가 현재 연산자보다 크거나 같은 동안(top이 우선순위가 높거나 같은 동안)
                 * 스택에서 pop하여 postfix에 추가합니다. 그리고 나서 현재 연산자를 스택에 push합니다.
                 */
                while (!stack.isEmpty() && priority(stack.peek()) > priority(c)) {
                    postfix.append(stack.pop());
                }

                // 현재 연산자를 스택에 push
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static Map<String, BiFunction<Integer, Integer, Integer>> getOperation() {
        Map<String, BiFunction<Integer, Integer, Integer>> operation = new HashMap<>();
        operation.put("+", (a, b) -> a + b);
        operation.put("-", (a, b) -> a - b);
        operation.put("*", (a, b) -> a * b);
        operation.put("/", (a, b) -> a / b);

        return operation;
    }

    public static int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    public static String removeSpaces(String infix) {
        return infix.replaceAll("\\s", "");
    }


    /**
     * 리트코드 해답
     *
     * @param s
     * @return
     */
    public static int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);

                // Reset the temporary variables
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;

                // Pop the previous sign and result from the stack
                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result + (sign * num);
    }

}
