package leetcode.binarysearch;

import java.util.Arrays;

public class LeetCode1095_FindinMountainArray {

    // Your MountainArray implementation
    class MountainArrayImpl implements MountainArray {
        private int[] mountainArray;

        // Initialize the mountain array with a given int array
        public MountainArrayImpl(int[] array) {
            mountainArray = Arrays.copyOf(array, array.length);
        }

        @Override
        public int get(int index) {
            return mountainArray[index];
        }

        @Override
        public int length() {
            return mountainArray.length;
        }

        @Override
        public void set(int[] array) {
            this.mountainArray = array;
        }

    }

    interface MountainArray {
        int get(int index);

        int length();

        void set(int[] array);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 3, 1};
        int target1 = 3;

        int[] array2 = {0,1,2,4,2,1};
        int target2 = 3;
        System.out.println(findInMountainArray(target1, array1));
        System.out.println(findInMountainArray(target2, array2));
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int maxValueIdx = getMaxValueIdx(mountainArr);
        int findFirst = binarySearch(mountainArr, target, 0, maxValueIdx, true);
        int findSecond = binarySearch(mountainArr, target, maxValueIdx, mountainArr.length - 1, false);
        return Math.min(findFirst, findSecond);
    }

    public static int getMaxValueIdx(int[] arr) {
        int max = arr[0];
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int binarySearch(int[] arr, int target, int startIdx, int endIdx, boolean orderASC) {
        int left = startIdx;
        int right = endIdx;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                // 원하는 값 찾음, 인덱스 반환
                return mid;
            } else if (arr[mid] < target) {

                if (orderASC) {
                    // [오름차순] 목표값이 중앙값보다 크므로 오른쪽으로 이동
                    left = mid + 1;
                } else {
                    // [내림차순] 목표값이 중앙값보다 작으므로 오른쪽으로 이동
                    right = mid - 1;
                }
            } else {
                if (orderASC) {
                    // [오름차순] 목표값이 중앙값보다 작으므로 왼쪽으로 이동
                    right = mid - 1;
                } else {
                    // [내림차순] 목표값이 중앙값보다 크므로 왼쪽으로 이동
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
