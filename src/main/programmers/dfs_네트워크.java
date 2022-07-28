package programmers;

public class dfs_네트워크 {
    public static int solution(int n, int[][] computers) {

        int answer = 0;

        // 컴퓨터마다 방문 확인 플레그
        boolean[] visit = new boolean[n];

        // 방문 기록이 없는 컴퓨터는 한대씩 검사를 한다.
        for (int com = 0; com < n; com++) {
            if (!visit[com]) {
                DFS(computers, com, visit);
                answer++;
                System.out.println("@ result Count[MAIN] : " + answer);
            }
        }

        return answer;
    }

    /**
     * 컴퓨터의 네트워크 노드를 확인 한다.
     *
     * @param computers 노드 연결 상태
     * @param com       현재 컴퓨터 idx
     * @param visit     방문 여부
     */
    public static void DFS(int[][] computers, int com, boolean[] visit) {

        try {
            // 방문완료(컴퓨터)
            visit[com] = true;
            System.out.println("visited Computer[DFS] : " + com );


            // TODO   무조건 2배열의 데이터값을 가져와야 된다 생각했다.
            //        그러나 노드의 개수는 컴퓨터의 개수와 동일하므로 컴퓨터 개수로만 처리한다.
            for (int node = 0; node < computers.length; node++) {

                // 조건 1) 자기 자신의 노드는 무조건 1이므로 제외
                // 조건 2) 해당 노드의 방문을 안했었고
                // 조건 3) 값이 1 이라면 연결상태로 파악 한다.
                if (com != node && !visit[node] && computers[com][node] == 1) {
                    //print
                    System.out.println("in Network(com : " + com + " / node : "  + node + ")");
                    DFS(computers, node, visit);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
