package BinaryTrees;

public class MaxDepthBinaryTree {

    // ✅ Your node class (unchanged)
    static class DepthOfBinaryTreeNode {
        int val;
        DepthOfBinaryTreeNode left;
        DepthOfBinaryTreeNode right;

        DepthOfBinaryTreeNode() {}

        DepthOfBinaryTreeNode(int val) {
            this.val = val;
        }

        DepthOfBinaryTreeNode(int val,DepthOfBinaryTreeNode left,DepthOfBinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Your solution logic (unchanged)
    static class Solution {
        public int maxDepth(DepthOfBinaryTreeNode root) {
            if (root == null)
                return 0;

            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);

            return Math.max(lh, rh) + 1;
        }
    }

    // ✅ main method to RUN in VS Code
    public static void main(String[] args) {

        /*
            Build this tree:

                    1
                   / \
                  2   3
                 /
                4

            Expected max depth = 3
        */

        DepthOfBinaryTreeNode root = new DepthOfBinaryTreeNode(1);
        root.left = new DepthOfBinaryTreeNode(2);
        root.right = new DepthOfBinaryTreeNode(3);
        root.left.left = new DepthOfBinaryTreeNode(4);

        Solution sol = new Solution();
        int depth = sol.maxDepth(root);

        System.out.println("Maximum Depth = " + depth);
    }
}