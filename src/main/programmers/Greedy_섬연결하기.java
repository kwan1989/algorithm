package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_섬연결하기 {

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42861?language=java
     *
     * 문제 설명
     * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
     * 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
     *
     * 제한사항
     * 섬의 개수 n은 1 이상 100 이하입니다.
     * costs의 길이는 ((n-1) * n) / 2이하입니다.
     * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
     * 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
     * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
     * 연결할 수 없는 섬은 주어지지 않습니다.
     *
     * 입출력 예
     * n	costs	                                    return
     * 4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
     *
     * 입출력 예 설명
     * costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.
     *
     *
     * 테스트 1 〉	통과 (0.63ms, 52.7MB)
     * 테스트 2 〉	통과 (0.76ms, 52.5MB)
     * 테스트 3 〉	통과 (0.85ms, 52.8MB)
     * 테스트 4 〉	통과 (0.86ms, 52.6MB)
     * 테스트 5 〉	통과 (0.50ms, 52.9MB)
     * 테스트 6 〉	통과 (1.14ms, 53.2MB)
     * 테스트 7 〉	통과 (0.92ms, 53.2MB)
     * 테스트 8 〉	통과 (0.75ms, 52MB)
     *
     *
     * ★ 이번 문제에 대해서는 greedy 에 대한 중점보다 전체적인 처리에 대한 이해가 부족해 산당님의 정답을 가지고 따로 교육을받았다.. ㅠ
     *
     *
     * @param n
     * @param costs
     * @return
     */
    public int solution(int n, int[][] costs) {
        int answer = installBridge(n, costs);
        return answer;
    }

    public static int[] parent;
    public int installBridge(int n, int[][] costs) {

        int result = 0;
        parent = new int[n];


        // 우선순위 큐
        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            pq.add(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            Bridge bridge = pq.poll();
            int start = bridge.getStart();
            int end = bridge.getEnd();

            int a = findParent(start);
            int b = findParent(end);

            if (a == b)
                continue;

            union(start, end);
            result += bridge.getCost();
        }
        return result;
    }

    /**
     * 최상위 부모 찾기
     * @param idx
     * @return
     */
    public int findParent(int idx) {

        // 초기화된 상태이면 자기 자신이 부모
        if (idx == parent[idx]) {
            return idx;
        }

        // find 는 최상위 부모로 부로를 설정
        parent[idx] = findParent(parent[idx]);
        return parent[idx];
    }

    /**
     * 최상위 부모 설정
     * @param a
     * @param b
     */
    public void union(int a, int b) {
        int a1 = findParent(a);
        int b1 = findParent(b);

        if (a1 != b1) {
            parent[a1] = b;
        } else {
            return;
        }
    }


    /**
     * subClass compareTo 를 통해 priorityQueue 의 우선순위를 정해짐
      */
    class Bridge implements Comparable<Bridge> {
        int start;
        int end;
        int cost;

        public Bridge(int start, int end, int cost) {
            //super();
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bridge bridge) {
            return bridge.cost >= this.cost ? -1 : 1;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCost() {
            return cost;
        }

    }


    /**
     * 산당님에게 따로 교육받은..
     * @param n
     * @param costs
     * @return
     */
    public int installBridge_1(int n, int[][] costs) {
        int result = 0;
        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));

        /**
         * costs
         * costs[0] : 0,1,1
         * costs[1] : 1,3,1
         * costs[2] : 0,2,2
         * costs[3] : 1,2,5
         * costs[4] : 2,3,8
         */
        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int val = costs[i][2];

            if (start == end) continue;

            for (int[] cost : costs) {
                if (cost[0] == end) {
                    cost[0] = start;
                }
                if (cost[1] == end) {
                    cost[1] = start;
                }
            }
        }

        /**
         * costs
         * costs[0] : 0,0,1
         * costs[1] : 0,0,1
         * costs[2] : 0,0,2
         * costs[3] : 0,0,5
         * costs[4] : 0,0,8
         */

        return result;
    }

}
