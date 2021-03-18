package com.coding.problems;


/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1){
            return "";
        }

        StringBuilder longestPrefix = new StringBuilder();
        int shortestLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if ( str.length() < shortestLength) {
                shortestLength = str.length();
            }
        }

        for (int i = 0; i < shortestLength; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return longestPrefix.toString();
                }
            }
            longestPrefix.append(c);
        }
        return longestPrefix.toString();
    }
}
