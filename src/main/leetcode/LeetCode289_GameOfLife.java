package leetcode;

/**
 * https://leetcode.com/problems/game-of-life/
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */
public class LeetCode289_GameOfLife {

    public static void main(String[] args) {
        //int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        //int[][] board = {{1, 1} ,{1, 0}};
        int[][] board = {{0, 0}};
        //int[][] board = {{1}};
        gameOfLife(board);
    }

    /**
     * 1. 살아있는 이웃이 2개 미만인 살아있는 세포는 마치 인구 부족으로 인한 것처럼 죽습니다.
     * - 죽음.
     * board[i][j] == 1 && Neighborhood < 2
     * - 1 → 0
     *
     * 2. 2~3개의 살아있는 이웃이 있는 살아있는 세포는 다음 세대에 계속 살아갑니다.
     * - 살아있음.
     * board[i][j] == 1 && Neighborhood <= 3
     * - 1 → 1
     *
     * 3. 3개 이상의 살아있는 이웃이 있는 살아있는 세포는 마치 인구 과잉으로 인해 죽습니다. (이상이라니..초과 아닌가?)
     * - 죽음.
     * board[i][j] == 1 && Neighborhood < 3
     * - 1 → 0
     *
     * 4. 정확히 세 개의 살아있는 이웃이 있는 죽은 세포는 마치 번식에 의한 것처럼 살아있는 세포가 됩니다.
     * - 살아남.
     * board[i][j] == 0 && Neighborhood == 3
     * - 0 → 1
     *
     * * 이웃의 규칙
     * - 0은 1의 이웃
     *
     * 0 0 0
     * 0 1 0
     * 0 0 0
     *
     * @param board
     */
    public static void gameOfLife(int[][] board) {

        if (board.length == 0 && board[0].length == 0)
            return;

        // Copy Board
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                copyBoard[row][col] = board[row][col];
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                int cntNeighbor = findOfNeighborhood(copyBoard, row, col);

                if ((board[row][col] == 1 && cntNeighbor < 2)) {
                    board[row][col] = 0;
                } else if (board[row][col] == 1 && cntNeighbor <= 3) {
                    board[row][col] = 1;
                } else if (board[row][col] == 1 && cntNeighbor > 3) {
                    board[row][col] = 0;
                } else if (board[row][col] == 0 && cntNeighbor == 3) {
                    board[row][col] = 1;
                }
            }
        }

        print(board);
    }


    /**
     * 주변 이웃이 몇명일까?
     * 좌표 위치를 입력하면 주변에 이웃을 스캔하여 이웃수를 반환
     * (이웃수를 판단하는 기준은 1인 것)
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    public static int findOfNeighborhood(int[][] board, int y, int x) {

        int result = 0;
        /**
         *  1을 기준으로 0의 좌표
         *  0 0 0
         *  0 1 0
         *  0 0 0
         */
        int[][] neighbor = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};

        for (int k = 0; k < neighbor.length; k++) {
            int pointX = x + neighbor[k][0];
            int pointY = y + neighbor[k][1];

            if (pointX >= 0 && pointX < board[0].length && pointY >= 0 && pointY < board.length) {
                if (board[pointY][pointX] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Test Print
     *
     * @param board
     */
    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                sb.append("[" + board[i][j] + "]");
            }
            System.out.println(sb.toString());
        }
    }

}
