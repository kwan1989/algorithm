package programmers;

import java.util.ArrayList;

public class 카카오블라인드_비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        ArrayList<String> al = new ArrayList<String>();

            for (int i = 0; i < arr1.length; i++) {
                String strSum = "";
                String[] strBinary = new String[2];
                strBinary[0] = toBinary(arr1[i], n);
                strBinary[1] = toBinary(arr2[i], n);
                for (int k = 0; k< strBinary[0].length(); k++){
                    strSum += toSum(strBinary[0], strBinary[1], k);
                }
                String temp = toSharp(strSum);
                al.add(temp);
            }

            answer = al.toArray(answer);

        return answer;
    }

    public static String toBinary(int nDecimal, long nDigits) {
        String s = String.format("%0"+nDigits+"d",Long.parseLong(Integer.toBinaryString(nDecimal)));
        return s;
    }

    public static String toSharp(String strBinary) {
        String strReturn = "";
        //String str = Integer.toString(nBinary);
        for (int i = 0; i < strBinary.length(); i++) {
            if (strBinary.charAt(i) == '1') {
                strReturn += "#";
            } else {
                strReturn += " ";
            }
        }
        return strReturn;
    }

    public static String toSum(String val1, String val2, int nDigit) {
        String strReturn = "";
        //int sum = Integer.parseInt(val1) + Integer.parseInt(val2);

        char chava1 = val1.charAt(nDigit);
        char chava2 = val2.charAt(nDigit);

        int va1 = Integer.parseInt(String.valueOf(chava1));
        int va2 = Integer.parseInt(String.valueOf(chava2));
        int sum = va1 + va2;


        if (sum > 0) {
            return "1";
        } else {
            return "0";
        }
    }
}
