package leetcode.hashmap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode128_LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums3 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
        System.out.println(longestConsecutive(nums3));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int idx = 1;
            while (set.contains(nums[i] + idx)) {
                idx++;
            }
            max = Math.max(max, idx);
        }

        return max;
    }
}
