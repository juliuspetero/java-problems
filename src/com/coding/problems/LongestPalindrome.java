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

    /**
     * You are given two strings, word1 and word2. You want to construct a string in the following manner:
     * <p>
     * Choose some non-empty subsequence subsequence1 from word1.
     * Choose some non-empty subsequence subsequence2 from word2.
     * Concatenate the subsequences: subsequence1 + subsequence2, to make the string.
     * Return the length of the longest palindrome that can be constructed in the described manner. If no palindromes can be constructed, return 0.
     * <p>
     * A subsequence of a string s is a string that can be made by deleting some (possibly none) characters from s without changing the order of the remaining characters.
     * <p>
     * A palindrome is a string that reads the same forward as well as backward.
     *
     * @param word1
     * @param word2
     * @return
     */
    public int longestPalindrome(String word1, String word2) {
        String w = word1 + word2;
        int n = w.length();
        int[][] len = new int[n][n];
        for (int i = 0; i < n; ++i) {
            len[i][i] = 1;
        }
        for (int z = 1; z < n; ++z) {
            for (int i = 0; i + z < n; ++i) {
                int j = i + z;
                len[i][j] = Math.max(len[i + 1][j], len[i][j - 1]);
                if (w.charAt(i) == w.charAt(j)) {
                    len[i][j] = Math.max(len[i][j], len[i + 1][j - 1] + 2);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < word1.length(); ++i) {
            for (int j = 0; j < word2.length(); ++j) {
                if (word1.charAt(i) != word2.charAt(j))
                    continue;
                ans = Math.max(ans, len[i + 1][word1.length() + j - 1] + 2);
            }
        }
        return ans;
    }

    public int longestPalindrome2(String word1, String word2) {
        String m = word1 + word2;
        return lps(m, word1, word2);
    }

    int lps(String m, String word1, String word2) {
        int n = m.length();

        int[][] dp = new int[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][i] = 1;
                    continue;
                }
                if (m.charAt(i) == m.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];

                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < word1.length(); i++) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    max = Math.max(max, dp[i][word1.length() + j]);
                }
            }
        }
        return max;

    }

    /**
     * Given an integer x, return true if x is palindrome integer.
     * <p>
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String numberString = Integer.toString(x);
        String reversedString = new StringBuilder(numberString).reverse().toString();
        return numberString.equals(reversedString);
    }

    /**
     * Longest palindrome
     */

    public String getLongestPalindrome(String s) {
        int strLength = s.length();
        String longestPalindromeSubstring = "";

        // 1. The table has all values as false
        boolean[][] table = new boolean[strLength][strLength];

        // 2. A substring of length = 1 is a palindrome
        for (int i = 0; i < strLength; i++) {
            int j = i; // End index j
            table[i][j] = true;
            if (s.substring(i, j + 1).length() > longestPalindromeSubstring.length()) {
                longestPalindromeSubstring = s.substring(i, j + 1);
            }
        }

        // 3. A substring of length = 2 is a palindrome when both characters are the same
        for (int i = 0; i < strLength - 1; i++) {
            int j = i + 1; // j is the end index of the substring
            if (s.charAt(i) == s.charAt(j)) {
                table[i][j] = true;
                if (s.substring(i, j + 1).length() > longestPalindromeSubstring.length()) {
                    longestPalindromeSubstring = s.substring(i, j + 1);
                }
            }
        }

        // 4. A substring of length > 3 is a palindrome when start and end characters are the same and
        // the inner substring is also a palindrome
        for (int k = 2; k < strLength; k++) {
            for (int i = 0; i < strLength - k; i++) {
                int j = i + k; // End index of the substring

                if(s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]){
                    table[i][j] = true;
                    if (s.substring(i, j + 1).length() > longestPalindromeSubstring.length()) {
                        longestPalindromeSubstring = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPalindromeSubstring;
    }
}
