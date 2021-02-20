package com.coding;

import com.coding.problems.LongestPalindrome;

public class Main {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String palindrome = longestPalindrome.longestPalindromeDPMethod("babad");
        System.out.println(palindrome);
    }
}
