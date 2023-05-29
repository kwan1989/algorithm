package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091_ShortestPathinBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
//        int[][] grid = {{0,1}, {1,0}};

        System.out.println(shortestPathBinaryMatrix(grid));
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

    public static int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1){
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
}
