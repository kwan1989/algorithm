package leetcode.twopointers;

public class LeetCode53_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};
        int[] nums4 = {-2, 1};
        int[] nums5 = {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        int[] nums6 = {-1, -2};
        int[] nums7 = {1, 2};

        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
        System.out.println(maxSubArray(nums5));
        System.out.println(maxSubArray(nums7));
    }


    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int currSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            sum = Math.max(sum, currSum);
        }
        return sum;
    }

    public static int maxSubArray3(int[] nums) {
        int sum = nums[0];
        int currSum = nums[0];

        for (int i = 1 ; i< nums.length; i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            sum = Math.max(sum, currSum);
        }

        return sum;
    }

    public static int maxSubArray2(int[] nums) {
        int idx = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        if (nums.length == 1) {
            return nums[0];
        }

        while (idx < nums.length) {

            if (sum < 0 && nums[idx] >= sum){
                sum = 0;
            }
            sum += nums[idx];
            max = Math.max(max, sum);
            idx++;

        }

        return max;
    }


    public static int maxSubArray1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int max = Integer.MIN_VALUE;

        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            int sum = getSum(nums, left, right);
            max = Math.max(max, sum);

            System.out.println(max + "/" + left + "/" + right);

            if (sum < nums[right]) {
                left++;
            } else {
                right--;
            }

        }

        return max;
    }

    public static int getSum(int[] nums, int start, int end) {
        if (isBetween(nums, start) && isBetween(nums, end)) {
            int sum = 0;

            for (int i = start; i <= end; i++) {
                sum += nums[i];
            }

            return sum;
        }
        return -1;
    }


    public static boolean isBetween(int[] nums, int index) {
        return index >= 0 && index < nums.length;
    }

}
