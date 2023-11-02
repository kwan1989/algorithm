package leetcode.binarysearch;

import java.util.Arrays;
import java.util.TreeSet;

public class LeetCode1095_FindinMountainArray {

    // Your MountainArray implementation
   static class MountainArrayImpl implements MountainArray {
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
        MountainArray array1 = new MountainArrayImpl(new int[] {1,2,3,4,5,3,1});
        int target1 = 3;

        MountainArray array2 = new MountainArrayImpl(new int[] {0,1,2,4,2,1});
        int target2 = 3;
        System.out.println(findInMountainArray(target1, array1));
        System.out.println(findInMountainArray(target2, array2));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int max = getMaxValueIndex(mountainArr);

        int first = binarySearch(target, mountainArr, 0, max, true);

        if (first != -1){
            return first;
        }

        return binarySearch(target, mountainArr, max, mountainArr.length()-1, false);
    }

    public static int getMaxValueIndex (MountainArray mountainArr){
        int left = 0;
        int right = mountainArr.length() - 1;

        while(left < right){
            int mid = left + (right-left) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid+1)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int binarySearch(int target, MountainArray mountainArr, int left, int right, boolean orderASC){
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(mountainArr.get(mid) == target){
                return mid;
            } else if(mountainArr.get(mid) < target){
                if(orderASC){
                    // [오름차순] 목표값이 중앙값보다 크므로 오른쪽으로 이동
                    left = mid + 1;
                } else {
                    // [내림차순] 목표값이 중앙값보다 작으므로 오른쪽으로 이동
                    right = mid - 1;
                }
            } else {
                if(orderASC){
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
