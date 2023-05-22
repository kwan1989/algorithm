package leetcode.etc;

import java.util.ArrayList;

public class LeetCode27_RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
//        int val = 3;

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {

        int result = 0;
        int resultIdx = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val){
                result ++;
            } else{
                nums[resultIdx++] = nums[i];
            }
        }

        return nums.length - result;
    }

}