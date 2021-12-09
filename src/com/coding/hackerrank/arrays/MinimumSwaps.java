package com.coding.hackerrank.arrays;

public class MinimumSwaps {

    /**
     * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
     * You are allowed to swap any two elements.
     *
     *
     * i   arr                         swap (indices)
     * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
     * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
     * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
     * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
     * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
     * 5   [1, 2, 3, 4, 5, 6, 7]
     * It took  swaps to sort the array.
     * @return
     */
    public static int minimumSwaps(int[] arr) {
        int i = 0;
        int count = 0;
        int temp;
        int n = arr.length;
        while (i < n) {
            if (arr[i] != i + 1) {
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}
