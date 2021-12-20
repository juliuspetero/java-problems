package com.coding.hackerrank.strings;

/**
 * Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
 * <p>
 * You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
 * The array will always contain letters in only one case.
 * <p>
 * ["a","b","c","d","f"] -> "e"
 * ["O","Q","R","S"] -> "P"
 */
public class MissingLetter {

    public static char findMissingLetter(char[] array) {
        char[] completeAlphabets = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        if (Character.isUpperCase(array[0])) {
            completeAlphabets = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        }
        int completeLength = completeAlphabets.length;
        int length = array.length;
        int startIndex = 0;
        for (int i = 0; i < completeLength; i++) {
            if (completeAlphabets[i] == array[0]) {
                startIndex = i;
                break;
            }
        }
        int endIndex = startIndex + length;

        int j = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (completeAlphabets[i] != array[j]) {
                return completeAlphabets[i];
            }
            j++;
        }
        return array[0];
    }


    /**
     * char[] input = new char[]{'a', 'b', 'c', 'd', 'f'};
     * char result = MissingLetter.findMissingLetter2(input);
     * System.out.println(result);
     *
     * @param array
     * @return
     */
    public static char findMissingLetter2(char[] array) {
        char expectedLetter = array[0];
        for (char letter : array) {
            if (letter != expectedLetter) break;
            expectedLetter++;
        }
        return expectedLetter;
    }
}
