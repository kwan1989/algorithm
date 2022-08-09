package leetcode.greedy;


public class LeetCode11_ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(height);
    }

    /**
     * https://joddong.github.io/leetcode/LeetCode_11/
     * O(N) : 양 쪽에 포인트를 둔 후에, 각 포인트 중 작은 값만 이동시키며 최대 값을 확인한다.
     * O(1)
     */
    public static int maxArea(int[] height) {
        int max_val = 0;
        int left = 0;
        int right = height.length - 1;

        // 종료가 되는 시점은 우측 장벽을 넘어설 때
        while (left < right) {

            // |좌측   우측|     중 더 작은값을 찾는다.
            int temp = Math.min(height[left], height[right]);

            // 최대값의 기준값과
            max_val = Math.max(max_val, (right - left) * temp);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_val;
    }
}
