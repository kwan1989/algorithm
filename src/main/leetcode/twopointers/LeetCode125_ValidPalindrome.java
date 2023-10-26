package leetcode.twopointers;

public class LeetCode125_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = getString(s);
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;


        while (left < right) {
            if (ch[left] != ch[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String getString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString().toUpperCase();
    }

}
