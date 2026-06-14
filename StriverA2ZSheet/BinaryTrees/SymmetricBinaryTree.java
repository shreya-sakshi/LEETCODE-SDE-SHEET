package BinaryTrees;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {

        // If both are null → symmetric
        if (left == null || right == null) {
            return left == right;
        }

        // Values must match
        if (left.val != right.val) {
            return false;
        }

        // Check mirrored subtrees
        return isSymmetricHelp(left.left, right.right) &&
               isSymmetricHelp(left.right, right.left);
    }
}