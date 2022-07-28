package programmers;

import java.util.LinkedList;

public class 탐욕법_큰수만들기 {

    public static String solution(String number, int k) {
        String answer = "";

        // 총길이를 파악하는 length
        int length = number.length() - k;

        // 조건값이 안맞다면 리턴
        if (k >= number.length()) {
            return answer;
        }

        LinkedList<Character> definedNumber = new LinkedList<>();

        // 앞에 0 ~ k 까지의
        String left = number.substring(0, k);

        // 뒤에 k ~ length 까지의
        char[] defined = number.substring(k, number.length()).toCharArray();

        // ?
        int index = k - 1;

        // 비교를 하기위한 while
        while (index >= 0) {

            char addChar = left.charAt(index--);
            char preChar = addChar;

            // preChar 로 부터 defined 배열 비교하기위한 반복문
            for (int i = 0; i < defined.length; i++) {

                // preChar 가 더 크다면 preChar 를 defined[i] 로 치환
                // else 라면 반복문 끝끝
                if (preChar >=defined[i]) {
                    char temp = defined[i];
                    defined[i] = preChar;
                    preChar = temp;
                }
                else {
                    // defined 값이 더 크다면 비교 반복문 종료
                    break;
                }
            }

        }

        // defined 내용을 문자열로 변경하기 위한
        StringBuilder sb = new StringBuilder();
        for (char c : defined) {
            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }

}

