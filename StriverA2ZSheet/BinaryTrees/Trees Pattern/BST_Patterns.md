# Binary Search Tree (BST) Pattern

## Core Idea

In a BST, left subtree < node < right subtree. This ordering lets you search/insert/
delete in O(height), and an **inorder traversal yields sorted values**.

---

## Recognition Questions

1. Is the tree a BST (ordered)?
2. Need kth smallest/largest, range queries, closest value?
3. Search / insert / delete a value efficiently?

If YES -> BST-specific logic (don't treat as a generic tree).

## Green Flags

- "binary search tree"
- "kth smallest", "range sum of BST"
- "insert into / delete from BST"

---

## Templates

**Search in BST**

```java
TreeNode search(TreeNode root, int val) {
    while (root != null && root.val != val)
        root = val < root.val ? root.left : root.right;
    return root;
}
```

**Kth Smallest (inorder, stop early)**

```java
int count = 0, ans = -1;
void inorder(TreeNode node, int k) {
    if (node == null) return;
    inorder(node.left, k);
    if (++count == k) { ans = node.val; return; }
    inorder(node.right, k);
}
```

**Lowest Common Ancestor in a BST (use ordering)**

```java
TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (p.val < root.val && q.val < root.val) root = root.left;
        else if (p.val > root.val && q.val > root.val) root = root.right;
        else return root;   // split point
    }
    return null;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 700 | Search in a Binary Search Tree | Easy | https://leetcode.com/problems/search-in-a-binary-search-tree/ |
| 701 | Insert into a BST | Medium | https://leetcode.com/problems/insert-into-a-binary-search-tree/ |
| 450 | Delete Node in a BST | Medium | https://leetcode.com/problems/delete-node-in-a-bst/ |
| 230 | Kth Smallest Element in a BST | Medium | https://leetcode.com/problems/kth-smallest-element-in-a-bst/ |
| 235 | Lowest Common Ancestor of a BST | Medium | https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/ |
| 98 | Validate Binary Search Tree | Medium | https://leetcode.com/problems/validate-binary-search-tree/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Kth Smallest Element in a BST | Amazon, Meta, Google, Uber |
| Lowest Common Ancestor of a BST | Amazon, Meta, Microsoft, LinkedIn |
| Validate BST | Amazon, Meta, Microsoft, Bloomberg |

**FAANG focus:** Kth Smallest in a BST and LCA of a BST are near-mandatory; remember
inorder = sorted and use ordering to prune.
