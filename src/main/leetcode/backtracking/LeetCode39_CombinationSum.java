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
        backtrack(candidates, target,  0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] candidates, int remain, int idx ,List<Integer> curr, List<List<Integer>> result) {

        if (remain == 0) {
            result.add(new ArrayList<>(curr));
        } else if (remain > 0) {
            for (int i = idx; i < candidates.length; i++){
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
                                   int start,
                                   List<Integer> combination,
                                   List<List<Integer>> result) {
        if (remain < 0) { // 합계가 타겟보다 크면 종료
            return;
        } else if (remain == 0) { // 합계가 타겟과 일치하면 결과에 추가
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            // 현재의 후보를 다시 사용하기 위해 i를 넘깁니다.
            backtrack1(candidates,
                    remain - candidates[i],
                    i,
                    combination,
                    result);
            // 마지막 요소 제거하여 다른 조합 시도 가능하게 함
            combination.remove(combination.size() - 1);
        }
    }

}
