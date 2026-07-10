# Classic Binary Search Pattern

## Core Idea

Halve the search space each step on a sorted range. Also covers lower/upper bound
and searching a row-sorted 2D matrix by flattening indices.

---

## Recognition Questions

1. Is the input sorted?
2. Need O(log n) lookup / insertion point?
3. 2D matrix sorted row-wise and column-wise start?

If YES -> classic binary search.

## Green Flags

- "sorted array", "search", "insert position"
- "search a 2D matrix"

---

## Templates

**Search Insert Position / exact**

```java
int lo = 0, hi = nums.length - 1;
while (lo <= hi) {
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] == target) return mid;
    if (nums[mid] < target) lo = mid + 1;
    else hi = mid - 1;
}
return lo;   // insertion index if not found
```

**Search a 2D Matrix (treat as 1D)**

```java
int m = mat.length, n = mat[0].length;
int lo = 0, hi = m * n - 1;
while (lo <= hi) {
    int mid = (lo + hi) / 2;
    int val = mat[mid / n][mid % n];
    if (val == target) return true;
    if (val < target) lo = mid + 1; else hi = mid - 1;
}
return false;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 704 | Binary Search | Easy | https://leetcode.com/problems/binary-search/ |
| 35 | Search Insert Position | Easy | https://leetcode.com/problems/search-insert-position/ |
| 74 | Search a 2D Matrix | Medium | https://leetcode.com/problems/search-a-2d-matrix/ |
| 278 | First Bad Version | Easy | https://leetcode.com/problems/first-bad-version/ |
| 34 | Find First and Last Position | Medium | https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| First Bad Version | Meta, Amazon, Google |
| Search a 2D Matrix | Amazon, Microsoft, Google |
| Find First and Last Position | Amazon, Meta, LinkedIn |

**FAANG focus:** First Bad Version is a common phone screen; know lower/upper bound
to solve "first/last position" cleanly.
