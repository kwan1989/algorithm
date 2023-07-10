package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1302_DeepestLeavesSum {

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        System.out.println(deepestLeavesSum(root));

    }


    public static int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            sum = 0;

            for (int i = 0; i< size; i++){
                TreeNode curr = queue.poll();
                sum += curr.val;

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }

        return sum;
    }
}
