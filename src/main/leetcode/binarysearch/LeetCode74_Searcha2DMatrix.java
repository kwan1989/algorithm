package leetcode.binarysearch;

public class LeetCode74_Searcha2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    /*
        이 문제는 조건에 가장 큰 힌트가 있다. 다음 행의 첫번째 열은 이전 행의 마지막 열보다 무조건 크다 라는 것

        [1] [3] [5] [7]
        [10][11][16][20]
        [23][30][34][60]

        로 보자면, 2번째 행의 첫번째인 10은 1행의 마지막인 7보다 크고 10 > 7
        3번째 행의 첫번째인 23은 2행의 마지막인 20보다 무조건 크다 23 > 20

        쉽게 그림으로 표현하자면 결국 이진탐색의 조건인 정렬이 되어있어야 하는것인데,
        그 마지막값으로 행의 위치를 파악하고, 열을 증가시키면서 값을 찾아간다.

        [1][3][5][7]    [10][11][16][20]    [23][30][34][60]
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = 0;

        while (r < matrix.length && c < matrix[0].length) {

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][matrix[0].length - 1] < target) {
                r++;
            } else {
                c++;
            }
        }
        return false;
    }

}
