package leetcode.bfs;

public class LeetCode79_WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {

        int rowLen = board.length;
        int colLen = board[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, r, c, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public static boolean dfs(char[][] board, String word, int row, int col, int idx, boolean[][] visited) {

        if (idx == word.length()) {
            return true;
        }

        int rowLen = board.length;
        int colLen = board[0].length;

        if (row < 0 || row >= rowLen
                || col < 0 || col >= colLen
                || visited[row][col]
                || board[row][col] != word.charAt(idx)
        ) {
            return false;
        }

        visited[row][col] = true;

        for (int i = 0; i < DR.length; i++) {
            int nextRow = row + DR[i];
            int nextCol = col + DC[i];

            if (dfs(board, word, nextRow, nextCol, idx + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }
}
