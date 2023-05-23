package leetcode.dfs;

public class LeetCode100_SameTree {

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
//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2);
//        p.right = new TreeNode(3);
//
//        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
//        q.right = new TreeNode(3);


//        TreeNode p = new TreeNode(1);
//        p.left = new TreeNode(2);
//        p.right = new TreeNode(1);
//
//        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(1);
//        q.right = new TreeNode(2);


        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q== null)
            return true;

        if (q == null || p == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

}
