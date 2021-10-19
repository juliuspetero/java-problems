package com.coding.hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> arr = new ArrayList<>(a);
        int size = a.size();
        for (int i = 0; i < d; i++) {
            List<Integer> copy = new ArrayList<>(arr);
            for (int j = 0; j < size; j++) {
                if (j == size - 1) {
                    copy.set(size - 1, arr.get(0));
                } else {
                    copy.set(j, arr.get(j + 1));
                }
            }
            arr = copy;
        }
        return arr;
    }
}
