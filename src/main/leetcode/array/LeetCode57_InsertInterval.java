package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 이 문제 어렵다 다시 풀어야함.
 * 기존의 구간 배열 (intervals) :
 * [1, 2], [3, 5], [6, 7], [8, 10], [12, 16]
 * <p>
 * 새로운 구간 (newInterval) :
 * [4, 8]
 * <p>
 * 1. 새로운 구간의 시작점보다 끝점이 먼저인 구간들을 결과 목록에 추가합니다.
 * 결과 목록 :
 * [1, 2]
 * <p>
 * 2. 새로운 구간과 겹치는 모든 구간을 찾아서 병합합니다.
 * - [3, 5]와 [4, 8]은 겹치므로 병합하여 [3, 8]를 얻습니다.
 * - [3, 8]과 [6, 7]은 겹치므로 병합하여 [3, 8]를 얻습니다.
 * - [3, 8]과 [8, 10]은 겹치므로 병합하여 [3, 10]를 얻습니다.
 * 병합된 구간을 결과 목록에 추가합니다.
 * 결과 목록 :
 * [1, 2], [3, 10]
 * <p>
 * 3. 나머지 구간들을 결과 목록에 추가합니다.
 * 결과 목록 :
 * [1, 2], [3, 10], [12, 16]
 */
public class LeetCode57_InsertInterval {

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
//        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the union of intervals we got

        // Add all the rest
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }

//    public static int[][] insert2(int[][] intervals, int[] newInterval) {
//        List<int[]> result = new ArrayList<>();
//
//
//        for (int[] interval : intervals) {
//            int[] item = new int[2];
//
//            if (isBetween(interval, newInterval)){
//                item[0] = Math.min(interval[0], newInterval[0]);
//                item[1] = Math.max(interval[1], newInterval[1]);
//            } else {
//                item = interval;
//            }
//
//            result.add(item);
//        }
//
//        return result.toArray(new int[result.size()][]);
//    }
//
//    public static boolean isBetween(int[] interval, int[] newInterval) {
//        if (interval[0] < newInterval[1]
//                && interval[0] >= newInterval[0]) {
//            return true;
//        }
//
//        if (interval[1] > newInterval[0]
//                && interval[1] <= newInterval[1]){
//            return true;
//        }
//
//        return false;
//    }

}
