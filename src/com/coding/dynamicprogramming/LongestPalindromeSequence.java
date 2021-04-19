package com.coding.dynamicprogramming;

/**
 * LongestPalindromeSequence longestPalindromeSequence = new LongestPalindromeSequence();
 * System.out.println(longestPalindromeSequence.longestPalindromeLength("GEEKSFORGEEKSGEEKSFORGEEKSGEEKSGEEKSFORGEEKS"));
 */
public class LongestPalindromeSequence {

    // Returns the length of the longest palindromic subsequence in seq for index i to j
    private int solveRecursively(char[] chars, int i, int j) {
        int answer = 0;
        // Base case 1: If there is only character (same index) return 1
        if (i == j) {
            answer = 1;
        }
        // Base Case 2: If there are only 2 characters and both are same
        else if (chars[i] == chars[j] && i + 1 == j) {
            answer = 2;
        }
        // If the first and last characters match
        else if (chars[i] == chars[j]) {
            answer = solveRecursively(chars, i + 1, j - 1) + 2;
        }
        // If the first and last characters do not match
        else {
            int answer1 = solveRecursively(chars, i, j - 1);
            int answer2 = solveRecursively(chars, i + 1, j);
            answer = Math.max(answer1, answer2);
        }
        return answer;

    }

    static int lps1(char[] seq, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        if (i == j) return dp[i][j] = 1;
        if (seq[i] == seq[j] && i + 1 == j) return dp[i][j] = 2;
        if (seq[i] == seq[j]) return dp[i][j] = lps1(seq, i + 1, j - 1, dp) + 2;
        return dp[i][j] = Math.max(lps1(seq, i, j - 1, dp), lps1(seq, i + 1, j, dp));
    }

    public int longestPalindromeSubsequenceLengthMemoization(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        return lps1(chars, 0, n - 1, dp);
    }

    public int longestPalindromeSequenceLengthTabulation(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public String longestPalindromeSubstringTabulation(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int x = 0, y = 0, max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    dp[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i >= max) {
                    max = j - i;
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }

    /**
     * Return -1, 0 and 1
     *
     * @param seq
     * @param i
     * @param j
     * @param dp
     * @return
     */
    private int lps2(char[] seq, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        } else if (i == j) {
            dp[i][j] = 1;
        } else if (seq[i] == seq[j]) {
            if (i + 1 == j) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = lps2(seq, i + 1, j - 1, dp);
            }
            if (dp[i][j] == 1 && j - i >= max) {
                max = j - i;
                x = i;
                y = j;
            }
        } else {
            lps2(seq, i, j - 1, dp);
            lps2(seq, i + 1, j, dp);
            dp[i][j] = 0;
        }
        return dp[i][j];

    }

    int x = 0, y = 0, max = Integer.MIN_VALUE;

    public String longestPalindromeSubstringMemoization(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        char[] chars = s.toCharArray();
        lps2(chars, 0, n - 1, dp);
        return s.substring(x, y + 1);
    }

}
