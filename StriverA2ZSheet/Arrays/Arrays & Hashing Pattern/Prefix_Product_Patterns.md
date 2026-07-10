# Prefix / Suffix (Product & Sum) Pattern

## Core Idea

Precompute running results from the left (prefix) and right (suffix) so each
position can be answered in O(1) without re-scanning. Classic for "except self".

---

## Recognition Questions

1. Need result for each index based on everything except itself?
2. Division is banned but you need a product/sum aggregate?
3. Repeated range-sum queries on a static array?

If YES -> prefix/suffix arrays.

## Green Flags

- "product of array except self"
- "without using division"
- "range sum query (immutable)"

---

## Templates

**Product of Array Except Self (O(n), no division)**

```java
int n = nums.length;
int[] res = new int[n];
res[0] = 1;
for (int i = 1; i < n; i++) res[i] = res[i - 1] * nums[i - 1]; // prefix
int suffix = 1;
for (int i = n - 1; i >= 0; i--) {
    res[i] *= suffix;      // multiply by suffix product
    suffix *= nums[i];
}
return res;
```

**Prefix Sum (range query)**

```java
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];
// sum of [l, r] inclusive:
int sum = prefix[r + 1] - prefix[l];
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 238 | Product of Array Except Self | Medium | https://leetcode.com/problems/product-of-array-except-self/ |
| 303 | Range Sum Query - Immutable | Easy | https://leetcode.com/problems/range-sum-query-immutable/ |
| 304 | Range Sum Query 2D - Immutable | Medium | https://leetcode.com/problems/range-sum-query-2d-immutable/ |
| 724 | Find Pivot Index | Easy | https://leetcode.com/problems/find-pivot-index/ |
| 1480 | Running Sum of 1d Array | Easy | https://leetcode.com/problems/running-sum-of-1d-array/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Product of Array Except Self | Amazon, Meta, Microsoft, Apple, Lyft |
| Range Sum Query 2D | Amazon, Google, Meta |
| Find Pivot Index | Amazon, Google |

**FAANG focus:** Product of Array Except Self is a favorite — interviewers push for the
O(1) extra space (output array) version without division.
