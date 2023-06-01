package leetcode.etc;

public class LeetCode917_ReverseOnlyLetters {

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";

        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String s) {

        int i = 0;
        int j = s.length()-1;

        char[] cha = s.toCharArray();

        while (i < j){

            if (!Character.isLetter(cha[i])){
                i++;
            } else if (!Character.isLetter(cha[j])){
                j--;
            } else {
                char temp = cha[i];
                cha[i] = cha[j];
                cha[j] = temp;

                i++;
                j--;
            }
        }

        return String.valueOf(cha);

    }

}
