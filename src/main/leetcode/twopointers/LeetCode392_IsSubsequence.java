package leetcode.twopointers;

public class LeetCode392_IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "ahbgdc"));    // true
        System.out.println(isSubsequence("b", "abc"));      // true
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int indexS = 0;
        int indexT = 0;

        while( indexT < t.length()){
            if (t.charAt(indexT) == s.charAt(indexS)){
                indexS++;
                if (indexS == s.length()){
                    return true;
                }
            }
            indexT++;
        }
        return false;
    }
}
