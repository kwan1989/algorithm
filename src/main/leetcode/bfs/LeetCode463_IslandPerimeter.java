package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode463_IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {

        final int[] DR = {-1, 1, 0, 0};
        final int[] DC = {0, 0, -1, 1};

        int row = grid.length;
        int col = grid[0].length;

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    break;
                }
            }
            if (!queue.isEmpty()){
                break;
            }
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int i = 0; i < DR.length; i++) {
                int nextRow = curr.row + DR[i];
                int nextCol = curr.col + DC[i];

                /**
                 *  4 방향 탐색시, 레인지를 벗어나거나 0 이면 카운트 증가
                 */
                if (nextRow < 0
                        || nextRow >= row
                        || nextCol < 0
                        || nextCol >= col
                        || grid[nextRow][nextCol] == 0) {
                    count++;
                } else if (!visited[nextRow][nextCol]) {
                    queue.offer(new Node(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }

            }
        }
        return count;
    }

    public static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
