package com.coding;


import com.coding.hackerrank.arrays.ArrayManipulation;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> queries = Arrays.asList(Arrays.asList(1, 2, 100), Arrays.asList(2, 5, 100), Arrays.asList(3, 4, 100));
        long result = ArrayManipulation.arrayManipulation(5, queries);
        System.out.println(result);
        result = ArrayManipulation.arrayManipulation2(5, queries);
        System.out.println(result);
    }
}
