package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfsRetry {

    public static void main(String[] args) {
        char[][] grid = {
                {'S', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'E'}
        };

        System.out.println(bfs(grid, 'S', 'E'));
    }


    public static class Node {
        int row;
        int col;
        int dis;

        public Node(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public static int bfs(char[][] grid, char start, char end) {

        int row = grid.length;
        int col = grid[0].length;

        int startRow = -1;
        int startCol = -1;

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == start) {
                    queue.offer(new Node(r, c, 0));
                    visited[r][c] = true;
                    break;
                }
            }
        }

        final int[] DR = {-1, 1, 0, 0};
        final int[] DC = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node nodeCurr = queue.poll();

            if (grid[nodeCurr.row][nodeCurr.col] == end) {
                return nodeCurr.dis;
            }

            for (int i = 0; i < DR.length; i++) {
                int nextRow = nodeCurr.row + DR[i];
                int nextCol = nodeCurr.col + DC[i];

                if (nextRow >= 0 && nextRow < row
                        && nextCol >= 0 && nextCol < col
                        && !visited[nextRow][nextCol]
                        && grid[nextRow][nextCol] != 'X'
                )
                {
                    queue.offer(new Node(nextRow, nextCol, nodeCurr.dis + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return -1;
    }

}
