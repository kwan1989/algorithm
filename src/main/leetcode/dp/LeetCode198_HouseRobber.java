package leetcode.dp;

public class LeetCode198_HouseRobber {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            System.out.println(dp[i]);
        }

        return dp[nums.length - 1];

    }

//    public static int rob(int[] nums) {
//
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int now = 0;
//        int last = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            int temp = last;
//            last = now;
//            System.out.println(now);
//            now = Math.max(now, nums[i] + temp);
//        }
//        return now;
//    }
}
