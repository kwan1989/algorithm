package leetcode.twopointers;

import java.util.Arrays;

public class LeetCode881_BoatstoSavePeople {

    public static void main(String[] args) {
//        int[] people = {3, 5, 3, 4}; int limit = 5;
        int[] people = {3,2,2,1}; int limit = 3;


        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int count = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {

            int sum = people[left] + people[right];

            if (sum <= limit) {
                // 좌우 합산이 제한 범위 내면 간격 축소
                left++;
                right--;
            } else {
                // 제한범위를 벗어났으면 라이트 큰값으로 대체
                right--;
            }

            // 범위를 벗어나든 안벗어나든 카운트가 증가한다.
            count++;
        }

        return count;
    }
}
