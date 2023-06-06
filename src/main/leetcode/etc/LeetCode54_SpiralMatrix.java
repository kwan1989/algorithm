package leetcode.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode54_SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(spiralOrder(matrix));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length - 1;

        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int a = startCol; a <= endCol; a++) {
                result.add(matrix[startRow][a]);
            }
            startRow++;

            for (int b = startRow; b <= endRow; b++) {
                result.add(matrix[b][endCol]);
            }
            endCol--;

            if (startRow <= endRow) {
                for (int c = endCol; c >= startCol; c--) {
                    result.add(matrix[endRow][c]);
                }
            }
            endRow--;

            if (startCol <= endCol) {
                for (int d = endRow; d >= startRow; d--) {
                    result.add(matrix[d][startCol]);
                }
            }
            startCol++;

        }


        return result;
    }

}
