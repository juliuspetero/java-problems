package com.coding.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class ListSorting {

    @Test
    public void givenList_whenUsingSort_thenSortedList() {
        int[] toSort = new int[]{5, 1, 89, 255, 7, 88, 200, 123, 66};
        int[] sortedInts = new int[]{1, 5, 7, 66, 88, 89, 123, 200, 255};

        List<Integer> toSortList = Arrays.stream(toSort).boxed().collect(Collectors.toList());
//
//        assertTrue(Arrays.equals(toSortList.toArray(),
//                ArrayUtils.toObject(sortedInts)));
    }


}
