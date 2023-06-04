package leetcode.twopointers;


public class LeetCode11_ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    /**
     *  넓이 연산
     *  (right-left) : 가로
     *  min          : 높이
     *
     *  투포인터로 좌/우 비교해서 작은 축을 움직여가며 max 값을 갱신해 간다.
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {

            int min = Math.min(height[left], height[right]);

            max = Math.max(max, (right - left) * min);

            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }

        return max;
    }
}
