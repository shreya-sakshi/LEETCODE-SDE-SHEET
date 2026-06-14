package BinaryTrees;
import java.util.*;

// Right Side View
// ✅ Rule

// Last node encountered at each level

class RightSideViewBinaryTree {

    // Function to return right side view of binary tree
    public List<Integer> rightView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // BFS traversal
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Last node of each level -> right view
                if (i == size - 1) {
                    ans.add(node.data);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return ans;
    }
}

// ✅ Example
// Same tree:
// 🔹 Right View → 1 3 5

// 🧠 Why BFS Works Best for Side Views?

// BFS naturally processes nodes level by level
// Ensures we correctly identify first/last node per level
// DFS needs extra tracking (level & visited array)


// ✅ Complexity
// ViewTimeSpaceLeft ViewO(N)O(N)Right ViewO(N)O(N)

// ✅ One‑line Interview Summary

// Side views are obtained using level order traversal by selecting the first or last node at each level.