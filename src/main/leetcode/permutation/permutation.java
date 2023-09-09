package leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class permutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};


        List<List<Integer>> permutations = permutate(nums);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }

    }

    public static List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            permutation(nums, new ArrayList<>(), result, i);
        }

        return result;
    }

    public static void permutation(int[] nums, List<Integer> curr, List<List<Integer>> result, int length) {

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

    public static void permutation1(int[] nums, List<Integer>curr, List<List<Integer>> result, int length){

        if (curr.size() == length){
            result.add(new ArrayList<>(curr));
        } else {
            for(int num : nums){
                if (!curr.contains(num)){
                    curr.add(num);
                    permutation1(nums, curr, result, length);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }


}
