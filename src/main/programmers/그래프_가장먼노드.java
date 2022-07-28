package programmers;

import java.util.*;

public class 그래프_가장먼노드 {

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/49189?language=java
     * <p>
     * 문제 설명
     * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
     * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
     * <p>
     * 제한사항
     * 노드의 개수 n은 2 이상 20,000 이하입니다.
     * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
     * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
     * <p>
     * 입출력 예
     * n	vertex	return
     * 6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
     *
     * @param n
     * @param edge
     * @return
     */
    public static int solution(int n, int[][] edge) {
        return furthestNode(n, edge);
    }

    private static int furthestNode(int n, int[][] edge) {
        int answer = 0;

        // 현재 큐 상태
        Queue<Integer> queCurr = new LinkedList<>();

        // 다음 Depth(?)
        Queue<Integer> queNext = new LinkedList<>();

        // 방문확인
        //boolean[] visit = new boolean[edge.length];

        // 노드를 맵으로 표현
        Map<Integer, LinkedList<Integer>> map = drawGraph(n, edge);
        boolean[] visit = new boolean[map.size() + 1];
        //boolean[] visit = new boolean[n+1];

        // 시작값은 1
        queCurr.add(1);
        visit[1] = true;
        int count = 1;
        int depth = 0;

        //System.out.println("☆[depth/que] " + depth + " / " + queCurr);

        // 현재 큐 상태가 비어있지 않다면
        while (!queCurr.isEmpty()) {

            // 방문한 노드를 큐에서 추출하고 값을 출력
            int currNode = queCurr.poll();

            // 인접한 모든 노드를 가져온다.
            List<Integer> lst = map.get(currNode);

            //System.out.println("[currNode/sub] " + currNode + " / " + lst);

            for (int sub : lst) {
                if (!visit[sub]) {
                    visit[sub] = true;
                    queNext.add(sub);
                    count++;
                    //System.out.println("□[Visit(sub)] " + sub);
                } else {
                    //System.out.println("■[Visited(sub)]] " + sub);
                }
            }

            // 현재 큐에 동작이 완료되었고, 넥스트큐에는 데이터가 존재함 (다음뎁스진행)
            if (queCurr.isEmpty() && queNext.size() > 0) {

                depth++;

                // 넥스트를 현재 큐로
                queCurr = queNext;

                //System.out.println("☆[depth/que] " + depth + " / " + queCurr);

                // 넥스트 초기화
                queNext = new LinkedList<>();

                if (count == n) {
                    answer = queCurr.size();
                }
            }
        }

        return answer;
    }
    /**
     * edge 의 노드 간선을 Map 으로 정렬
     * 시간복잡도 해결x
     * @param edge
     * @return [edge] → Map[edge]
     */
//    private static Map<Integer, List<Integer>> drawGraph(int n, int[][] edge) {
//
//        // Map
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        // 키값 얻기 - 중복을 제거하기위해 hs사용
//        HashSet<Integer> hskeys = new HashSet<>();
//        for (int[] node : edge) {
//            for (int i = 0; i < node.length; i++) {
//                hskeys.add(node[i]);
//            }
//        }
//        // hs → ArrayList 변경
//        List<Integer> keys = new ArrayList();
//        keys.addAll(hskeys);
//
//        // 키 값으로 전체 노드 간선을 확인하며 추가한다.
//        for (int k = 0; k < keys.size(); k++) {
//            int key = keys.get(k);
//            List<Integer> values = new ArrayList<Integer>();
//            for (int i = 0; i < edge.length; i++) {
//                for (int j = 0; j < edge[1].length; j++) {
//                    if (key == edge[i][j]) {
//                        if (j == 0) {
//                            values.add(edge[i][1]);
//                        } else {
//                            values.add(edge[i][0]);
//                        }
//                    }
//                }
//            }
//            map.put(key, values);
//        }
//        System.out.println(map);
//        return map;
//    }


    /**
     * edge 의 노드 간선을 Map 으로 정렬
     * 시간복잡도 해결 - 잡부님 구조 참조
     *
     * @param edge
     * @return [edge] → Map[edge]
     */
    private static Map<Integer, LinkedList<Integer>> drawGraph(int n, int[][] edge) {

        // Map
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();


        // 키 값으로 전체 노드 간선을 확인하며 추가한다.
        for (int[] node : edge) {
            LinkedList<Integer> edgeList;

            for (int i = 0; i < 2; i++) {

                int mainNode = node[i];
                int subNode = node[i == 1 ? 0 : 1];

                //내 노드의 인접노드 리스트가 없으면 생성해준다.
                if (!map.containsKey(mainNode)) {
                    edgeList = new LinkedList < Integer > ();
                    map.put(mainNode, edgeList);
                }

                //내 노드의 인접노드 리스트를 가지고 와서 서브노드를 집어 넣는다.
                edgeList = map.get(mainNode);
                edgeList.add(subNode);

            }
        }


        //System.out.println(map);
        return map;
    }


}