package com.coding.problems;


/***
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 * TwoSumChallenge twoSumChallenge = new TwoSumChallenge();
 * int[] ints = twoSumChallenge.twoSum(new int[]{2, 7, 11, 15}, 9);
 */
public class TwoSumChallenge {

    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j){
                    continue;
                }
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
