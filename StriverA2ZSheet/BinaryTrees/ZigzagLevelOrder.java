package BinaryTrees;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // List to store the result of zigzag traversal
        List<List<Integer>> result = new ArrayList<>();

        // Check if the root is null, return an empty result
        if (root == null) {
            return result;
        }

        // Queue to perform level order traversal
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        // Flag to determine direction (left to right or right to left)
        boolean leftToRight = true;

        // Continue traversal until the queue is empty
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = nodesQueue.size();

            // List pre-filled with zeros for the current level
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));

            // Traverse all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Poll the front node from the queue
                TreeNode node = nodesQueue.poll();

                // Determine insertion index based on traversal direction
                int index = leftToRight ? i : (size - 1 - i);

                // Place node's value at the computed index
                row.set(index, node.data);

                // Enqueue left child if it exists
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }

                // Enqueue right child if it exists
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            // Flip direction for the next level
            leftToRight = !leftToRight;

            // Add the completed level row to result
            result.add(row);
        }

        return result;
    }
}

public class ZigzagLevelOrder {

    // Helper to print the result
    public static void printResult(List<List<Integer>> result) {
        System.out.println("Zigzag Level Order Traversal:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("  Level " + i + ": ");
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
        /*
         * Constructing this binary tree:
         *
         *           1
         *          / \
         *         2   3
         *        / \ / \
         *       4  5 6  7
         *
         * Expected zigzag output:
         *   Level 0: [1]       → left to right
         *   Level 1: [3, 2]    → right to left
         *   Level 2: [4, 5, 6, 7] → left to right
         */
        TreeNode root = new TreeNode(1);
        root.left        = new TreeNode(2);
        root.right       = new TreeNode(3);
        root.left.left   = new TreeNode(4);
        root.left.right  = new TreeNode(5);
        root.right.left  = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        printResult(result);

        // ---- Additional test: null root ----
        System.out.println("\nNull root test: " + solution.zigzagLevelOrder(null));

        // ---- Additional test: single node ----
        TreeNode single = new TreeNode(42);
        System.out.println("Single node test: " + solution.zigzagLevelOrder(single));

        // ---- Additional test: left-skewed tree ----
        /*
         *   10
         *   /
         *  20
         *  /
         * 30
         */
        TreeNode skewed = new TreeNode(10);
        skewed.left = new TreeNode(20);
        skewed.left.left = new TreeNode(30);
        System.out.println("\nLeft-skewed tree:");
        printResult(solution.zigzagLevelOrder(skewed));
    }
}