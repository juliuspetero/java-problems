package com.coding.problems;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        String[] arr1 = s.split("");
        String[] arr2 = p.split("");

        for (int i = 0; i < arr1.length; i++) {

        }


        return true;
    }
}
