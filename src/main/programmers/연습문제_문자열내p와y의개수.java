package programmers;

public class 연습문제_문자열내p와y의개수 {
    public static boolean solution(String s) {
        boolean answer = true;

        char[] cha = s.toCharArray();
        String temp = "";

        int pCnt = 0;
        int yCnt = 0;

        for (int i = 0; i < cha.length; i++) {
            temp = cha[i] + "";
            if (temp.toUpperCase().equals("P")) {
                pCnt++;
            } else if (temp.toUpperCase().equals("Y")) {
                yCnt++;
            }
        }

        if (pCnt == yCnt) {
            answer = true;
        } else if (pCnt == 0 && yCnt == 0) {
            answer = true;
        } else{
            answer =false;
        }


        return answer;
    }
}
