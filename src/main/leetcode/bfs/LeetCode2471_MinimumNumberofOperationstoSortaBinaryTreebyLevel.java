package leetcode.bfs;

import java.util.*;

public class LeetCode2471_MinimumNumberofOperationstoSortaBinaryTreebyLevel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        System.out.println(minimumOperations(root));
        System.out.println(minimumOperations_new(root));
    }

    public static int minimumOperations_new(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> depthList = new ArrayList<>();

            for (int i = 0; i< size; i++){
                TreeNode curr = queue.poll();
                depthList.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            count += getSortSwapCount(depthList);
        }
        return count;
    }

    public static int getSortSwapCount (List<Integer> depthList){
        List<Integer> depthListSort = new ArrayList<>(depthList);
        int count = 0;

        for (int i = 0; i < depthListSort.size()-1; i++){
            int min = Collections.min(depthListSort.subList(i+1, depthListSort.size()));

            if (depthListSort.get(i) > min){
                int minIdx = depthListSort.indexOf(min);
                int temp = depthListSort.get(i);
                depthListSort.set(i, min);
                depthListSort.set(minIdx, temp);

                count++;
            }
        }
        return count;
    }

    public static int minimumOperations(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int swapCount = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int[] depthList = new int[size];
            int depthListIdx = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                depthList[depthListIdx++] = curr.val;

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            swapCount += sortAndCountSwaps(depthList);
        }

        return swapCount;
    }


    // Selection Sort
    public static int sortAndCountSwaps(int[] arr) {
        int swapCount = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // 최소값 인덱스 찾기
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // 최소값이 현재 인덱스에 있는 값보다 작으면 스왑
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;

                swapCount++;
            }
        }

        return swapCount;
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
