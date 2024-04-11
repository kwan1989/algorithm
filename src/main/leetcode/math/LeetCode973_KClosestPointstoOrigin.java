package leetcode.math;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode973_KClosestPointstoOrigin {

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 3;

        System.out.println(Arrays.deepToString(kClosest(points, k)));
        System.out.println(Arrays.deepToString(kClosest_1(points, k)));
        System.out.println(Arrays.deepToString(kClosest_2(points, k)));

    }

    public static int[][] kClosest(int[][] points, int k) {
        // 원점에서의 거리를 기준으로 우선순위를 결정하는 우선순위 큐를 생성합니다.
        // 더 큰 거리를 가진 점이 더 높은 우선순위를 가지도록 설정합니다.
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                // 동일한방법
//                (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])
                (p1, p2) -> (int) ((Math.pow(p2[0], 2) + Math.pow(p2[1], 2)) - (Math.pow(p1[0], 2) + Math.pow(p1[1], 2)))
        );

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.toArray(new int[0][0]);
    }

    public static int[][] kClosest_1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> (int) (Math.pow(p2[0], 2) - Math.pow(p1[0], 2) + Math.pow(p2[1], 2) - Math.pow(p1[1], 2))
        );

        // 모든 점들을 우선순위 큐에 추가합니다.
        for (int[] point : points) {
            pq.offer(point);
        }

        // 결과를 저장할 배열을 생성합니다.
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static int[][] kClosest_2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            double dist1 = Math.sqrt(Math.pow(p1[0], 2) + Math.pow(p1[1], 2));
            double dist2 = Math.sqrt(Math.pow(p2[0], 2) + Math.pow(p2[1], 2));
            return Double.compare(dist1, dist2);
        });

        // 모든 점들을 우선순위 큐에 추가합니다.
        for (int[] point : points) {
            pq.offer(point);
        }

        // 결과를 저장할 배열을 생성합니다.
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }


    /**
     * 유클리디안 거리계산
     * sqrt((x2 - x1)² + (y2 - y1)²)
     *
     * @param point1
     * @param point2
     * @return
     */
    public int calculateSquaredDistance(int[] point1, int[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];

        return (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1); //동일방안
    }

}
