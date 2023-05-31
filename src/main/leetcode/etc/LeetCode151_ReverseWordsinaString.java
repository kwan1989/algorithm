package leetcode.etc;

public class LeetCode151_ReverseWordsinaString {

    public static void main(String[] args) {
//        String s = "the sky is blue";
        String s = "a good   example";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s");

        for (int i = words.length - 1; i >= 0; i--) {

            if (words[i].equals("")){
                continue;
            }

            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

}
