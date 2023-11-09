package etc.sort;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        int[] arrayToSort = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(selectionSort(arrayToSort)));
    }

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // 최솟값을 찾는 과정
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 최솟값과 현재 위치의 값을 교환
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
