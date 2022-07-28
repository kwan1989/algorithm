package programmers;

public class dfs_타겟넘버_recursive {

    /**
     * 프로그래머스 DFS/BFS 타겟넘버
     * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
     * @param numbers
     * @param target
     * @return
     */
    public static int solution(int[] numbers, int target) {
        try {
            int answer = DFS(0, 0, numbers, target);
            return answer;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return 0;
        }

    }

    /**
     *
     * @param depth 시작 뎁스는 0 시작
     * @param sum 누적값은 0 시작
     * @param numbers 배열
     * @param target 목표값
     * @return
     */
    public static int DFS(int depth, int sum, int[] numbers, int target) {

        System.out.println(depth);

        // depth 가 전체 노드길이를 를 순회했을 때
        if (depth == numbers.length) {

            // 누적 값이 타겟값과 동일하다면
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        /*
         + 연산은 ← 노드 / - 연산은 → 노드
         1. depth - 다음 하위 노드로 내려가기 위한 ++
         2. sum - 기존 누적값에 다음 뎁스의 노드값을 [+] & [-] 값을 누적? < 사실 이부분이 좀 어렵습니다
         3. numbers - 배열
         4. target - 목표 누적값
         */
        return  DFS(depth + 1, sum + numbers[depth + 1], numbers, target)
                +
                DFS(depth + 1, sum - numbers[depth + 1], numbers, target);
    }
}


















