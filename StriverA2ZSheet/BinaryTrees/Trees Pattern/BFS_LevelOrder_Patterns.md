# Tree BFS (Level Order) Pattern

## Core Idea

Process the tree level by level using a queue. Snapshot `queue.size()` at the start of
each level so you know exactly how many nodes belong to that level.

---

## Recognition Questions

1. Do I need per-level grouping / output?
2. Right-side view, level averages, zigzag order?
3. Minimum depth (first leaf found)?

If YES -> BFS level order.

## Green Flags

- "level order", "each level", "level by level"
- "right side view", "zigzag / spiral"
- "minimum depth"

---

## Templates

**Level Order Traversal**

```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode n = q.poll();
            level.add(n.val);
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        res.add(level);
    }
    return res;
}
```

**Right Side View (last node of each level)**

```java
if (i == size - 1) res.add(n.val);   // inside the level loop above
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 102 | Binary Tree Level Order Traversal | Medium | https://leetcode.com/problems/binary-tree-level-order-traversal/ |
| 199 | Binary Tree Right Side View | Medium | https://leetcode.com/problems/binary-tree-right-side-view/ |
| 103 | Zigzag Level Order Traversal | Medium | https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ |
| 515 | Find Largest Value in Each Tree Row | Medium | https://leetcode.com/problems/find-largest-value-in-each-tree-row/ |
| 111 | Minimum Depth of Binary Tree | Easy | https://leetcode.com/problems/minimum-depth-of-binary-tree/ |
| 116 | Populating Next Right Pointers | Medium | https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Level Order Traversal | Amazon, Microsoft, Meta, Bloomberg |
| Right Side View | Amazon, Meta, Google |
| Zigzag Level Order | Amazon, Microsoft, LinkedIn |

**FAANG focus:** Right Side View and Level Order are the most common BFS-on-tree asks;
both reduce to the same `size`-snapshot loop.
