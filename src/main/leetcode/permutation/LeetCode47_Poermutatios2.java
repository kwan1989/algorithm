package leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class LeetCode47_Poermutatios2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutation(nums, used, new ArrayList<>(), result, nums.length);

        return result;
    }

    public static void permutation(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result, int length) {

        if (curr.size() == length) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {

                    if (i>0 && nums[i] == nums[i-1] && !used[i-1]){
                        continue;
                    }
                    curr.add(nums[i]);
                    used[i] = true;
                    permutation(nums, used, curr, result, length);
                    curr.remove(curr.size() - 1);
                    used[i] = false;
                }
            }
        }

    }

}
