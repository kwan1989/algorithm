package programmers;

public class dfs_타겟넘버 {
    /**
     * https://sas-study.tistory.com/248
     * @param numbers
     * @param target
     * @return
     */
    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);
        return answer;
    }


    /**
     * 깊이우선탐색
     *
     * @param numbers 배열
     * @param depth   깊이
     * @param sum     누적 합계
     * @param target  타겟 값
     * @return
     */
    public static int dfs(int[] numbers, int depth, int sum, int target) {

        // 뎁스가 배열총 길이와 같다면 끝낸걸로 파악한다.
        if (numbers.length == depth) {

            if (sum == target) {
                // 누적 값이 타겟 값과 동일하다면 조건이 맞으므로 ++
                return 1;
            } else {
                // 누적 값이 타겟 값과 동일하지 않으므로 아무 처리 하지 않는다.
                return 0;
            }
        }
        return dfs(numbers, depth + 1, sum + numbers[depth], target) +
                dfs(numbers, depth + 1, sum - numbers[depth], target);
    }

}