package com.coding.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> result = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        result.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        Collections.sort(result);

        int size = result.size();
        int halfSize = size / 2;

        double median;
        if (size % 2 == 0) {
            median = (double) result.get(halfSize) / 2 + (double) result.get(halfSize - 1) / 2;
        } else {
            median = (double) result.get(halfSize);
        }

        return median;

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] result = new int[length1 + length2];

        for(int i = 0; i < length1; i++){
            result[i] = nums1[i];
        }

        for(int i = 0; i < length2; i++){
            result[length1 + i] = nums2[i];
        }
        Arrays.sort(result);

        int size = result.length;
        int halfSize = size / 2;
        return size % 2 == 0 ? (double) result[halfSize] / 2 + (double) result[halfSize - 1] / 2 : (double) result[halfSize];

    }
}
