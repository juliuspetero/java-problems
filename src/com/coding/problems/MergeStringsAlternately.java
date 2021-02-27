package com.coding.problems;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 */


public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
       int length1 = word1.length();
       int length2 = word2.length();
       StringBuilder answer = new StringBuilder();
       int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < length1) answer.append(word1.charAt(i));
            if (i < length2) answer.append(word2.charAt(i));
        }

        return answer.toString();
    }
}
