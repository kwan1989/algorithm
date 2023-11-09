package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class dfs_여행경로 {





    //방문한지 안한지를 체크하는 visited배열
    static boolean[] visited;
    // 결과
    static ArrayList<String> answers;

    public static String[] solution() {

        String[][] tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        // 운항경로로 방문기록 확인
        visited = new boolean[tickets.length];
        answers = new ArrayList<String>();

        // 몇개의 공항을 들렸는지 알려주는 카운트
        int count = 0;

        // dfs
        dfs_여행경로(count, "ICN", "ICN", tickets);

        // 답들 중 가장 알파벳순이 빠른 배열들로 정렬
        Collections.sort(answers);

        // 가장 빠른 배열을 뽑아서 String형 배열로 만듬
        String[] answer = answers.get(0).split(" ");

        // 결과
        return answer;
    }


    public static void dfs_여행경로(int count, String present, String answer, String[][] ticktes) {

        // 모든 공항을 들렸다면
        if (count == ticktes.length) {

            // answers에 추가
            answers.add(answer);
            return;
        }
        for (int i = 0; i < ticktes.length; i++) {

            // present와 같고 들리지 않은 공항을 찾고
            if (!visited[i] && ticktes[i][0].equals(present)) {

                // 해당 공항을 들린걸로 만듬.
                visited[i] = true;

                // 카운트 +1 도착 공항을 present로 넣어주고 answer에 도착공항을 추가해준다.
                dfs_여행경로(count + 1, ticktes[i][1], answer + " " + ticktes[i][1], ticktes);

                visited[i] = false;
            }
        }
        return;
    }

}
