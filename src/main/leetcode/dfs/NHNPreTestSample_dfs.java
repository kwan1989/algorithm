package leetcode.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 문제
 * 모든 원소가 0 또는 1 인 행렬이 있습니다. 1 로 표시된 원소는 영역을 나타냅니다. 여기에서 상하좌우에 인접한 1
 * 은 같은 영역이라고 가정합니다. 각 영역의 크기는 1 의 개수로 정의합니다. 주어진 N x N 크기의 행렬에서 영역의
 * 개수와 각 영역의 크기를 오름차순으로 출력하세요.
 * [입력]
 * • 첫 번째 행은 행렬의 크기인 N입니다. N 은 1 이상 10 이하의 자연수입니다.
 * • 입력 두 번째 행부터는 공백으로 구분된 0 과 1 로 행렬이 주어집니다. 각 행은 개행 문자(newline, \n)로
 * 구분됩니다.
 * [출력]
 * • 첫 번째 행은 영역의 개수를 출력합니다.
 * • 두 번째 행은 각 영역의 크기를 공백으로 구분하여 오름차순으로 출력합니다.
 * • 한 행의 끝은 불필요한 공백 없이 개행 문자(newline, \n)로 끝나야 합니다.
 * • 영역이 존재하지 않을 경우 영역 수 0으로 1 행으로만 출력합니다.
 * [행렬 및 영역 예시]
 * 영역은 3개이며, 각 영역의 크기는 4, 5, 7입니다.
 * 아래 테스트 케이스에서 예제로 2 개를 오픈하므로 별도로 예를 들 필요가 없습니다.
 * <p>
 * 6
 * 0 1 1 0 0 0
 * 0 1 1 0 1 1
 * 0 0 0 0 1 1
 * 0 0 0 0 1 1
 * 1 1 0 0 1 0
 * 1 1 1 0 0 0
 * <p>
 * 3
 * 4 5 7
 * <p>
 * <p>
 * <p>
 * 4
 * 1 0 0 0
 * 1 0 0 0
 * 0 0 0 0
 * 0 0 1 1
 * <p>
 * 2
 * 2 2
 */
public class NHNPreTestSample_dfs {

    public static void main(String[] args) {
        preTest();
    }

    public static void preTest() {
        Scanner scanner = new Scanner(System.in);

        // 행열 크기
        int n = scanner.nextInt();

        // 개행
        scanner.nextLine();

        // 행열 입력
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = scanner.nextLine().split("\\s");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        List<Integer> result = calculateArea(matrix, n);

        Collections.sort(result);

        System.out.println(result);

    }

    private static List<Integer> calculateArea(int[][] matrix, int n) {
        List<Integer> areas = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    int area = dfs(matrix, visited, i, j);
                    areas.add(area);
                }
            }
        }

        return areas;
    }


    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static int dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        if (row < 0
                || row >= matrix.length
                || col < 0
                || col >= matrix[0].length
        ) {
            return 0;
        }

        if (visited[row][col] || matrix[row][col] == 0) {
            return 0;
        }

        int count = 1;
        visited[row][col] = true;

        for (int dir = 0; dir < DR.length; dir++) {
            count += dfs(matrix, visited, row + DR[dir], col + DC[dir]);
        }

        return count;

    }
}
