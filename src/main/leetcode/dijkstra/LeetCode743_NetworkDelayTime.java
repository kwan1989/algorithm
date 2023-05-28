package leetcode.dijkstra;

import java.util.*;

public class LeetCode743_NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        //Step 1 : 시작 노드와 끝 노드 간의 가중치를 가진 맵을 생성합니다.
        //                1 -> {2,1},{3,2}
        //                2 -> {4,4},{5,5}
        //                3 -> {5,3}
        //                4 ->
        //                5 ->
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int[] time : times) {
            int start = time[0];
            int end = time[1];
            int weight = time[2];

            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end, weight);
        }

        // Step 2 : 최소 거리를 기록할 결과 배열을 생성합니다.
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;



        //Step 3:   큐를 생성하고 시작 위치를 추가합니다.
        //          시작 위치의 가중치와 시작 노드에서 끝 노드에 도달하는 데 필요한 가중치를 더하여 도달 가능한 거리를 추가합니다.
        //          큐에서 쌍을 계속해서 추가하고 제거하며 결과 배열을 업데이트합니다.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k,0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curNode = cur[0];
            int curWeight = cur[1];

            for(int next : map.getOrDefault(curNode, new HashMap<>()).keySet()) {
                int nextWeight = map.get(curNode).get(next);

                if(curWeight + nextWeight < dis[next]) {
                    dis[next] = curWeight + nextWeight;
                    queue.add(new int[]{next, curWeight + nextWeight});
                }
            }
        }

        //Step 4: 결과 배열에서 최댓값을 찾습니다.
        int res = 0;
        for(int i=1; i<=n; i++) {
            if(dis[i] > res) {
                res = Math.max(res, dis[i]);
            }
        }

        //위의 과정을 따라 문제를 해석하면 다음과 같습니다. 시작 노드에서 모든 노드까지의 최단 거리를 계산하여 결과 배열에 저장하고, 그 중에서 가장 큰 값을 찾는 것이 목표입니다.
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}


