package leetcode.stack;

import java.util.*;
import java.util.function.BiFunction;

/**
 * 후위표기식 -> 연산
 */
public class LeetCode150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"18"};

        System.out.println(evalRPN(tokens1));
        System.out.println(evalRPN(tokens2));
        System.out.println(evalRPN(tokens3));
    }

    public static int evalRPN(String[] tokens) {

        if (tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }

        Map<String, BiFunction<Integer, Integer, Integer>> operators = getOperators();
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (int i = 0; i < tokens.length; i++) {
            if (!set.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();

                result = operators.get(tokens[i]).apply(num1,num2);
                stack.push(result);
            }
        }

        return result;
    }


    public static Map<String, BiFunction<Integer, Integer, Integer>> getOperators() {
        Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> (a + b));
        operators.put("-", (a, b) -> (a - b));
        operators.put("*", (a, b) -> (a * b));
        operators.put("/", (a, b) -> (a / b));

        return operators;
    }


}
