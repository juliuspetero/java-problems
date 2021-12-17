package com.coding.hackerrank.hashmaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.
 * <p>
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * <p>
 * Example
 * = "attack at dawn"  = "Attack at dawn"
 * <p>
 * The magazine has all the right words, but there is a case mismatch. The answer is .
 */
public class RansomNote {


    public static void checkMagazine(List<String> magazine, List<String> note) {
        Collections.sort(magazine);
        Collections.sort(note);
        List<String> magazine_words = new ArrayList<>(magazine);
        for (String nt : note) {
            if (!magazine_words.remove(nt)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
