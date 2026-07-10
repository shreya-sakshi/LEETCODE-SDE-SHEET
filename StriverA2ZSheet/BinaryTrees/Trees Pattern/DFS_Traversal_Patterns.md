# Tree DFS (Recursion) Pattern

## Core Idea

Solve a tree problem by combining results from the left and right subtrees
(post-order). Most "height / depth / diameter / path" problems fit here.

---

## Recognition Questions

1. Does the answer for a node depend on its subtrees?
2. Need height, depth, diameter, balanced check, path sum?
3. Need inorder/preorder/postorder output?

If YES -> DFS recursion.

## Green Flags

- "maximum depth", "diameter", "balanced"
- "path sum", "invert tree", "same tree"

---

## Templates

**Max Depth**

```java
int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

**Diameter (global update trick)**

```java
int best = 0;
int height(TreeNode node) {
    if (node == null) return 0;
    int l = height(node.left), r = height(node.right);
    best = Math.max(best, l + r);   // path through this node
    return 1 + Math.max(l, r);
}
```

**Validate BST (inorder must be strictly increasing)**

```java
boolean valid(TreeNode node, long lo, long hi) {
    if (node == null) return true;
    if (node.val <= lo || node.val >= hi) return false;
    return valid(node.left, lo, node.val) && valid(node.right, node.val, hi);
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 104 | Maximum Depth of Binary Tree | Easy | https://leetcode.com/problems/maximum-depth-of-binary-tree/ |
| 226 | Invert Binary Tree | Easy | https://leetcode.com/problems/invert-binary-tree/ |
| 543 | Diameter of Binary Tree | Easy | https://leetcode.com/problems/diameter-of-binary-tree/ |
| 110 | Balanced Binary Tree | Easy | https://leetcode.com/problems/balanced-binary-tree/ |
| 100 | Same Tree | Easy | https://leetcode.com/problems/same-tree/ |
| 572 | Subtree of Another Tree | Easy | https://leetcode.com/problems/subtree-of-another-tree/ |
| 124 | Binary Tree Maximum Path Sum | Hard | https://leetcode.com/problems/binary-tree-maximum-path-sum/ |
| 98 | Validate Binary Search Tree | Medium | https://leetcode.com/problems/validate-binary-search-tree/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Invert Binary Tree | Google, Amazon, Meta |
| Diameter of Binary Tree | Meta (very frequent), Amazon, Google |
| Binary Tree Maximum Path Sum | Meta, Amazon, Google, Microsoft, DoorDash |
| Validate BST | Amazon, Meta, Microsoft, Bloomberg |

**FAANG focus:** Binary Tree Maximum Path Sum (hard) and Diameter both use the same
"return height, update global best" trick — a top Meta pattern.
