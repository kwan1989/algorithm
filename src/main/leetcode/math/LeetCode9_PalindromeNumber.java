package leetcode.math;

public class LeetCode9_PalindromeNumber {

    public static void main(String[] args) {
        int x = -121;

        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        StringBuilder strX = new StringBuilder().append(x);
        StringBuilder strXReverse = new StringBuilder().append(x).reverse();

        for (int i = 0; i < strX.length(); i++) {
            if(strX.charAt(i) != strXReverse.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
