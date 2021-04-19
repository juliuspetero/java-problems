package com.coding.dynamicprogramming;

public class BinarySearch {

    private boolean binarySearchRec(int[] arr, int l, int r, int k) {
        int mid = l + (r - l) / 2;

        if (l > r || r < 0) {
            return false;
        }

        boolean answer = false;

        if (arr[mid] == k) {
            answer = true;
        } else if (arr[mid] > k) {
            answer = binarySearchRec(arr, l, mid - 1, k);
        } else {
            answer = binarySearchRec(arr, mid + 1, r, k);
        }
        return answer;
    }

    public boolean search(int[] arr, int k) {
        int n = arr.length;
        return binarySearchRec(arr, 0, n - 1, k);
    }
}
