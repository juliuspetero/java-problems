package com.coding;

import com.coding.dynamicprogramming.BinarySearch;
import com.coding.dynamicprogramming.MaximumSubArray;

public class Main {

    public static void main(String[] args) {
        MaximumSubArray maximumSubarray = new MaximumSubArray();
        System.out.println(maximumSubarray.maxSubArrayBigON(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maximumSubarray.maxSubArrayBigON(new int[]{-1}));

    }
}

