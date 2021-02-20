package com.coding.problems;


import java.util.ArrayList;

/***
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longestValue = 0;
        String[] stringArray = s.split("");
        ArrayList<String> tempList = new ArrayList<>();
        int tempLongestValue = 0;

        for (int i = 0; i < n; i++) {
            tempList.add(stringArray[i]);
            for (int j = i + 1; j < n; j++) {

                if (!tempList.contains(stringArray[j])) {
                    tempList.add(stringArray[j]);
                } else {
                    tempLongestValue = tempList.size();
                    if (tempLongestValue > longestValue) {
                        longestValue = tempLongestValue;
                    }
                    tempList = new ArrayList<>();
                    break;
                }
            }

            tempLongestValue = tempList.size();
            if (tempLongestValue > longestValue) {
                longestValue = tempLongestValue;
            }
            tempList = new ArrayList<>();

        }
        return longestValue;
    }
}
