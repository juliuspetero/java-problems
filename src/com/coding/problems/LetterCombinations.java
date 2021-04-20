package com.coding.problems;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinations {

    private void backTrackRec(int i, String curStr, String digits, List<String> result) {
        int len = digits.length();
        if (curStr.length() == len) {
            result.add(curStr);
            return;
        }
        char[] digitChars = PhoneNumber.getByNumber(digits.charAt(i)).letters.toCharArray();
        for (char c : digitChars) {
            backTrackRec(i + 1, curStr + c, digits, result);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            backTrackRec(0, "", digits, result);
        }
        return result;
    }

    private enum PhoneNumber {
        TWO('2', "abc"),
        THREE('3', "def"),
        FOUR('4', "ghi"),
        FIVE('5', "jkl"),
        SIX('6', "mno"),
        SEVEN('7', "pqrs"),
        EIGHT('8', "tuv"),
        NINE('9', "wxyz");

        private char number;
        private String letters;

        PhoneNumber(char number, String letters) {
            this.number = number;
            this.letters = letters;
        }

        static PhoneNumber getByNumber(char no) {
            for (PhoneNumber phoneNumber : values()) {
                if (phoneNumber.number == no) return phoneNumber;
            }
            throw new NullPointerException("Doesn't exist");
        }
    }
}
