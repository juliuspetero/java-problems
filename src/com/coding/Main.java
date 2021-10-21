package com.coding;


import com.coding.hackerrank.arrays.LeftRotation;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> arr = LeftRotation.rotLeft3(Arrays.asList(1, 2, 3, 4, 5), 2);
        int[] arr2 = LeftRotation.rotateLeft(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(arr);
        System.out.println(Arrays.toString(arr2));
    }
}

