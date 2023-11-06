package leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994_RottingOrages {

    public static void main(String[] args) {
//        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }

    public static int orangesRotting(int[][] grid) {
        int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int count = queue.isEmpty() ? 0 : -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : DIRS) {
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];

                    if (
                            nextRow >= 0
                                    && nextRow < grid.length
                                    && nextCol >= 0
                                    && nextCol < grid[0].length
                                    && grid[nextRow][nextCol] == 1
                                    && !visited[nextRow][nextCol]
                    ) {
                        visited[nextRow][nextCol] = true;
                        grid[nextRow][nextCol] = 2;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        long oneCount = Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .filter(num -> num ==1)
                .count();
        return oneCount == 0 ? count : -1;
    }
}
