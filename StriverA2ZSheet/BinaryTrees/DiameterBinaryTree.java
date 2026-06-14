package BinaryTrees;
public class DiameterBinaryTree {

    // ✅ TreeNode class (same as yours)
    static class TreeNode {
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

    // ✅ Your Solution code (UNCHANGED)
    static class Solution {

        static class Info {
            int diam; // diameter in edges
            int ht;   // height in nodes

            Info(int d, int h) {
                this.diam = d;
                this.ht = h;
            }
        }

        public static Info diameter(TreeNode root) {
            if (root == null)
                return new Info(0, 0);

            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diam = Math.max(
                    Math.max(leftInfo.diam, rightInfo.diam),
                    leftInfo.ht + rightInfo.ht
            );

            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }

        public static int diameterOfBinaryTree(TreeNode root) {
            return diameter(root).diam;
        }
    }

    // ✅ MAIN METHOD (required for VS Code)
    public static void main(String[] args) {

        /*
                Build this tree:

                        1
                       / \
                      2   3
                     / \
                    4   5

                Diameter = 3 (4-2-1-3)
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = Solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree = " + result);
    }
}
