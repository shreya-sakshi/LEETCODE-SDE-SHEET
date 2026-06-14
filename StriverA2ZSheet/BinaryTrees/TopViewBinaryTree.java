package BinaryTrees;

import java.util.*;

//  Approach Used
// Level Order Traversal (BFS) + Horizontal Distance
// Key Ideas

// Horizontal Distance (HD):

// Root → hd = 0
// Left child → hd - 1
// Right child → hd + 1


// Use BFS so upper (top) nodes are visited first
// Store the first node encountered for each HD
// Use a TreeMap to maintain left‑to‑right order


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

class Solution {

    // Helper class to store node with its horizontal distance
    static class Info {
        TreeNode node;
        int hd;   // horizontal distance

        Info(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return the top view of the binary tree
    public List<Integer> topView(TreeNode root) {

        // Result list
        List<Integer> ans = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return ans;
        }

        // TreeMap keeps keys (HDs) in sorted order
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS traversal
        Queue<Info> queue = new LinkedList<>();

        // Start with root at horizontal distance 0
        queue.add(new Info(root, 0));

        // Standard BFS loop
        while (!queue.isEmpty()) {
            Info current = queue.poll();
            TreeNode node = current.node;
            int hd = current.hd;

            // Store the first node encountered at this HD
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Move left → HD - 1
            if (node.left != null) {
                queue.add(new Info(node.left, hd - 1));
            }

            // Move right → HD + 1
            if (node.right != null) {
                queue.add(new Info(node.right, hd + 1));
            }
        }

        // Extract values in order of horizontal distance
        for (int value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}

//  Example
// Tree
//         1
//        / \
//       2   3
//        \
//         4
//          \
//           5

// Top View Output
// 2 1 3 5


// ✅ Time & Space Complexity

// Time: O(N log N)

// N nodes + log N for TreeMap operations


// Space: O(N)

// Queue + Map




// ✅ Why BFS is Important Here

// BFS ensures topmost nodes are visited first
// DFS can give wrong answers unless depth is tracked


// ✅ Interview Tip 💡
// If asked:

// Why TreeMap?

// Answer:

// TreeMap automatically sorts horizontal distances, allowing left-to-right output without extra sorting.

