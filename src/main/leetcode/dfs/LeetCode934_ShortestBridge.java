package leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode934_ShortestBridge {

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
    }

    public static int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new LinkedList<>();
        boolean findFirstIsland = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, 1, 2, queue);
                    findFirstIsland = true;
                    break;
                }
            }
            if (findFirstIsland){
                break;
            }
        }

        return bfs(grid, queue);
    }

    public static void dfs(int[][] grid, boolean[][] visited, int row, int col, int find, int changed, Queue<Point> queue) {

        if (row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && grid[row][col] == find
                && !visited[row][col]
        ) {
            visited[row][col] = true;
            grid[row][col] = changed;
            queue.offer(new Point(row, col, 0));
            for (int dir = 0; dir < 4; dir++) {
                dfs(grid, visited, row + pointY[dir], col + pointX[dir], find, changed, queue);
            }
        }
    }


    public static int bfs(int[][] grid, Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int direction = 0; direction < pointX.length; direction++) {
                int nextRow = curr.row + pointY[direction];
                int nextCol = curr.col + pointX[direction];

                if (nextRow >= 0 && nextRow < grid.length
                        && nextCol >= 0 && nextCol < grid[0].length
                        && grid[nextRow][nextCol] != 2
                ) {
                    if (grid[nextRow][nextCol] == 1) {
                        return curr.dis;  // 두 번째 섬에 도달했을 때, 현재까지의 거리 반환
                    }

                    grid[nextRow][nextCol] = 2;  // 첫 번째 섬에 추가
                    queue.offer(new Point(nextRow, nextCol, curr.dis + 1));
                }
            }
        }
        return -1;
    }

    static final int[] pointX = {-1, 0, 1, 0};
    static final int[] pointY = {0, 1, 0, -1};

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
