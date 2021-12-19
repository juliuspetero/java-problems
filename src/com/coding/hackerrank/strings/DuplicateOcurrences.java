package com.coding.hackerrank.strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DuplicateOcurrences {


    @Test
    public void printDuplicateOcurrences() {
        String s = "I am am learning Java Java";
        String[] splits = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str : splits) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println(entry.getKey());
            }

        }
    }
}
