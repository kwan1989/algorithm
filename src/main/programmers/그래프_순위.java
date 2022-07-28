package programmers;

public class 그래프_순위 {

    /**
     *  https://programmers.co.kr/learn/courses/30/lessons/49191?language=java
     *
     * 문제 설명
     * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
     *
     * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 선수의 수는 1명 이상 100명 이하입니다.
     * 경기 결과는 1개 이상 4,500개 이하입니다.
     * results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
     * 모든 경기 결과에는 모순이 없습니다.
     *
     * 입출력 예
     * n	results	                                    return
     * 5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
     * 입출력 예 설명
     * 2번 선수는 [1, 3, 4] 선수에게 패배했고 5번 선수에게 승리했기 때문에 4위입니다.
     * 5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.
     *
     *
     * 테스트 1 〉	통과 (0.04ms, 52.7MB)
     * 테스트 2 〉	통과 (0.03ms, 52.3MB)
     * 테스트 3 〉	통과 (0.06ms, 52.8MB)
     * 테스트 4 〉	통과 (0.16ms, 53.1MB)
     * 테스트 5 〉	통과 (1.01ms, 53MB)
     * 테스트 6 〉	통과 (2.40ms, 52.7MB)
     * 테스트 7 〉	통과 (11.35ms, 55MB)
     * 테스트 8 〉	통과 (9.78ms, 54.8MB)
     * 테스트 9 〉	통과 (16.13ms, 57MB)
     * 테스트 10 〉	통과 (16.68ms, 57.1MB)
     *
     * @param n
     * @param results
     * @return
     */
    public static int solution(int n, int[][] results) {
        /**
         * 1. [false, true, false, false, false]
         * 2. [false, false, false, false, true]
         * 3. [false, true, false, false, false]
         * 4. [false, true, true, false, false]
         * 5. [false, false, false, false, false]
         *
         * result → resultTable 위의 초기값 설정
         * 하..계산 하기 쉽게 1배열 부터 0배열 버린다..
         */
        boolean[][] resultTable = new boolean[n + 1][n + 1];

        for (int[] player : results) {
            int winner = player[0];
            int loser = player[1];
            resultTable[winner][loser] = true;
        }

        // 승패 구도 테이블 작성
        resultTable = drawGraph(n, resultTable);

        // 명확한 순위 측정 개수 측정
        return exactRank(n, resultTable);

    }

    /**
     * 승/패 구도 테이블 작성
     *
     * @param n     노드 개수
     * @param table 초기 값
     * @return
     */
    private static boolean[][] drawGraph(int n, boolean[][] table) {
        /**
         * 배열의 시작점을 계산하기 쉽게 1부터 시작했으므로 1부터 잡아준다.
         *
         * k = 중간노드(거치는)
         * i = 시작노드(출발점)
         * j = 도착노드(도착점)
         *
         * 1. [출발] → [중간]
         * 2. [중간] → [도착] 이라면
         * 3. [출발] → [도착] 이 된다.
         *
         * 위 와 같은 상황을 표현 예시로 든 조건으로 입력값이 기입되었을 때
         * 1. [false, true, false, false, true]
         * 2. [false, false, false, false, true]
         * 3. [false, true, false, false, true]
         * 4. [false, true, true, false, true]
         * 5. [false, false, false, false, false]
         *
         * 이 결과로 [A(이김)] → [B(A에게지고 C는 이김)] → [C(B에게 지므로 A에겐 당연히 패배)] 구도 완성
         */
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (table[i][k] && table[k][j]) {
                        table[i][j] = true;
                    }
                }
            }
        }
        return table;
    }

    /**
     * 경기승자 테이블의 결과물로 경기수를 찾아낸다.
     *
     * @param n     노드 개수
     * @param table 승패의 관계가 정의 된 테이블
     * @return
     */
    private static int exactRank(int n, boolean[][] table) {

        int result = 0;

        // winner
        for (int i = 1; i < n + 1; i++) {
            int cntMatch = 0;

            System.out.println("Start Player : " + i);

            // loser
            for (int j = 1; j < n + 1; j++) {
                //System.out.println("resultTable[i][j] [bool] : [" + Integer.toString(i) + "][" + Integer.toString(j) + "] [" + table[i][j] + "]" );
                if (table[i][j]){
                    // [i] ↔ [j] 관계가 [i] 가 승자인 경우
                    cntMatch ++;
                    System.out.println("resultTable[i][j] [bool] : [" + Integer.toString(i) + "][" + Integer.toString(j) + "] [" + table[i][j] + "(WIN)] cntMatch : " + cntMatch);
                } else if (table[j][i]){
                    // [i] ↔ [j] 관계가 [j] 가 승자인 경우 (경기를 진행했다)
                    cntMatch++;
                    System.out.println("resultTable[j][i] [bool] : [" + Integer.toString(j) + "][" + Integer.toString(i) + "] [" + table[i][j] + "(LOSE)] cntMatch : " + cntMatch);
                }
            }

            /**
             * 승점으로 완벽한 경기수를 확인함
             * 예를 들어, 인원이 5명인데 4번 경기하면 무조건적인 순위가 결정 된다. (자기 자신은 제외한 숫자)
             */
            if (cntMatch == n-1){
                result ++;
                System.out.println("Result Player : " + i + " | cntResult : " + result + " | cntMatch : " + cntMatch);
            }
        }
        return result;
    }
}
