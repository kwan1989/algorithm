package leetcode.dfs;

public class LeetCode226_InvertBinaryTree {

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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root = swap(root);

        System.out.println(root.val);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static TreeNode swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

}