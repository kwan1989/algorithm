package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    private List<T> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek(){
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

}
