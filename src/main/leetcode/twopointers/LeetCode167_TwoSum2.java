package leetcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode167_TwoSum2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }


    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    /**
     * fail [0,0,3,4] 인 경우 중복된 키값 히든 케이스.
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int number : numbers) {
            map.put(number, count++);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int sub = target - entry.getKey();

            if (map.containsKey(sub)) {
                return new int[]{entry.getValue() + 1, map.get(sub) + 1};
            }

        }

        return new int[]{};
    }
}
