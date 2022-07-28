package programmers;

import java.util.ArrayList;

public class 연습문제_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        int[] answer = {};

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (al.get(al.size() - 1) != arr[i]) {
                al.add(arr[i]);
            }
        }


        answer = al.stream().mapToInt(i->i).toArray();


        return answer;
    }
}
