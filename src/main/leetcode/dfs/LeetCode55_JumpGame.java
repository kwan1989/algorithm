package leetcode.dfs;


/**
 * https://leetcode.com/problems/jump-game/
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 * <p>
 * Success
 * Runtime: 149 ms, faster than 23.49% of Java online submissions for Jump Game.
 * Memory Usage: 40.7 MB, less than 21.14% of Java online submissions for Jump Game.
 */
public class LeetCode55_JumpGame {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        //int[] nums = {2, 3, 1, 1, 4};
        //int[] nums = {3, 2, 1, 0, 4};
        //int[] nums = {0};
        boolean result = canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        return dfs(nums, new boolean[nums.length], 0);
    }

    public static boolean dfs(int[] nums, boolean[] visited, int start) {

        if (start >= nums.length - 1) {
            return true;
        }

        visited[start] = true;

        for (int i = start + 1; i <= start + nums[start]; i++) {
            if (!visited[i] && dfs(nums, visited, i)) {
                return true;
            }
        }
        return false;
    }

}
