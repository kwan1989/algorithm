package leetcode.bfs;

import java.util.*;

public class LeetCode993_CousinsinBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        int x = 4;
        int y = 3;

        System.out.println(isCousins(root, x, y));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {

        final int X = 0;
        final int Y = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int[] depth = new int[queue.size()];
            int depthIdx = 0;
            boolean[] findXY = new boolean[2];

            for (int i = 0; i < depth.length; i++) {
                TreeNode curr = queue.poll();
                depth[depthIdx++] = curr.val;

                if (curr.left != null) {
                    if (curr.left.val == x){
                        findXY[X] = true;
                    }

                    if (curr.left.val == y){
                        findXY[Y] = true;
                    }
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    if (curr.right.val == x){
                        findXY[X] = true;
                    }

                    if (curr.right.val == y){
                        findXY[Y] = true;
                    }
                    queue.offer(curr.right);
                }

                if (curr.left != null && curr.right != null){
                    if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }
                }
            }

            System.out.println(Arrays.toString(depth));

            if (findXY[X] && findXY[Y]){
                return true;
            }
        }
        return false;
    }


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
}
