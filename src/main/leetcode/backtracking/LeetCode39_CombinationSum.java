package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39_CombinationSum {

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates1, target));
        System.out.println(combinationSum1(candidates1, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] candidates, int remain, int idx, List<Integer> curr, List<List<Integer>> result) {

        if (remain == 0) {
            result.add(new ArrayList<>(curr));
        } else if (remain > 0) {
            for (int i = idx; i < candidates.length; i++) {
                curr.add(candidates[i]);
                backtrack(candidates,
                        remain - candidates[i],
                        i,
                        curr,
                        result);
                curr.remove(curr.size() - 1);
            }
        }

    }


    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack1(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack1(int[] candidates,
                                   int remain,
                                   int index,
                                   List<Integer> curr,
                                   List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(curr));
        } else if (remain > 0) {
            for (int i = index; i < candidates.length; i++) {
                curr.add(candidates[i]);
                backtrack1(candidates,
                        remain - candidates[i],
                        i,
                        curr,
                        result);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
