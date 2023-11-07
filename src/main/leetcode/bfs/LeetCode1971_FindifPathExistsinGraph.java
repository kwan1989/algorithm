package leetcode.bfs;

import java.util.*;

public class LeetCode1971_FindifPathExistsinGraph {

    public static void main(String[] args) {
//        int n = 3;
//        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
//        int source = 0;
//        int destination = 2;

//        int n = 6;
//        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
//        int source = 0;
//        int destination = 5;

        int n = 5;
        int[][] edges = {{0, 4}};
        int source = 0;
        int destination = 4;

        System.out.println(validPath(n, edges, source, destination));
    }

    public static boolean validPath1(int n, int[][] edges, int source, int destination) {

        if (n == 1) return true;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int size = edges[i].length;

            graph.get(edges[i][size - 2]).add(edges[i][size - 1]);
            graph.get(edges[i][size - 1]).add(edges[i][size - 2]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {

            Integer v = q.poll();

            if (v == destination)
                return true;

            List<Integer> list = graph.get(v);

            for (int node : list) {
                if (!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                }
            }
        }

        return false;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        HashMap<Integer, List<Integer>> map = edgesToHashMap(n, edges);

        return bfs(n, map, source, destination);
    }

    public static boolean bfs(int n, HashMap<Integer, List<Integer>> map, int source, int destination) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == destination) {
                return true;
            }

            for (int i = 0; i < map.get(curr).size(); i++) {
                if (!visited[map.get(curr).get(i)]) {
                    queue.offer(map.get(curr).get(i));
                    visited[map.get(curr).get(i)] = true;
                }
            }
        }

        return false;
    }

    public static HashMap<Integer, List<Integer>> edgesToHashMap(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        return graph;
    }
}
