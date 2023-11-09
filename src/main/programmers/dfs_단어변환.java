package programmers;

import java.util.Arrays;
import java.util.Stack;


public class dfs_단어변환 {
    public static int solution(String begin, String target, String[] words) {

        // words 배열 조회 후 target 문자열이 없다면 리턴한다.
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // 하나만 다른 단어가 있는지 찾아야 된다.
        // 스택에 begin 문자를 추가한다.
        Stack begins = new Stack<String>();
        begins.add(begin);

        int cnt = 0;

        // 스택이 비어있지 않다면 계속 반복한다.
        while (!begins.isEmpty()) {

            // 스택에 값을 문자열로 begin2 = begins
            // 그리고 스택에서 빼준다.
            String begin2 = (String) begins.pop();

            // words 의 문자를 하나씩 비교하기위해 배열 반복
            // begin2 문자와 words 배열의 문자들과 비교해서 1글자 차이 나는 문자를 찾는다.
            for (int i = 0; i < words.length; i++) {

                // words 의 문자열을 word 로
                String word = words[i];

                // 다른 값이 1자리라면 (begin 값과 words[i] 값의 자리수를 비교한다.)
                if (diffChar(begin2, word) == 1) {

                    // target 과 word 와 값이 같다면
                    if (target.equals(word)) {
                        // 같다면 cnt ++
                        return cnt + 1;
                    } else {
                        // 다르다면 stack Add
                        begins.add(word);
                    }
                }

            }

            cnt++;
        }
        return 0;
    }

    private static int diffChar(String text1, String text2) {
        int diff = 0;
        for (int i = 0; i < text1.length(); i++) {

            char chartxt1 = text1.charAt(i);
            char chartxt2 = text2.charAt(i);

            if (chartxt1 != chartxt2) {
                diff++;
            }
        }
        return diff;
    }


}
