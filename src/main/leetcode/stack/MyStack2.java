package leetcode.stack;

public class MyStack2<T> {

    private Object[] stack;
    private int top;
    private int capacity;

    public MyStack2(int capacity) {
        this.capacity = capacity;
        stack = new Object[capacity];
        top = -1;
    }

    public void push(T item) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) stack[top];
        stack[top--] = null;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

}
