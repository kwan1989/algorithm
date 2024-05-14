package leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542_01Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
//        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
        System.out.println(Arrays.deepToString(updateMatrix_2(matrix)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int[] dir : dirs) {
                int nextRow = node[0] + dir[0];
                int nextCol = node[1] + dir[1];

                if (
                        nextRow >= 0 && nextRow < mat.length
                                && nextCol >= 0 && nextCol < mat[0].length
                                && !visited[nextRow][nextCol]
                ) {
                    visited[nextRow][nextCol] = true;
                    mat[nextRow][nextCol] = mat[node[0]][node[1]] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return mat;
    }

    public static int[][] updateMatrix_1(int[][] mat) {
        int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int[] DIR : DIRS) {
                int nextRow = node[0] + DIR[0];
                int nextCol = node[1] + DIR[1];

                if (nextRow >= 0 && nextRow < mat.length
                        && nextCol >= 0 && nextCol < mat[0].length
                        && !visited[nextRow][nextCol]
                ) {
                    visited[nextRow][nextCol] = true;
                    mat[nextRow][nextCol] = mat[node[0]][node[1]] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return mat;

    }


    public static int[][] updateMatrix_2(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] DIRS = {{-1, 0}, {1, 0}, {-1, 0}, {0, 1}};


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] DIR : DIRS) {
                int nextRow = curr[0] + DIR[0];
                int nextCol = curr[1] + DIR[1];

                if (nextRow >= 0 && nextRow < mat.length
                        && nextCol >= 0 && nextCol < mat[0].length
                        && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    mat[nextRow][nextCol] = mat[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return mat;
    }
}
