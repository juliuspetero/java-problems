package com.coding.datastructures.linkedlist;


import java.math.BigInteger;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order, and each of their nodes contains a single digit.
// Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]
//        Explanation: 342 + 465 = 807.


// Solution

/***
 *   ListNode listNode1 = new ListNode(3, null);
 *           ListNode listNode2 = new ListNode(4, listNode1);
 *           ListNode l1 = new ListNode(2, listNode2);
 *
 *           ListNode listNode3 = new ListNode(4, null);
 *           ListNode listNode4 = new ListNode(6, listNode3);
 *           ListNode l2 = new ListNode(5, listNode4);
 *
 *           AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
 *
 *           ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
 */


public class AddTwoNumbers {

    private ListNode headNode;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        while (temp1 != null) {
            builder1.insert(0, temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            builder2.insert(0, temp2.val);
            temp2 = temp2.next;
        }

        BigInteger number1 = new BigInteger(builder1.toString());
        BigInteger number2= new BigInteger(builder2.toString());
        BigInteger result = number1.add(number2);

        String resultString = result.toString();

        for (int i = 0; i < resultString.length(); i++) {
            Integer digit = Integer.parseInt(String.valueOf(resultString.charAt(i)));
            push(digit);
        }
        return headNode;
    }

    public void push(Integer val) {
        ListNode listNode = new ListNode(val);
        listNode.next = headNode;
        headNode = listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
