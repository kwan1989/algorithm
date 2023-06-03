package leetcode.etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode287_FindtheDuplicateNumber {
    public static void main(String[] args) {
//        int[] nums = {1,3,4,2,2};
        int[] nums = {3, 1, 3, 4, 2};

        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int reverse = nums.length - 1;

        for (int forward = 0; forward < nums.length / 2 + 1; forward++) {

            if (!set.add(nums[forward])) {
                return nums[forward];
            }

            if (!set.add(nums[reverse - forward])) {
                return nums[reverse - forward];
            }
        }

        return -1;
    }


    public static int findDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

}
