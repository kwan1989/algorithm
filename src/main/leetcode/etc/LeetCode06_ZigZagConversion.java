package leetcode.etc;

public class LeetCode06_ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        String result = zigzagConversion(s, numRows);
    }


    public static String zigzagConversion(String s, int numRows) {
        String[] numStr = new String[numRows];
        String[] spt = s.split("");
        int numRow = 0;
        boolean isPlus = true;
        String result = "";

        for (int i = 0; i< numStr.length; i++){
            numStr[i] = "";
        }

        for (String str : spt) {
            numStr[numRow] += str;

            if (isPlus) {
                numRow++;
            } else {
                numRow--;
            }

            if (numRow == numStr.length - 1) {
                isPlus = false;
            }
            if (numRow == 0) {
                isPlus = true;
            }
        }

        for (String str : numStr) {
            result += str;
        }
        return result;
    }


}
