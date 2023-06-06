package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode130_SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

//        char[][] board = {
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'}};

//        char[][] board = {
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
        solve(board);
        print(board);
    }

    public static void solve(char[][] board) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0
                        || i == board.length - 1
                        || j == 0
                        || j == board[0].length - 1)
                        && !visited[i][j]) {
                    preDfs(board, visited, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, visited, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                replace(board, i, j);
            }
        }
    }

    final static int[] aroundX = {-1, 0, 1, 0};
    final static int[] aroundY = {0, 1, 0, -1};

    public static void preDfs(char[][] board, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        visited[i][j] = true;
        System.out.println("visited[" + i + "][" + j + "]");

        if (board[i][j] == 'O') {
            board[i][j] = 'H';
            System.out.println("board[" + i + "][" + j + "] = 'H'");

            for (int k = 0; k < 4; k++) {
                preDfs(board, visited, i + aroundX[k], j + aroundY[k]);
            }
        }
    }

    public static void dfs(char[][] board, boolean[][] visited, int i, int j) {

        if (i > 0 && i != board.length - 1 && j > 0 && j != board[0].length - 1 && !visited[i][j]) {

            visited[i][j] = true;
            System.out.println("visited[" + i + "][" + j + "]");

            if (board[i][j] == 'O') {
                board[i][j] = 'X';
                System.out.println("board[" + i + "][" + j + "] = 'X'");
            }

            for (int k = 0; k < 4; k++) {
                dfs(board, visited, i + aroundX[k], j + aroundY[k]);
            }

        }
    }

    public static void replace(char[][] board, int i , int j){
        if (board[i][j] == 'H'){
            board[i][j] = 'O';
        }
    }

    public static void print(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

}
