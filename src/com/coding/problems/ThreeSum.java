package com.coding.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 *
 * ThreeSum threeSum = new ThreeSum();
 * System.out.println(Arrays.deepToString(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toArray()));
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1 + i; j < n; j++) {
                for (int k = 1 + j; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Stream.of(nums[i], nums[j], nums[k]).sorted().collect(Collectors.toList()));
                    }
                }
            }
        }

        return new ArrayList<>(result);

    }
}
