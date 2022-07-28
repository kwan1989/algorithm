package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 프로그래머스 스택/큐 프린터
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class 스택큐_프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 1;

            // 기존 priorities 를 [idx, val] 타입으로 큐에 쌓아준다.
            Queue<Print> que = new ArrayDeque<Print>();
            for (int i = 0; i < priorities.length; i++) {
                que.add(new Print(i, priorities[i]));
            }

            while (true) {

                Print first = que.poll();

                for (Print pt : que) {
                    if (first.getVal() < pt.getVal()) {
                        que.add(first);
                        first = null;
                        break;
                    }
                }

                if (first != null) {
                    if (location == first.getIdx()) {
                        return answer;
                    } else {
                        answer++;
                    }
                }
            }
    }


    /**
     * Class
     */
    static class Print implements Comparable<Print> {

        private int idx;    // 배열에 들어가있는 순서
        private int val;    // 값

        public Print(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(Print pt) {
            return this.val >= pt.val ? 1 : -1;
        }


    }


}
