package programmers;

import java.util.Arrays;

public class 해시_완주하지_못한_선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        String temp = "";


        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        while (i < completion.length){
            if (!completion[i].equals(participant[i])){
                temp = participant[i];
                break;
            } else{
                i++;
            }
        }

        if (!temp.equals("")){
            answer = temp;
        } else{
            answer = participant[participant.length-1];
        }


        return answer;
    }
}
