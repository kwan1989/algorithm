package leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    public static void main(String[] args) {
//        int[][] graph = {
//                {2, 0, 1, 1, 0},
//                {1, 0, 0, 1, 1},
//                {1, 0, 0, 0, 1},
//                {0, 1, 0, 0, 0},
//                {0, 1, 1, 9, 0}
//        };
//        int startNode = 0;

//        bfs(graph, startNode);

//        char[][] grid = {
//                {'S', 'O', 'O', 'O', 'X'},
//                {'O', 'X', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'X'},
//                {'O', 'X', 'O', 'X', 'X'},
//                {'E', 'O', 'O', 'X', 'X'}
//        };
//
//        System.out.println(bfs2(grid, 'S', 'E'));

        char[][] grid = {
                {'S', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'X'},
                {'O', 'O', 'E', 'X', 'X'}
        };

        System.out.println(bfs3(grid, 'S', 'E'));

    }

    /**
     * BFS Full Scan
     *
     * @param graph
     * @param start
     */
    public static void bfs(int[][] graph, int start) {
        int n = graph.length; // 그래프의 노드 수

        boolean[] visited = new boolean[n]; // 방문 여부를 저장하는 배열
        Queue<Integer> queue = new LinkedList<>(); // 큐를 사용하여 노드를 처리

        visited[start] = true; // 시작 노드를 방문한 것으로 표시
        queue.offer(start); // 시작 노드를 큐에 추가

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 노드를 하나씩 꺼냄
            System.out.print(node + " "); // 노드를 출력하거나 원하는 작업 수행

            // 인접한 노드들 중에서 방문하지 않은 노드를 큐에 추가하고 방문 여부를 표시
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }


    /**
     * BFS Shortest Path
     *
     * @param graph
     * @param start
     * @param destination
     * @return
     */
    public static int bfs1(int[][] graph, int start, int destination) {
        int n = graph.length; // 그래프의 노드 수

        boolean[] visited = new boolean[n]; // 방문 여부를 저장하는 배열
        Queue<Integer> queue = new LinkedList<>(); // 큐를 사용하여 노드를 처리
        int[] distances = new int[n]; // 시작 노드부터 각 노드까지의 최단 거리를 저장하는 배열

        visited[start] = true; // 시작 노드를 방문한 것으로 표시
        queue.offer(start); // 시작 노드를 큐에 추가

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 노드를 하나씩 꺼냄

            // 목적지에 도달하면 최단 경로를 반환
            if (node == destination) {
                return distances[node];
            }

            // 인접한 노드들 중에서 방문하지 않은 노드를 큐에 추가하고 방문 여부와 최단 거리를 업데이트
            for (int i = 0; i < n; i++) {

                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    distances[i] = distances[node] + 1;
                }
            }
        }

        // 목적지에 도달할 수 없는 경우 -1을 반환
        return -1;
    }

    public static class Node {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static int bfs2(char[][] grid, char start, char end) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dr = {-1, 1, 0, 0}; // 상하좌우 방향
        int[] dc = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // 시작 노드를 찾아 큐에 추가
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == start) {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }
        queue.offer(new Node(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currDist = curr.distance;

            // 목표 지점(E)에 도달한 경우 최단 거리 반환
            if (grid[currRow][currCol] == end) {
                return currDist;
            }

            // 상하좌우로 이동
            for (int i = 0; i < dr.length; i++) {
                int newRow = currRow + dr[i];
                int newCol = currCol + dc[i];

                // 유효한 범위 내에 있고, 방문하지 않았고, 장애물이 아닌 경우 큐에 추가
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] != 'X') {
                    queue.offer(new Node(newRow, newCol, currDist + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }

        // 도달할 수 없는 경우 -1 반환
        return -1;
    }


    public static int bfs3(char[][] grid, char start, char end) {
        int row = grid.length;
        int col = grid[0].length;

        int[] DR = {-1, 1, 0, 0};
        int[] DC = {0, 0, -1, 1};

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == start) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        queue.offer(new Node(startRow, startCol, 0));
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            if (grid[curr.row][curr.col] == end) {
                return curr.distance;
            }

            for (int i = 0; i < DR.length; i++) {
                int nextRow = curr.row + DR[i];
                int nextCol = curr.col + DC[i];

                if (nextRow >= 0 && nextRow < row
                        && nextCol >= 0 && nextCol < col
                        && !visited[nextRow][nextCol]
                        && grid[nextRow][nextCol] != 'X'
                ) {
                    queue.offer(new Node(nextRow, nextCol, curr.distance + 1));
                    visited[nextRow][nextCol] = true;
                }
            }

        }

        return -1;
    }

}
