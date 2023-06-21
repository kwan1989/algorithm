package livecodingtest.yanolja;

import java.util.*;

public class process2 {

    /**
     * [1, 2, 3, 7, 9] 의 숫자 배열로 만들수 있는 시간 (24시간) 표기를 작성해 주세요.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7, 9};
//        List<String> results = new ArrayList<>();
//        generateTimeCombinations(nums, 0, results);
//        results.forEach(System.out::println);
//        for (List<Integer> permutation : result) {
//            System.out.println(permutation);
//        }

        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, new ArrayList<>(), result);
        int count = 0;
        for (List<Integer> permutation : result) {
            if (isTime(permutation)) {
                System.out.println(permutation);
                count++;
            }
        }

        System.out.println(count);


        findValidTimes(nums);

    }

    public static void permutation(int[] nums, List<Integer> curr, List<List<Integer>> result) {

        if (curr.size() == 4) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int num : nums) {
                if (!curr.contains(num)) {
                    curr.add(num);
                    permutation(nums, curr, result);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    public static boolean isTime(List<Integer> curr) {
        int hour = curr.get(0) * 10 + curr.get(1);
        int minute = curr.get(2) * 10 + curr.get(3);

        if (hour > 23 || minute > 59) {
            return false;
        }

        return true;
    }


    public static void generateTimeCombinations(int[] nums, int start, List<String> results) {
        if (start == nums.length) {
            int hour = nums[0] * 10 + nums[1];
            int minute = nums[2] * 10 + nums[3];

            if (hour < 24 && minute < 60) {
                String formattedTime = String.format("%02d:%02d", hour, minute);
                results.add(formattedTime);
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            generateTimeCombinations(nums, start + 1, results);
            swap(nums, i, start);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void findValidTimes(int[] nums) {
        ArrayList<String> validTimes = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int h1 = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;

                int h2 = nums[j];
                int hours = h1 * 10 + h2;
                if (hours < 24) {
                    for (int k = 0; k < nums.length; k++) {
                        if (k == i || k == j) continue;

                        int m1 = nums[k];
                        for (int l = 0; l < nums.length; l++) {
                            if (l == i || l == j || l == k) continue;

                            int m2 = nums[l];
                            int minutes = m1 * 10 + m2;
                            if (minutes < 60) {
                                String time = String.format("%02d:%02d", hours, minutes);
                                validTimes.add(time);
                            }
                        }
                    }
                }
            }
        }

        for (String time : validTimes) {
            System.out.println(time);
        }
    }
}
