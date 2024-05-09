package leetcode.binarysearch;

public class LeetCode278_FirstBadVersion {
    //The isBadVersion API is defined in the parent class VersionControl.
    public static boolean isBadVersion(int version) {
        return true;
    }


    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 특정 mid 값을 찾는게 아니라면, 만족하는 첫번째 요소를 검색하는 것이 목적이다,
     * right = mid - 1 을 사용하지 않는건, mid 가 해당 요소 일수 있으므로
     * @param n
     * @return
     */
    public static int firstBadVersion_1(int n) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
