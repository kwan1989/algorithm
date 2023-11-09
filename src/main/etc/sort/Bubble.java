package etc.sort;

import java.util.Arrays;

public class Bubble {

    public static void main(String[] args) {
        int[] arrayToSort = {64, 34, 25, 12, 22, 11};
        System.out.println(Arrays.toString(bubbleSort(arrayToSort)));
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 인접한 요소들끼리 비교하여 순서를 바꿈
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

}
