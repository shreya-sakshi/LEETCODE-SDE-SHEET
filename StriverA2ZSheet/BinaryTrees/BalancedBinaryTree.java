package BinaryTrees;

public class BalancedBinaryTree {

    // ✅ TreeNode class (LeetCode hides this)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Your solution code (UNCHANGED logic)
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfsheight(root) != -1;
        }

        public int dfsheight(TreeNode root) {
            if (root == null) return 0;

            int lh = dfsheight(root.left);
            if (lh == -1) return -1;

            int rh = dfsheight(root.right);
            if (rh == -1) return -1;

            if (Math.abs(lh - rh) > 1) return -1;

            return Math.max(lh, rh) + 1;
        }
    }

    // ✅ main method to RUN the code
    public static void main(String[] args) {

        /*
            Create this tree:
                    1
                   /
                  2
                 /
                3
            (Unbalanced)
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        Solution sol = new Solution();
        System.out.println(sol.isBalanced(root)); // false
    }
}
