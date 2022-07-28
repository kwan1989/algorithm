package programmers;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {


    public static int[] solution(int n, String[] words) {
        int[] answer = new int[] {0,0};
        List<String> list = new ArrayList<String>();

        for(int i=0; i<words.length; i++){

            // 이전에 등장한 단어인경우
            if(list.contains(words[i]) ||
                    (i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0))){

                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }

            // 현재 단어 리스트에 넣기
            list.add(words[i]);

        }

        return answer;
    }





}
