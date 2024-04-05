package leetcode.binarysearch;

public class LeetCode278_FirstBadVersion {
//The isBadVersion API is defined in the parent class VersionControl.
     public static  boolean isBadVersion(int version){
         return true;
     }


    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left < right){
            int mid = left +(right-left) / 2;
            if (isBadVersion(mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int firstBadVersion_1(int n) {
         int left = 0;
         int right = n;

         while( left < right){
             int mid = left + (right-left) / 2;

             if(isBadVersion(mid)){
                 right = mid;
             } else{
                 left = mid + 1;
             }
         }

         return left;
    }
}
