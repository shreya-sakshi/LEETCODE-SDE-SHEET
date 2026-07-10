# XOR Pattern

## Core Idea

XOR cancels pairs (`a ^ a = 0`). So XOR-ing everything leaves the unpaired value.
Also useful for missing numbers and swapping without temp.

---

## Recognition Questions

1. Every element appears twice except one?
2. Find a missing / duplicated number in [0..n]?
3. "Without extra space, O(n)"?

If YES -> XOR.

## Green Flags

- "single number", "appears once"
- "missing number"

---

## Templates

**Single Number**

```java
int x = 0;
for (int n : nums) x ^= n;
return x;                    // the unique element
```

**Missing Number (0..n)**

```java
int x = nums.length;
for (int i = 0; i < nums.length; i++) x ^= i ^ nums[i];
return x;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 136 | Single Number | Easy | https://leetcode.com/problems/single-number/ |
| 137 | Single Number II | Medium | https://leetcode.com/problems/single-number-ii/ |
| 260 | Single Number III | Medium | https://leetcode.com/problems/single-number-iii/ |
| 268 | Missing Number | Easy | https://leetcode.com/problems/missing-number/ |
| 421 | Maximum XOR of Two Numbers | Medium | https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Single Number | Amazon, Google, Meta, Bloomberg |
| Missing Number | Amazon, Microsoft, Apple |
| Maximum XOR of Two Numbers | Amazon, Google |

**FAANG focus:** Single Number and Missing Number are common easy filters that test
whether you reach for XOR instead of a hash set.
