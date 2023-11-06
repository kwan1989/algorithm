package leetcode.bfs;

import java.util.List;

public class LeetCode102_BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        List<List<Integer>> result = new ArrayList<>();
//        while(!queue.isEmpty()){
//
//            int size = queue.size();
//            List<Integer> depthList = new ArrayList<>();
//
//            for (int i = 0; i < size; i++){
//                TreeNode curr = queue.poll();
//                depthList.add(curr.val);
//
//                if(curr.left != null){
//                    queue.offer(curr.left);
//                }
//
//                if(curr.right != null){
//                    queue.offer(curr.right);
//                }
//
//            }
//            result.add(depthList);
//        }
//        return result;
//    }
}
