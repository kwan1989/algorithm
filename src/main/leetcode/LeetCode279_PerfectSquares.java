package leetcode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * Constraints:
 * 1 <= n <= 104
 *
 * Success
 * Runtime: 126 ms, faster than 23.25% of Java online submissions for Perfect Squares.
 * Memory Usage: 261.3 MB, less than 5.02% of Java online submissions for Perfect Squares.
 */
public class LeetCode279_PerfectSquares {

    public static void main(String[] args) {
        int result = numSquares(13);
    }

    public static int numSquares(int n) {
        int depth = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        // BFS
        while (!q.isEmpty()) {
            depth++;

            // 여기서 변수로 정의해주지 않으면 큐의 사이즈는 자꾸 변경되기 때문에 문제가됨
            int len = q.size();
            //System.out.println("qSize : " + q.size() + " / len : " + len);

            for (int i = 0; i < len; i++) {
                int num = q.poll();

                // num <= sqrt (아래서 j*j 가 num 보다 크면 안되므로 제곱근 까지만)
                for (int j = 1; j <= Math.sqrt(num); j++) {

                    int curr = num - j * j;
                    if (curr == 0) {
                        return depth;
                    }
                    q.offer(curr);
//                    System.out.println("len : " + len
//                            +" depth : " + depth
//                            + " / curr : " + curr
//                            + " / " + num
//                            + " - " + j
//                            + " * " + j);
                }
            }
        }
        return depth;
    }
}
