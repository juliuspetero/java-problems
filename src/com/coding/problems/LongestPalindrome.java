package com.coding.problems;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindrome {

    /**
     * Personal
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }

        ArrayList<String> longestPalindromeList = new ArrayList<>();
        ArrayList<String> tempLongestList = new ArrayList<>();

        String[] stringArray = s.split("");
        int n = stringArray.length;

        longestPalindromeList.add(stringArray[0]);


        for (int i = 0; i < n; i++) {
            tempLongestList.add(stringArray[i]);
            for (int j = i + 1; j < n; j++) {
                tempLongestList.add(stringArray[j]);
                ArrayList<String> reversedList = new ArrayList<>(tempLongestList);
                Collections.reverse(reversedList);
                if (tempLongestList.equals(reversedList) && tempLongestList.size() > longestPalindromeList.size()) {
                    longestPalindromeList = new ArrayList<>(tempLongestList);
                }
            }

            tempLongestList = new ArrayList<>();
        }

        StringBuilder builder = new StringBuilder();
        for (String longestPalindrome : longestPalindromeList) {
            builder.append(longestPalindrome);
        }
        return builder.toString();
    }

    /**
     * Brute force method
     */
    public String longestPalindromeBruteForce(String s) {
        int length = s.length();
        ArrayList<String> possibleSubstrings = new ArrayList<>();
        String longestPalindrome = "";

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = s.substring(i, j);
                possibleSubstrings.add(substring);
            }
        }

        for (String substring : possibleSubstrings) {
            String reversedSubstring = new StringBuilder(substring).reverse().toString();
            if (substring.equals(reversedSubstring) && substring.length() > longestPalindrome.length()) {
                longestPalindrome = substring;
            }
        }
        return longestPalindrome;
    }

    /**
     * The case "ababa". If we already knew that "bab" is a palindrome,
     * it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.
     *
     * @param s
     * @return
     */
    public String longestPalindromeDPMethod(String s) {
        if (s.isEmpty()) return s;
        int length = s.length();
        int[][] table = new int[length][length];
        int maxPalindromeLength = 0;
        int startIndex = 0;

        // Fill the table for substring of length 1
        // They are palindromes
        for (int i = 0; i < length; ++i) {
            table[i][i] = 1;
            maxPalindromeLength = 1;
        }

        // Fill the table for substrings of length 2
        // They are palindromes when start and end characters are the same
        for (int i = 0; i < length - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                startIndex = i;
                maxPalindromeLength = 2;
            }
        }


        // Fill the table for substring of length greater than 2
        // k is length of substring
        for (int k = 3; k <= length; ++k) {

            // Fix the starting index
            for (int i = 0; i < length - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int endIndex = i + k - 1;

                // checking for sub-string from ith index to
                // endIndex if s.charAt(i+1) equals to s.charAt(endIndex-1) is a palindrome
                if (table[i + 1][endIndex - 1] == 1 && s.charAt(i) == s.charAt(endIndex)) {
                    table[i][endIndex] = 1;
                    if (k > maxPalindromeLength) {
                        startIndex = i;
                        maxPalindromeLength = k;
                    }
                }
            }
        }

        String palindrome;
        palindrome = s.substring(startIndex, startIndex + maxPalindromeLength);

        return palindrome;
    }
}
