package programmers;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/85002
 *
 * 문제 설명
 * 복서 선수들의 몸무게 weights와, 복서 선수들의 전적을 나타내는 head2head가 매개변수로 주어집니다. 복서 선수들의 번호를 다음과 같은 순서로 정렬한 후 return 하도록 solution 함수를 완성해주세요.
 *
 * 1. 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
 * 2. 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
 * 3. 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
 * 4. 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
 *
 * 제한사항
 * weights의 길이는 2 이상 1,000 이하입니다.
 *      weights의 모든 값은 45 이상 150 이하의 정수입니다.
 *      weights[i] 는 i+1번 복서의 몸무게(kg)를 의미합니다.
 * head2head의 길이는 weights의 길이와 같습니다.
 *      head2head의 모든 문자열은 길이가 weights의 길이와 동일하며, 'N', 'W', 'L'로 이루어진 문자열입니다.
 *      head2head[i] 는 i+1번 복서의 전적을 의미하며, head2head[i][j]는 i+1번 복서와 j+1번 복서의 매치 결과를 의미합니다.
 *          'N' (None)은 두 복서가 아직 붙어본 적이 없음을 의미합니다.
 *          'W' (Win)는 i+1번 복서가 j+1번 복서를 이겼음을 의미합니다.
 *          'L' (Lose)는 i+1번 복사가 j+1번 복서에게 졌음을 의미합니다.
 *      임의의 i에 대해서 head2head[i][i] 는 항상 'N'입니다. 자기 자신과 싸울 수는 없기 때문입니다.
 *      임의의 i, j에 대해서 head2head[i][j] = 'W' 이면, head2head[j][i] = 'L'입니다.
 *      임의의 i, j에 대해서 head2head[i][j] = 'L' 이면, head2head[j][i] = 'W'입니다.
 *      임의의 i, j에 대해서 head2head[i][j] = 'N' 이면, head2head[j][i] = 'N'입니다.
 *
 * 테스트 1 〉	통과 (1.05ms, 73.8MB)
 * 테스트 2 〉	통과 (1.16ms, 78MB)
 * 테스트 3 〉	통과 (1.06ms, 74.3MB)
 * 테스트 4 〉	통과 (1.11ms, 75MB)
 * 테스트 5 〉	통과 (0.81ms, 73.2MB)
 * 테스트 6 〉	통과 (31.97ms, 80.6MB)
 * 테스트 7 〉	통과 (31.51ms, 83.7MB)
 * 테스트 8 〉	통과 (50.87ms, 97.4MB)
 * 테스트 9 〉	통과 (19.77ms, 86.4MB)
 * 테스트 10 〉	통과 (10.97ms, 91.5MB)
 * 테스트 11 〉	통과 (23.57ms, 87.6MB)
 * 테스트 12 〉	통과 (24.14ms, 89MB)
 */
public class 위클리챌린지06_복서정렬하기 {

    public static void main(String[] args) {

//        // TC1 - 3412
        int[] weights = {50, 82, 75, 120};
        String[] head2head = {"NLWL", "WNLL", "LWNW", "WWLN"};

//        // TC2 - 231
//        int[] weights = {145,92,86};
//        String[] head2head = {"NLW", "WNL", "LWN"};

//        // TC3 - 213
//        int[] weights = {60,70,60};
//        String[] head2head = {"NNN", "NNN", "NNN"};


        int[] result = solution(weights, head2head);
    }

    static class Boxer {
        int no;
        int weight;
        double winRate;
        int winOver;

        public Boxer(int no, int weight, double winRate, int winOver) {
            this.no = no;
            this.weight = weight;
            this.winRate = winRate;
            this.winOver = winOver;
        }
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Boxer> boxerList = new ArrayList<>();


        /**
         * 각 복서별 스펙 리스트 작성
         * 1. No
         * 2. Wight
         * 3. WinRate
         * 4. WinOver
         */
        // 인원 만큼
        for (int i = 0; i < weights.length; i++) {

            double winCnt = 0.0;    // 승 (연산 부동소수점)
            double totCnt = 0.0;    // 총 (연산 부동소수점)
            int overCnt = 0;        // 오버스펙 승점

            // head2head 의 승점 파악 문자열 분할
            char[] chaWinLose = head2head[i].toCharArray();

            for (int j = 0; j < chaWinLose.length; j++) {

                // TODO : if(i==j) continue; 에서 아래 조건으로 변경했다.. i==j continue; 조건일 때 TC2~4, TC6~10 이 문제가 된다... 이유가 뭐지?
                // 자문자답 : 자기자신만 'N' 이 존재 하는지 알았다.. 다른선수와 경기를 안한 N 의 경우도 존재한다!!
                // 자기 자신이면 패스 (N이므로)
                //if (i == j) continue;
                if (chaWinLose[j] != 'N') {

                    // 경기 카운트
                    totCnt++;

                    // 승리 카운트
                    if (chaWinLose[j] == 'W') {
                        winCnt++;

                        // 자기 보다 체급이 높은 복서를 이기는 카운트
                        if (weights[i] < weights[j]) overCnt++;
                    }
                }
            }

            // 승률
            double winRate = winCnt / totCnt * 100;

            // 결과값이 인덱스가 1부터 시작이므로 i+1 = 1 로 넣어야됨.
            Boxer boxer = new Boxer(i + 1, weights[i], winRate, overCnt);
            boxerList.add(boxer);
        }

        /**
         * 1. 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
         * 2. 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
         * 3. 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
         * 4. 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
         *
         * 위 내용을 정리하면
         * 1. 승률 (DESC)
         * 2. 오버체급 승률 (DESC)
         * 3. 자기 무게 (DESC)
         * 4. 인덱스 (ASC)
         */
        Collections.sort(boxerList, new Comparator<Boxer>() {
            @Override
            public int compare(Boxer o1, Boxer o2) {

                // 1. 승률
                if (o1.winRate > o2.winRate) {
                    return -1;
                } else if (o1.winRate < o2.winRate) {
                    return 1;
                } else {

                    // 2. 오버체급 승률
                    if (o1.winOver > o2.winOver) {
                        return -1;
                    } else if (o1.winOver < o2.winOver) {
                        return 1;
                    } else {

                        // 3. 자기 무게
                        if (o1.weight > o2.weight) {
                            return -1;
                        } else if (o1.weight < o2.weight) {
                            return 1;
                        } else {

                            // 4. 인덱스
                            if (o1.no > o2.no) {
                                return 1;
                            } else if (o1.no < o2.no) {
                                return -1;
                            }
                        }
                    }
                }
                return 0;
            }
        });


        // Convert int[]
        for (int i = 0; i < boxerList.size(); i++) {
            answer[i] = boxerList.get(i).no;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }


}
