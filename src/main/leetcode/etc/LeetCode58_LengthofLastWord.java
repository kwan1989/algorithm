package leetcode.etc;

public class LeetCode58_LengthofLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split("\\s");
        return split[split.length-1].length();
    }
}
