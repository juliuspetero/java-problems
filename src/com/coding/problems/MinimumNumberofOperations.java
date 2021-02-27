package com.coding.problems;


/**
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 * MinimumNumberofOperations minimumNumberofOperations = new MinimumNumberofOperations();
*  System.out.println(Arrays.toString(minimumNumberofOperations.minOperations("110")));
 */
public class MinimumNumberofOperations {

    public int[] minOperations(String boxes) {
        String[] arr = boxes.split("");
        int length = boxes.length();
        int[] operations = new int[length];

        for(int i = 0; i < length; i++){

            int number = 0;
            for(int j = 0; j < length; j++){
                if(arr[j].equals("1")){
                    number = number + Math.abs(i - j);
                }
            }
            operations[i] = number;
        }
        return operations;
    }
}
