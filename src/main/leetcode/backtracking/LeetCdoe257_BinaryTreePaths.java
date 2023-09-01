package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCdoe257_BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        dfs(root, new StringBuilder(), paths);
        return paths;
    }

    private static void dfs(TreeNode node, StringBuilder sb, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(sb.append(node.val).toString());
            sb.setLength(sb.length() - String.valueOf(node.val).length());
            return;
        }

        sb.append(node.val);
        sb.append("->");

        int length = sb.length();

        if (node.left != null) {
            dfs(node.left, sb, paths);
            sb.setLength(length);
        }
        if (node.right != null) {
            dfs(node.right, sb, paths);
            sb.setLength(length);
        }
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
