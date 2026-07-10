# Subsets & Combinations Pattern

## Core Idea

Build results by deciding, at each index, to include or skip an element (subsets),
or by advancing a `start` index so combinations don't repeat.

---

## Recognition Questions

1. All subsets / power set?
2. All combinations summing to a target?
3. Order does NOT matter (combination, not permutation)?

If YES -> subsets/combinations backtracking.

## Green Flags

- "all subsets", "power set"
- "combination sum", "combinations of k numbers"

---

## Templates

**Subsets**

```java
void backtrack(int start, int[] nums, List<Integer> cur, List<List<Integer>> res) {
    res.add(new ArrayList<>(cur));
    for (int i = start; i < nums.length; i++) {
        cur.add(nums[i]);
        backtrack(i + 1, nums, cur, res);
        cur.remove(cur.size() - 1);
    }
}
```

**Combination Sum (reuse allowed -> pass i, not i+1)**

```java
void backtrack(int start, int target, int[] c, List<Integer> cur, List<List<Integer>> res) {
    if (target == 0) { res.add(new ArrayList<>(cur)); return; }
    if (target < 0) return;
    for (int i = start; i < c.length; i++) {
        cur.add(c[i]);
        backtrack(i, target - c[i], c, cur, res);   // i => can reuse c[i]
        cur.remove(cur.size() - 1);
    }
}
```

> For "no duplicates in result" with a duplicate input: sort, then
> `if (i > start && nums[i] == nums[i-1]) continue;`

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 78 | Subsets | Medium | https://leetcode.com/problems/subsets/ |
| 90 | Subsets II | Medium | https://leetcode.com/problems/subsets-ii/ |
| 39 | Combination Sum | Medium | https://leetcode.com/problems/combination-sum/ |
| 40 | Combination Sum II | Medium | https://leetcode.com/problems/combination-sum-ii/ |
| 77 | Combinations | Medium | https://leetcode.com/problems/combinations/ |
| 131 | Palindrome Partitioning | Medium | https://leetcode.com/problems/palindrome-partitioning/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Subsets | Amazon, Meta, Google, Bloomberg |
| Combination Sum | Amazon, Meta, Google, Uber |
| Palindrome Partitioning | Amazon, Google, Bloomberg |

**FAANG focus:** Subsets and Combination Sum are the canonical backtracking warmups;
learn the duplicate-skip trick for the "II" variants.
