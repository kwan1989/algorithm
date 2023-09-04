package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이 문제가 BFS 공부하기에 가장 좋은것 같다.
 */
public class LeetCode1091_ShortestPathinBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
//        int[][] grid = {{0,1}, {1,0}};

//        System.out.println(shortestPathBinaryMatrix_bfs(grid));
        System.out.println(shortestPathBinaryMatrix_dfs(grid));
    }


    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public static int shortestPathBinaryMatrix_dfs(int[][] grid) {

        if (grid[0][0] == 1) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        return dfs(grid, 0, 0, visited);
    }

    public static int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        final int[] DR = {-1, -1, -1, 0, 1, 1, 1, 0};
        final int[] DC = {-1, 0, 1, 1, 1, 0, -1, -1};

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        visited[row][col] = true;
        int minDistance = Integer.MAX_VALUE;

        for (int direction = 0; direction < DR.length; direction++) {
            int newRow = row + DR[direction];
            int newCol = col + DC[direction];

            if (newRow >= 0 && newRow < grid.length
                    && newCol >= 0 && newCol < grid[0].length
                    && !visited[newRow][newCol]
                    && grid[newRow][newCol] != 1
            ) {
                int distance = dfs(grid, newRow, newCol, visited);

                if (distance != -1) {
                    minDistance = Math.min(minDistance, distance + 1);
                }
            }
        }

        visited[row][col] = false;
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public static int shortestPathBinaryMatrix_bfs(int[][] grid) {

        if (grid[0][0] == 1) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        final int[] DR = {-1, -1, -1, 0, 1, 1, 1, 0};
        final int[] DC = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            if (curr.row == row - 1 && curr.col == col - 1) {
                return curr.dis;
            }

            for (int direction = 0; direction < DR.length; direction++) {
                int nextRow = curr.row + DR[direction];
                int nextCol = curr.col + DC[direction];

                if (nextRow >= 0 && nextRow < row
                        && nextCol >= 0 && nextCol < col
                        && !visited[nextRow][nextCol]
                        && grid[nextRow][nextCol] != 1
                ) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Point(nextRow, nextCol, curr.dis + 1));
                }
            }
        }
        return -1;
    }

    public static class Point {
        int row;
        int col;
        int dis;

        public Point(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
}
