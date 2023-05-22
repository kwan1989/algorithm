package leetcode.dfs;


public class LeetCode104_MaximumDepthofBinaryTree {

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
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);


        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if ( root == null){
            return 0;
        }

        return
                Math.max(
                        maxDepth(root.left),
                        maxDepth(root.right)
                ) + 1;
    }

}