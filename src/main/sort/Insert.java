package sort;

import java.util.Arrays;

public class Insert {

    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11};
        System.out.println(Arrays.toString(insertionSort(arrayToSort)));
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // key 값을 이미 정렬된 부분과 비교하여 적절한 위치에 삽입
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }
}
