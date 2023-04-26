package leetcode.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-number/">https://leetcode.com/problems/largest-number/</a>
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 **/

public class LeetCode179_LargestNumber
{

    public static void main(String[] args)
    {
        int[] input = {10, 2};
//        int[] input = {3, 30, 34, 5, 9};

        System.out.println(largestNumber(input));
    }


    public static String largestNumber(int[] nums)
    {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(Arrays.stream(nums)
                            .mapToObj(String::valueOf)
                            .toArray(String[]::new))
              .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
              .forEach(sb::append);

        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }

}
