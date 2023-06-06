package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {

    private Queue<T> queue;

    public MyQueue(){
        queue = new LinkedList<>();
    }

    public void enqueue(T item){
        queue.add(item);
    }

    public T dequeue(){
        if (queue.isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }
        return queue.poll();
    }

    public T peek(){
        if (queue.isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
