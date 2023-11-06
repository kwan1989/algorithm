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


        for (int length = 1; length <= nums.length; length++) {
            permutation_중복숫자가능(nums, 0,new ArrayList<>(), result, length);
        }

        return result;
    }

    public static void permutation(int[] nums,
                                   List<Integer> curr,
                                   List<List<Integer>> result,
                                   int length)
    {
        if (curr.size() == length) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i<nums.length; i++){
                if(!curr.contains(nums[i])){
                    curr.add(nums[i]);
                    permutation(nums, curr, result, length);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    public static void permutation_중복숫자가능(int[] nums,
                                   int index,
                                   List<Integer> curr,
                                   List<List<Integer>> result,
                                   int length)
    {
        if(curr.size() == length){
            result.add(new ArrayList<>(curr));
        } else {
            for (int i = index; i<nums.length; i++){
                curr.add(nums[i]);
                permutation_중복숫자가능(nums, i, curr, result, length);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
