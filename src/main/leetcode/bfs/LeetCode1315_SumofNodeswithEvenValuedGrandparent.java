package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1315_SumofNodeswithEvenValuedGrandparent {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        System.out.println(sumEvenGrandparent(root));
    }

    public static int sumEvenGrandparent(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();

            if (isEven(curr.val)) {
                if (curr.left != null) {
                    if (curr.left.left != null) {
                        sum += curr.left.left.val;
                    }
                    if (curr.left.right != null) {
                        sum += curr.left.right.val;
                    }
                }

                if (curr.right != null) {
                    if (curr.right.left != null) {
                        sum += curr.right.left.val;
                    }
                    if (curr.right.right != null) {
                        sum += curr.right.right.val;
                    }
                }
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        return sum;
    }

    public static boolean isEven(int val) {
        return val % 2 == 0;
    }
}
