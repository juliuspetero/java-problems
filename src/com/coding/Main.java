package com.coding;


import com.coding.hackerrank.arrays.LeftRotation;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> arr = LeftRotation.rotLeft(Arrays.asList(1, 2, 3, 4, 5), 2);
        System.out.println(arr);
    }
}

