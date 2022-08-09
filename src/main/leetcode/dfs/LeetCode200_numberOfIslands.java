package leetcode.dfs;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * Success
 * Runtime: 55 ms, faster than 5.15% of Java online submissions for Number of Islands.
 * Memory Usage: 41.6 MB, less than 28.65% of Java online submissions for Number of Islands.
 */
public class LeetCode200_numberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int result = numIslands(grid);
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        try {
            // 전체 탐색
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    // 방문하지 않고 물이 아닌 지역만
                    if (visited[i][j] == false && grid[i][j] == '1') {
                        dfs(grid, visited, i, j);
                        result++;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    final static int[] pointX = {-1, 0, 1, 0};
    final static int[] pointY = {0, 1, 0, -1};
    public static void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        try {

            // TODO: Condition
            /**
             * x ~ grid.len
             * y ~ grid[i].len
             * visited == false
             * grid == 1
             */
            if (i >= 0 && i < grid.length && j>= 0 && j < grid[i].length && visited[i][j] != true && grid[i][j] == '1') {
                visited[i][j] = true;
                System.out.println("visited[" + i + "][" + j + "]");

                // 상하좌우 탐색
                for (int k = 0; k < 4; k++) {
                    dfs(grid, visited, i + pointX[k], j + pointY[k]);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " / " + ex.getStackTrace());
        }
    }
}




