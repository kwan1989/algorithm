package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode232_ImplementQueueusingStacks {
    private List<Integer> stack;

    public LeetCode232_ImplementQueueusingStacks() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(0);
    }

    public int peek() {
        return stack.get(0);
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
