package leetcode.queue;

public class MyQueue2<T> {

    private Object[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public MyQueue2(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
