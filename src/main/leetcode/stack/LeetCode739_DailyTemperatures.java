package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode739_DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }


    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int preIdx = stack.pop();
                int diffIdx = i - preIdx;
                result[preIdx] = diffIdx;
            }
            stack.push(i);
        }

        return result;
    }
}
