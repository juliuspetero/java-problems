package com.coding.hackerrank.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * int[] arr2 = LeftRotation.rotateLeft(new int[]{1, 2, 3, 4, 5}, 2);
 * System.out.println(arr);
 */
public class LeftRotation {

    // Bruteforce approach
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

    public static int[] rotateLeft(int[] input, int numberOfRotations) {
        int length = input.length;
        for (int i = 0; i < numberOfRotations; i++) {
            int temp = input[0];
            for (int j = 0; j < length - 1; j++) {
                input[j] = input[j + 1];
            }
            input[length - 1] = temp;
        }
        return input;
    }

    public static List<Integer> rotLeft2(List<Integer> a, int d) {
        int size = a.size();
        int rotations = d;
        if (d >= size) {
            rotations = d % size;
        }
        for (int i = 0; i < rotations; i++) {
            Integer temp = a.get(0);
            for (int j = 0; j < size - 1; j++) {
                a.set(j, a.get(j + 1));
            }
            a.set(size - 1, temp);
        }
        return a;
    }

    public static List<Integer> rotLeft3(List<Integer> a, int d) {
        int size = a.size();
        int mod = d % size;
        int[] arr = a.stream().mapToInt(Integer::intValue).toArray();
        int[] head = Arrays.copyOfRange(arr, 0, mod);
        int[] tail = Arrays.copyOfRange(arr, mod, size);
        List<Integer> result = Arrays.stream(tail).boxed().collect(Collectors.toList());
        result.addAll(Arrays.stream(head).boxed().collect(Collectors.toList()));
        return result;
    }

}
