package com.coding.datastructures.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
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
 System.out.println(root.toString());
 int minValue = binarySearchTree.findMin1(root);
 int minValue2 = binarySearchTree.findMin2(root);
 int maxValue1 = binarySearchTree.findMax(root);
 int height = binarySearchTree.findHeight(root);
 List<Integer> list1 = binarySearchTree.levelOrderTraversal(root);
 List<Integer> list2 = binarySearchTree.preorderTraversal(root);
 binarySearchTree.inOrderTraversal(root);
 System.out.println(list2.toString());

 boolean isFound = binarySearchTree.search(root, 20);
 System.out.println(isFound);

 System.out.println(binarySearchTree.levelOrderTraversal(root).toString());
 root = binarySearchTree.delete(root, 12);
 System.out.println(binarySearchTree.levelOrderTraversal(root).toString());
 */

public class BinarySearchTree {

    /**
     * Accept the root and return back that root BstNode
     *
     * @param root  root node
     * @param value the value of the node of the node to be inserted
     * @return BstNode
     */
    public BstNode insert(BstNode root, int value) {
        if (root == null) { // Empty tree
            root = new BstNode(value);
        } else if (value <= root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public boolean search(BstNode root, int value) {
        if (root == null) {
            return false;
        } else if (root.value == value) {
            return true;
        } else if (value <= root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    /**
     * Go left as long as possible
     * temp or current is the node we are currently pointing to or traversing
     *
     * @param root BstNode root
     * @return minimum value ever
     */
    public int findMin1(BstNode root) {
        if (root == null) {
            throw new NullPointerException("Root node cannot be null");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    public int findMin2(BstNode root) {
        if (root == null) {
            throw new NullPointerException("Root node cannot be null");
        } else if (root.left == null) {
            return root.value;
        }

        // Search in left subtree
        return findMin2(root.left);
    }

    public int findMax(BstNode root) {
        if (root == null) {
            throw new NullPointerException("Root node cannot be null");
        }
        BstNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public int findHeight(BstNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public List<Integer> levelOrderTraversal(BstNode root) {
        List<Integer> integerList = new ArrayList<>();
        if (root == null) {
            return integerList;
        }

        Queue<BstNode> queue = new LinkedList<>();
        queue.add(root);

        // While there is at least one discovered node
        while (!queue.isEmpty()) {
            BstNode current = queue.remove();
            integerList.add(current.value);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return integerList;
    }

    List<Integer> integerList = new ArrayList<>();

    public List<Integer> preorderTraversal(BstNode root) {
        if (root == null) {
            return this.integerList;
        }
        this.integerList.add(root.value);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return this.integerList;
    }

    public void inOrderTraversal(BstNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(BstNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

    public boolean isBinarySearchTree(BstNode root) {
        if (root == null) return true;
        return isAllValuesInSubtreeLessor(root.left, root.value)
                && isAllValuesInSubtreeGreater(root.right, root.value)
                && isBinarySearchTree(root.left)
                && isBinarySearchTree(root.right);
    }

    private boolean isAllValuesInSubtreeLessor(BstNode root, int value) {
        if (root == null) return true;
        return root.value <= value && isAllValuesInSubtreeLessor(root.left, value) && isAllValuesInSubtreeLessor(root.right, value);
    }

    private boolean isAllValuesInSubtreeGreater(BstNode root, int value) {
        if (root == null) return true;
        return root.value > value && isAllValuesInSubtreeGreater(root.left, value) && isAllValuesInSubtreeGreater(root.right, value);
    }

    public boolean isBinarySearchTree2(BstNode root) {
        if (root == null) return true;
        return isAllValuesInSubtreeLessor(root.left, root.value)
                && isAllValuesInSubtreeGreater(root.right, root.value)
                && isBinarySearchTree(root.left)
                && isBinarySearchTree(root.right);
    }

    private boolean isBstUtil(BstNode root, int minValue, int maxValue) {
        if (root == null) return true;
        return root.value < minValue
                && root.value > maxValue
                && isBstUtil(root.left, minValue, root.value)
                && isBstUtil(root.right, root.value, maxValue);
    }

    public BstNode delete(BstNode root, int value) {
        if (root == null) return null;
        else if (value < root.value) root.left = delete(root.left, value);
        else if (value > root.value) root.right = delete(root.right, value);
        else { // Wohoo .... I found you, get ready to be deleted
            if (root.left == null && root.right == null) {
                // Case 1: No child
                root = null;
            } else if (root.left == null) {
                // Case 2 : One child on the right
                root = root.right;
            } else if (root.right == null) {
                // Case 3: One child on the left
                root = root.left;
            } else {
                // Case 3: Two children
                BstNode temp = findMinNode(root.right);
                root.value = temp.value;
                root.right = delete(root.right, temp.value);
            }
        }
        return root;
    }

    /**
     * Function to find inorder successor in BST
     * <left><root><right>
     *
     * @param root  Root BST node
     * @param value value for which the successor needs to be found
     * @return BST node of the the successor
     */
    public BstNode findInorderSuccessor(BstNode root, int value) {
        // Search the node - time complexity O(h)
        BstNode current = findNode(root, value);
        if (current == null) return null;

        // Case 1: Node has right subtree
        // Find min in the right sub-tree
        if (current.right != null) {
            return findMinNode(current.right);
        }

        // Case 2: No right sub-tree
        // When we move back to the parent from left, the parent would be unvisited
        else {
            BstNode successor = null;
            BstNode ancestor = root;
            while (ancestor != current) {
                if (current.value < ancestor.value) {
                    successor = ancestor; // So far this is the deepest for which current node is in left
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }

    public BstNode findNode(BstNode root, int value) {
        if (root == null) return null;
        else if (root.value == value) {
            return root;
        } else if (value <= root.value) {
            return findNode(root.left, value);
        } else {
            return findNode(root.right, value);
        }
    }

    public BstNode findMinNode(BstNode root) {
        if (root == null) {
            throw new NullPointerException("Root node cannot be null");
        } else if (root.left == null) {
            return root;
        }
        return findMinNode(root.left);
    }

    public static class BstNode {
        int value;
        BstNode left;
        BstNode right;

        public BstNode(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return "{\n" +
                    "\t\"value\": " + value + ",\n" +
                    "\t\"left\": " + left + ",\n" +
                    "\t\"right\": " + right + "\n" +
                    "}";
        }
    }
}
