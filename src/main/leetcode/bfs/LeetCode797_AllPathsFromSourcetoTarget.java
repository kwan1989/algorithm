package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode797_AllPathsFromSourcetoTarget {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        int target = graph.length - 1;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        queue.offer(list);

        while (!queue.isEmpty()) {
            List<Integer> currList = queue.poll();
            int currVal = currList.get(currList.size() - 1);

            if (currVal == target){
                result.add(new ArrayList<>(currList));
            } else {
                for (int adjacent : graph[currVal]){
                    if (!currList.contains(adjacent)){
                        List<Integer> newList = new ArrayList<>(currList);
                        newList.add(adjacent);
                        queue.offer(newList);
                    }
                }
            }
        }
        return result;
    }



    public List<List<Integer>> allPathsSourceTarget_dfs(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }
    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[node]) {
            path.add(neighbor);                     // 1. dfs stack -> list add (1)
            dfs(graph, neighbor, path, result);     // 2. dfs new stack -> end -> 1 회귀 (2),(3),(4) = 1234
            path.remove(path.size() - 1);     // 3. 123
        }
    }
}

