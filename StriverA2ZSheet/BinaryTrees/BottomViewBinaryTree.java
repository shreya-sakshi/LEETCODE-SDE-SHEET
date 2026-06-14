package BinaryTrees;



// Bottom View of Binary Tree (BFS Method)
// ✅ Idea

// Use Level Order Traversal (BFS)
// Track Horizontal Distance (HD)
// For Bottom View, we store the last node seen at each HD
// Therefore, overwrite the value in the map every time


// ✅ Key Difference from Top View
// ViewMap ConditionTop Viewstore only if HD not present
// Bottom View store/overwrite every time

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class BottomViewBinaryTree {

    // Helper class to store a node with its horizontal distance
    static class Info {
        TreeNode node;
        int hd;

        Info(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return the bottom view of the binary tree
    public List<Integer> bottomView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        // Edge case
        if (root == null) return ans;

        // TreeMap keeps horizontal distances sorted
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Info> q = new LinkedList<>();

        // Start from root at HD = 0
        q.add(new Info(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Info curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            // Overwrite value for bottom view
            map.put(hd, node.data);

            // Move left -> HD - 1
            if (node.left != null) {
                q.add(new Info(node.left, hd - 1));
            }

            // Move right -> HD + 1
            if (node.right != null) {
                q.add(new Info(node.right, hd + 1));
            }
        }

        // Collect result in left-to-right order
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}

// Example
// Tree
//         20
//        /  \
//       8   22
//        \    \
//         3    25
//        / \
//       10 14

// Bottom View
// 10 3 14 25


// ✅ Time & Space Complexity

// Time Complexity: O(N log N)
// Space Complexity: O(N)


// ✅ Interview Explanation (1‑liner)

// We use BFS with horizontal distance, and overwrite values in a TreeMap to keep the lowest visible node for each vertical line.