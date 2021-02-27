package com.coding.problems;

import org.omg.PortableInterceptor.INACTIVE;

public class LeetCodeConTest1 {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        String[] arr1 = word1.split("");
        String[] arr2 = word2.split("");

        StringBuilder builder = new StringBuilder();

        if(l1 <= l2){
            for(int i = 0; i < l1; i++){
                builder.append(arr1[i]);
                builder.append(arr2[i]);
            }

            for(int i = l1; i < l2; i++){
                builder.append(arr2[i]);
            }

        }else{
            for(int i = 0; i < l2; i++){
                builder.append(arr2[i]);
                builder.append(arr1[i]);
            }

            for(int i = l2; i < l1; i++){
                builder.append(arr1[i]);
            }
        }

        return builder.toString();
    }

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

    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int maxScore = 0;


        if( n == m){
            for (int i = n; i > -1; i--){
                int score = multipliers[i] * nums[i];
                maxScore = maxScore + score;

            }
        }else{
            for(int i = 0; i < n; i++ ){
                if(i > m -1){
                    break;
                }
                int score = multipliers[i] * nums[i];
                maxScore = maxScore + score;
            }
        }
        return maxScore;
    }

    public int maximumScore2(int[] nums, int[] multipliers) {
        return maximumScore(0, nums.length - 1, 0, nums, multipliers, new Integer[1005][1005]);
    }

    private int maximumScore(int i, int j, int k, int[] nums, int[] multipliers, Integer[][] map) {
        if (k == multipliers.length) {
            return 0;
        } else if (map[i][nums.length - j] == null) {
            map[i][nums.length - j] = Math.max(
                    nums[i] * multipliers[k] + maximumScore(i + 1, j, k + 1, nums, multipliers, map),
                    nums[j] * multipliers[k] + maximumScore(i, j - 1, k + 1, nums, multipliers, map));
        }
        return map[i][nums.length - j];
    }
}
