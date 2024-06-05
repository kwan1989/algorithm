package leetcode.stack;

import java.util.Stack;

public class LeetCode232_ImplementQueueusingStacks {
//    private List<Integer> stack;
//
//    public LeetCode232_ImplementQueueusingStacks() {
//        stack = new ArrayList<>();
//    }
//
//    public void push(int x) {
//        stack.add(x);
//    }
//
//    public int pop() {
//        return stack.remove(0);
//    }
//
//    public int peek() {
//        return stack.get(0);
//    }
//
//    public boolean empty() {
//        return stack.isEmpty();
//    }

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }


        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

}
