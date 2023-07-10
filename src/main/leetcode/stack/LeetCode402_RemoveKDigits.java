package leetcode.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class LeetCode402_RemoveKDigits {

    public static void main(String[] args) {
        // 1219
        String num1 = "1432219";
        int k1 = 3;

        // 200
        String num2 = "10200";
        int k2 = 1;

        // 0
        String num3 = "10";
        int k3 = 2;

        System.out.println(removeKdigits(num1, k1));
        System.out.println(removeKdigits(num2, k2));
        System.out.println(removeKdigits(num3, k3));

    }

    public static String removeKdigits(String num, int k) {

        if (num.length() == k) {
            return "0";
        }

        // 스택 팝을 정상적으로 사용 하는 경우
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int chaNumber = num.charAt(i) - '0';

            while (k != 0 && !stack.isEmpty() && stack.peek() > chaNumber) {
                stack.pop();
                k--;
            }
            stack.push(chaNumber);

        }

        // 전체 순환을 했음에도 k 가 0보다 클 경우
        while (k != 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // 스택을 꺼내와서 뒷자리 0을 전체 제거한 뒤, 리버스 반환
        // 예) 0200 -> 0020 -> 002 -> 200
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

}



