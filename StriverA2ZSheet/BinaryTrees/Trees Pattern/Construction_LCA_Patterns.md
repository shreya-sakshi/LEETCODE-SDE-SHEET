# Tree Construction, Serialize & LCA Pattern

## Core Idea

Rebuild a tree from traversal arrays (preorder+inorder), serialize/deserialize for
storage, and find the Lowest Common Ancestor in a general binary tree via DFS.

---

## Recognition Questions

1. Build a tree from preorder/inorder (or postorder/inorder)?
2. Serialize to a string and reconstruct?
3. LCA in a NON-BST (no ordering to exploit)?

If YES -> construction / LCA DFS.

## Green Flags

- "construct binary tree from ... traversal"
- "serialize and deserialize"
- "lowest common ancestor" (general tree)

---

## Templates

**Build Tree from Preorder + Inorder**

```java
int pre = 0;
Map<Integer, Integer> idx = new HashMap<>();  // value -> index in inorder
TreeNode build(int[] preorder, int lo, int hi) {
    if (lo > hi) return null;
    int rootVal = preorder[pre++];
    TreeNode root = new TreeNode(rootVal);
    int mid = idx.get(rootVal);
    root.left = build(preorder, lo, mid - 1);
    root.right = build(preorder, mid + 1, hi);
    return root;
}
```

**LCA (general binary tree)**

```java
TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode l = lca(root.left, p, q);
    TreeNode r = lca(root.right, p, q);
    if (l != null && r != null) return root;  // p and q on different sides
    return l != null ? l : r;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 105 | Construct Binary Tree from Preorder and Inorder | Medium | https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ |
| 106 | Construct from Inorder and Postorder | Medium | https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/ |
| 297 | Serialize and Deserialize Binary Tree | Hard | https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ |
| 236 | Lowest Common Ancestor of a Binary Tree | Medium | https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/ |
| 1650 | LCA III (with parent pointers) | Medium | https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Serialize and Deserialize Binary Tree | Amazon, Meta, Google, Microsoft, LinkedIn |
| LCA of a Binary Tree | Meta (very frequent), Amazon, Microsoft |
| Construct from Preorder + Inorder | Amazon, Microsoft, Bloomberg |

**FAANG focus:** LCA of a Binary Tree (236) is one of Meta's most-asked; Serialize/
Deserialize (297) is a classic Google/Amazon hard.
