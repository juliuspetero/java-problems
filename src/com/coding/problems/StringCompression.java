package com.coding.problems;

public class StringCompression {

    public int getLengthOfOptimalCompression(String s, int k) {

        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {


        }


        return k;
    }

    String getEncodedString(String s, int strLength) {
        StringBuilder encodedString = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            if ((temp.length() == 0) || s.charAt(i) == temp.charAt(temp.length() - 1)) {
                temp.append(s.charAt(i));
            } else {
                encodedString.append(temp.charAt(0)).append(temp.length() > 1 ? temp.length() : "");
                temp = new StringBuilder().append(s.charAt(i));
            }
            if (i == strLength - 1 && temp.length() > 0) {
                encodedString.append(temp.charAt(0)).append(temp.length() > 1 ? temp.length() : "");
            }
        }
        return encodedString.toString();
    }
}
