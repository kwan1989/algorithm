package leetcode.etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int duplicateCount = 0;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                duplicateCount++;
            } else {
                set.add(nums[i]);
                nums[idx++] = nums[i];
            }
        }
        return nums.length - duplicateCount;
    }

}