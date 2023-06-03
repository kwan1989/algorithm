package leetcode.dp;

/**
 * Dynamic Programming, DP
 * <p>
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * <p>
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * Constraints:
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 * <p>
 * Success
 * Details
 * Runtime: 85 ms, faster than 42.78% of Java online submissions for Longest Increasing Subsequence.
 * Memory Usage: 44.7 MB, less than 37.33% of Java online submissions for Longest Increasing Subsequence.
 */
public class LeetCode300_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        //int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {0, 1, 0, 3, 2, 3};

        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int max = 1;

        // dp 각 자리수 최대길이 생성
        int[] dp = new int[nums.length];

        // 첫 번째 원소부터 N번째 원소까지 dp 테이블의 값을 채워 나간다.
        for (int i = 0; i < nums.length; i++) {

            // 자기 자리수를 일단 포함하기 때문에 일단 1 로 시작
            dp[i] = 1;

            // 현재 원소의 위치에 대하여, 앞의 원소의 값을 비교하며 값을 갱신한다.
            for (int j = 0; j < i; j++) {

                // 만일 부분 수열이 증가할 가능성이 있다면
                if (nums[i] > nums[j]) {

                    // 자기 i 배열 값보다 j 값의 dp[j] 값 +1 된 값이 더 클경우 dp[i](현재) 갱신
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println(dp[i]);
                }
            }

            // 최대 길이 갱신
            max = Math.max(max, dp[i]);

        }

        return max;
    }

    public static int lengthOfLIS_retry(int[] nums) {

        // 자기 원소는 최소 1개, 자기를 포함하니까
        int max = 1;

        // memoization
        int[] dp = new int[nums.length];

        // 각 자리수에서 최대 수열길이를 찾자
        for (int i = 0; i < nums.length; i++) {

            // j ~ i (i의 앞부분을 검토하면서 더큰 숫자들을 탐색
            for (int j = 0; j < i; j++) {

                // 당연히 현재 자리수인 i 가 더 크다면
                if (nums[j] < nums[i]) {
                    /*
                     해당 부분이 핵심 로직인데, 이유는 다음과 같다.
                     각 자리별 가장큰 수열을 담은 수 (int[] dp)

                        ex) nums = {0, 1, 0, 3, 2, 3};

                         +---+---+---+---+---+---+
                   nums  | 0 | 1 | 0 | 3 | 2 | 3 |
                         +---+---+---+---+---+---+
                  step 1 | 1 |   |   |   |   |   |
                  step 2 |1+1| 2 |   |   |   |   |
                  step 3 |   |   | 1 |   |   |   |
                  step 4 |   |2+1|   | 3 |   |   |
                  step 5 |   |   |   |   | 3 |   |
                  step 6 |   |   |   |   |3+1| 4 |
                         +---+---+---+---+---+---+

                         위 그림은 dp[i] 가 채워지는 그림을 표로 작성하였다.
                         num[j] + 1 값은 표에서 + 값을 표기한걸로 이해하자.
                         해당 루프를 통해 dp[i] 값 갱신
                    */
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 또 각 현재 자리수 nums[i] 값을 체크하여 최대값을 갱신한다.
            max = Math.max(max, dp[i]);
        }
        // 전체 사이클이 반복되면 i 의 루프만큼 반복하였으니 각 자리수 수열 최대자리가 갱신되었을 것.
        return max;
    }

}
