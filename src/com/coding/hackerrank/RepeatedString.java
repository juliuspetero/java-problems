package com.coding.hackerrank;

/**
 * There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer, , find and print the number of letter a's in the first  letters of the infinite string.
 * <p>
 * Example
 * <p>
 * <p>
 * The substring we consider is , the first  characters of the infinite string. There are  occurrences of a in the substring.
 */
public class RepeatedString {

    public static long repeatedString(String s, long n) {
        long length = s.length();
        long repeats = n / length;
        long remainder = n % length;
        long extraAs = 0;
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                ++extraAs;
            }
        }
        long countA = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                ++countA;
            }
        }
        return countA * repeats + extraAs;
    }


    public static long repeatedString2(String s, long n) {
        long size = s.length(), repeated = n / size;
        long left = n - (size * repeated);
        int extra = 0;

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 'a') {
                ++count;
            }
        }

        for (int i = 0; i < left; i++) {
            if (s.charAt(i) == 'a') {
                ++extra;
            }
        }

        repeated = (repeated * count) + extra;

        return repeated;
    }
}
