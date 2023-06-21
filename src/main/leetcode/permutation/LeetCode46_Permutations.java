package leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46_Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int length = 1; length <= nums.length; length++) {
            permutation(nums, new ArrayList<>(), result, length);
        }

        return result;
    }

    public static void permutation(int[] nums,
                                   List<Integer> curr,
                                   List<List<Integer>> result,
                                   int length) {
        if (curr.size() == length) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int num : nums) {
                if (!curr.contains(num)) {
                    curr.add(num);
                    permutation(nums, curr, result, length);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

}
