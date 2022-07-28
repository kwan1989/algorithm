package programmers;

import java.util.Stack;

public class dfs_타겟넘버_stack {

    private static Stack<Elem> stk = new Stack<>();
    private static int answer =0;

    /**
     * 프로그래머스 DFS/BFS 타겟넘버
     * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
     * @param numbers 배열
     * @param target 타겟
     * @return
     */
    public static int solution(int[] numbers, int target) {

        // 초기값 0(idx) , 0 (val) 출발
        stk.push(new Elem(0, 0));

        // stack 이 비어 있을 때 까지
        while (stk.size() != 0) {
            dfs(numbers, target);
        }

        return answer;
    }

    private static void dfs(int[] numbers, int target) {
        Elem e = stk.pop();         // 스택의 첫번째 값을 가져온다.
        int idx = e.getIdx();       // 데이터의 인덱스값
        int prev = e.getPrev();     // 데이터

        // 값이 타겟 값과 같고 && 인덱스가 마지막 배열길이(뎁스의 마지막이라고 판단) 에 도달 했다면 결과값을 ++
        if ((target == prev) && (idx == numbers.length)) {
            answer ++;
            return;
        }

        // 인덱스 초과
        if (idx >= numbers.length) {
            return;
        }

        // 다음 노드로 스택에 +- 값을 각기 추가
        stk.push(new Elem(idx + 1, prev + numbers[idx]));
        stk.push(new Elem(idx + 1, prev - numbers[idx]));
    }
}

class Elem {
    private int idx;
    private int prev;

    public Elem(int idx, int prev) {
        this.idx = idx;
        this.prev = prev;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getPrev() {
        return this.prev;
    }
}
