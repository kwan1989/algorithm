package leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode934_ShortestBridge {

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{0,1}, {1,0}}));  // 1
        System.out.println(shortestBridge(new int[][]{{0,1,0}, {0,0,0}, {0,0,1}})); // 2
        System.out.println(shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}})); // 1
    }

    /**
     * 문제 이해를 돕기 위해 설명 (example3 으로 설명)
     *
     * 1.   [1,1,1,1,1]
     *      [1,0,0,0,1]
     *      [1,0,1,0,1]
     *      [1,0,0,0,1]
     *      [1,1,1,1,1]
     *  둘레에 연결된 섬(A)과 중앙에 섬(B)으로 2개의 섬으로 이루어져 있다.
     *  목표는 A -> B 연결하는데 최소 연결 다리 개수 이다.
     *
     * 2.   [2,2,2,2,2]
     *      [2,0,0,0,2]
     *      [2,0,1,0,2]
     *      [2,0,0,0,2]
     *      [2,2,2,2,2]
     *  첫번째 섬을 찾으면, 그 섬을 전부 2로 변경한다, 그리고 그 변경한 내역들을 전부 큐에 담아서 좌표값을 담는다. (각 포인트는 x,y,distance를 가지고 있다)
     *  그리고 다음섬을 DFS로 검색할 필요가 없으므로 2중 반복문이므로 플레그를 주어 빠져나왔다.
     *
     * 3.   [2,2,2,2,2]
     *      [2, , , ,2]
     *      [2, ,1, ,2]
     *      [2, , , ,2]
     *      [2,2,2,2,2]
     *  큐에는 다음과 같은 2의 값들이 정의 되어 있다. 결론적으로 2로 된 큐에서 1로 가는 가장 짧은거리를 찾으면된다, (BFS)
     *  도달한 섬에 대해서는 각각의 위치에 2로 수정해주어 빈공간을 1의 섬에 편입해준다. 그러면서 거리가 추가될떄마다 큐에 dis + 1 값으로 추가해준다.
     *  그러다가 1에 도달하면 현재까지 누적되어 연산된 dis 값을 반환한다. (BFS 의 빠른길찾기라고 생각하자)
     *
     * @param grid
     * @return
     */
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
