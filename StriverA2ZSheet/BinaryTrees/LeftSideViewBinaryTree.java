package BinaryTrees;

// Side View of Binary Tree
// A Side View shows the nodes visible when the tree is viewed from one side.

// Left View → nodes visible from the left side
// Right View → nodes visible from the right side

// 👉 Important difference from Top/Bottom View
// Side views are based on levels, not horizontal distance.

// ✅ Core Idea (BFS – Level Order)

// Traverse the tree level by level
// For each level:

// Left View → take the first node
// Right View → take the last node




// 🌿 Left Side View
// ✅ Rule

// First node encountered at each level

import java.util.*;

// Definition for a binary tree node
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

class LeftSideViewBinaryTree {

    // Function to return left side view of binary tree
    public List<Integer> leftView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        // Edge case
        if (root == null) return ans;

        // Queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();

            // Traverse current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // First node of each level -> left view
                if (i == 0) {
                    ans.add(node.data);
                }

                // Add children
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return ans;
    }
}

// Example
//         1
//        / \
//       2   3
//        \    \
//         4    5

// 🔹 Left View → 1 2 4
