# Prefix Sum - Range Query Pattern

## Core Idea

Build `prefix[i+1] = prefix[i] + nums[i]` once (O(n)); answer any range sum in O(1).
Extends to 2D grids.

---

## Visual

```
1D:   sum(l..r) = prefix[r+1] - prefix[l]

2D:   sum of rectangle (r1,c1)..(r2,c2)
      = P[r2+1][c2+1] - P[r1][c2+1] - P[r2+1][c1] + P[r1][c1]

      +-----------------+
      |        A        |   result = Full - A - B + overlap
      |   +---------+    |
      |   |  query  |    |
      +---+---------+----+
```

---

## Recognition Questions

1. Many sum queries over ranges of a fixed array?
2. Submatrix sum queries?
3. "Immutable" in the title?

If YES -> Prefix Sum.

---

## Templates

**1D Immutable Range Sum**

```java
class NumArray {
    int[] prefix;
    NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
    }
    int sumRange(int l, int r) { return prefix[r + 1] - prefix[l]; }
}
```

**Find Pivot Index**

```java
int total = Arrays.stream(nums).sum(), left = 0;
for (int i = 0; i < nums.length; i++) {
    if (left == total - left - nums[i]) return i;   // left sum == right sum
    left += nums[i];
}
return -1;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 303 | Range Sum Query - Immutable | Easy | https://leetcode.com/problems/range-sum-query-immutable/ |
| 304 | Range Sum Query 2D - Immutable | Medium | https://leetcode.com/problems/range-sum-query-2d-immutable/ |
| 724 | Find Pivot Index | Easy | https://leetcode.com/problems/find-pivot-index/ |
| 1480 | Running Sum of 1d Array | Easy | https://leetcode.com/problems/running-sum-of-1d-array/ |
| 238 | Product of Array Except Self | Medium | https://leetcode.com/problems/product-of-array-except-self/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Range Sum Query 2D | Amazon, Google, Meta |
| Find Pivot Index | Amazon, Google |
| Product of Array Except Self | Amazon, Meta, Microsoft, Apple |

**FAANG focus:** Range Sum Query 2D tests the inclusion-exclusion rectangle formula —
a common Google/Amazon medium.
