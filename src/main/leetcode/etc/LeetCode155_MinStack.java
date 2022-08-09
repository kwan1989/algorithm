package leetcode.etc;

import java.util.Stack;

public class LeetCode155_MinStack {

     int min;
     Stack<Integer> stack;

    public LeetCode155_MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }


    public  void push(int val) {
        if (val<=min){
            stack.push(val);
            min = val;
        }
        stack.push(val);
    }

    public  void pop() {
        if (stack.pop() ==min){
            min = stack.pop();
        }
    }

    public  int top() {
        return stack.peek();
    }

    public  int getMin() {
        return min;
    }

//    public static void main(String[] args) {
//        min = Integer.MAX_VALUE;
//        stack = new Stack<>();
//    }
}
