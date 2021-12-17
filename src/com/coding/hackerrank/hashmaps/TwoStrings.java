package com.coding.hackerrank.hashmaps;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for (char c1 : s1Arr) {
            for (char c2 : s2Arr) {
                if (c1 == c2) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static String twoStrings2(String s1, String s2) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (char c : alphabets.toCharArray()) {
            if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) {
                return "YES";
            }
        }
        return "NO";
    }

}
