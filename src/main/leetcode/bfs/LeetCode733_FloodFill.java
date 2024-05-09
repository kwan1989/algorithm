package leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode733_FloodFill {
    public static void main(String[] args) {


        int[][] images = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

//        int[][] images = {{0,0,0}, {0,0,0}, {0,0,0}};
//        int sr = 0;
//        int sc = 0;
//        int color = 0;

//        int[][] images = {{0, 0, 0}, {0, 0, 0}};
//        int sr = 1;
//        int sc = 0;
//        int color = 2;


        // BFS
//        print(floodFill_bfs(images, sr, sc, color));

        // DFS
        print(floodFill_dfs(images, sr, sc, color));

    }

    /**
     * DFS
     *
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public static int[][] floodFill_dfs(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int originColor = image[sr][sc];

        boolean[][] visited = new boolean[row][col];

        dfs(image, sr, sc, visited, originColor, color);

        return image;
    }

    public static int[][] floodFill_dfs2(int[][] image, int sr, int sc, int color) {
        return dfs2(image, sr, sc, image[sr][sc], color, new boolean[image.length][image[0].length]);
    }

    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] dfs2(int[][] image, int r, int c, int originColor, int newColor, boolean[][] visited) {
        if (r >= 0 && r < image.length
                && c >= 0 && c < image[0].length
                && image[r][c] == originColor
                && !visited[r][c]
        ) {
            visited[r][c] = true;
            image[r][c] = newColor;

            for (int[] DIR : DIRS) {
                dfs2(image, r + DIR[0], c + DIR[1], originColor, newColor, visited);
            }
        }
        return image;
    }

    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    public static int[][] dfs(int[][] image, int row, int col, boolean[][] visited, int originColor, int newColor) {

        if (row >= 0 && row < image.length
                && col >= 0 && col < image[0].length
                && !visited[row][col]
                && image[row][col] == originColor
        ) {
            visited[row][col] = true;
            image[row][col] = newColor;

            for (int i = 0; i < DR.length; i++) {
                dfs(image, row + DR[i], col + DC[i], visited, originColor, newColor);
            }
        }
        return image;
    }

    public int[][] floodFill_1(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int originalColor = image[sr][sc];

        return dfs_1(image, sr, sc, visited, originalColor, color);
    }

    static final int[][] MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] dfs_1(int[][] image, int r, int c, boolean[][] visited, int originalColor, int newColor) {
        if (r >= 0 && r < image.length
                && c >= 0 && c < image[0].length
                && !visited[r][c]
                && image[r][c] == originalColor
        ) {
            visited[r][c] = true;
            image[r][c] = newColor;

            for (int[] move : MOVES) {
                int nextRow = r + move[0];
                int nextCol = c + move[1];

                dfs_1(image, nextRow, nextCol, visited, originalColor, newColor);
            }
        }

        return image;
    }

    /**
     * BFS
     *
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public static int[][] floodFill_bfs(int[][] image, int sr, int sc, int color) {

        if (color == 0) {
            return image;
        }

        int row = image.length;
        int col = image[0].length;
        int originColor = image[sr][sc];
        boolean[][] visited = new boolean[row][col];
        final int[] DR = {-1, 1, 0, 0};
        final int[] DC = {0, 0, -1, 1};


        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr, sc));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (image[curr.row][curr.col] == originColor) {
                image[curr.row][curr.col] = color;
            }

            for (int i = 0; i < DR.length; i++) {
                int nextRow = curr.row + DR[i];
                int nextCol = curr.col + DC[i];

                if (nextRow >= 0 && nextRow < row
                        && nextCol >= 0 && nextCol < col
                        && !visited[nextRow][nextCol]
                        && image[nextRow][nextCol] == originColor
                ) {
                    queue.offer(new Node(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return image;
    }

    public static int[][] floodFill_bfs2(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int originColor = image[sr][sc];
        boolean[][] visited = new boolean[r][c];
        int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr, sc));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (image[node.row][node.col] == originColor && !visited[node.row][node.col]) {
                image[node.row][node.col] = color;
                visited[node.row][node.col] = true;

                for (int[] DIR : DIRS) {
                    int nextR = node.row + DIR[0];
                    int nextC = node.col + DIR[1];

                    if (nextR >= 0 && nextR < image.length
                            && nextC >= 0 && nextC < image[0].length
                    ) {
                        queue.offer(new Node(nextR, nextC));
                    }
                }
            }
        }

        return image;
    }

    public static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Print Result
     *
     * @param result
     */
    public static void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
