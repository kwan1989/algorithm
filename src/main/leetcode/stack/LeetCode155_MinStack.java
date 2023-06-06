package leetcode.stack;

public class LeetCode155_MinStack {

    public static void main(String[] args) {

    }

    private Node node;


    public void push(int val) {
        if (node == null) {
            node = new Node(val, val, null);
        } else{
            node = new Node(val, Math.min(val, node.min), node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

}
