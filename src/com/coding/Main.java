package com.coding;

import com.coding.dynamicprogramming.KnapsackProblem;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        System.out.println(Arrays.toString(knapsackProblem.getKnapsackValues(new int[]{1, 2, 5, 6}, new int[]{2, 3, 4, 5}, 8)));
    }
}

