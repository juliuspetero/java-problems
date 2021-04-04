package com.coding;

import com.coding.datastructures.tree.BinarySearchTree;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree.BstNode root = null; // Pointer to the root, this is not really the root but store the address of the root
        // setting the tree as empty tree
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        root = binarySearchTree.insert(root, 15);
        root = binarySearchTree.insert(root, 10);
        root = binarySearchTree.insert(root, 20);
        root = binarySearchTree.insert(root, 25);
        root = binarySearchTree.insert(root, 8);
        root = binarySearchTree.insert(root, 12);
        System.out.println(binarySearchTree.isBinarySearchTree2(root));
//        System.out.println(root.toString());

//        int minValue = binarySearchTree.findMin1(root);
//        int minValue2 = binarySearchTree.findMin2(root);
//        int maxValue1 = binarySearchTree.findMax(root);
//        int height = binarySearchTree.findHeight(root);
//
//        List<Integer> list1 = binarySearchTree.levelOrderTraversal(root);
//        List<Integer> list2 = binarySearchTree.preorderTraversal(root);
//        binarySearchTree.inOrderTraversal(root);
//        System.out.println(list2.toString());
//
//        boolean isFound = binarySearchTree.search(root, 20);
//        System.out.println(isFound);

        System.out.println(binarySearchTree.levelOrderTraversal(root).toString());
        root = binarySearchTree.delete(root, 12);
        System.out.println(binarySearchTree.levelOrderTraversal(root).toString());


    }
}

