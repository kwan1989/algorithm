package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class LeetCode94_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        root.right = t1;
        t1.left = t2;

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public static void dfs(TreeNode root, List<Integer> res) {
        if (root != null) {

            // 전위
            if (root.left != null) {
                dfs(root.left, res);
            }

            /*
                중위
                전위 앞에 있으면 전위 표기법
                후위 뒤에 있으면 후위 표기법
             */
            res.add(root.val);

            // 후위
            if (root.right != null) {
                dfs(root.right, res);
            }

        }
    }
}
