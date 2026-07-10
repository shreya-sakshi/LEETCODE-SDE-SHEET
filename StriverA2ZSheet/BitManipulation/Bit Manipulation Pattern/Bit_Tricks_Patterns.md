# Bit Tricks (Counting / Masks) Pattern

## Core Idea

Manipulate individual bits to count, reverse, add without `+`, or enumerate subsets
via bitmasks. `x & (x-1)` clears the lowest set bit — the key counting trick.

---

## Recognition Questions

1. Count set bits (Hamming weight / for 0..n)?
2. Reverse bits / swap / add without operators?
3. Enumerate all subsets (bitmask DP)?

If YES -> bit tricks.

## Green Flags

- "number of 1 bits", "counting bits"
- "reverse bits", "sum of two integers"

---

## Templates

**Count Bits for 0..n (DP on lowest bit)**

```java
int[] dp = new int[n + 1];
for (int i = 1; i <= n; i++) dp[i] = dp[i >> 1] + (i & 1);
return dp;
```

**Hamming Weight (Brian Kernighan)**

```java
int count = 0;
while (x != 0) { x &= (x - 1); count++; }   // clears lowest set bit each loop
return count;
```

**Sum of Two Integers (no + / -)**

```java
while (b != 0) {
    int carry = (a & b) << 1;
    a = a ^ b;
    b = carry;
}
return a;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 191 | Number of 1 Bits | Easy | https://leetcode.com/problems/number-of-1-bits/ |
| 338 | Counting Bits | Easy | https://leetcode.com/problems/counting-bits/ |
| 190 | Reverse Bits | Easy | https://leetcode.com/problems/reverse-bits/ |
| 371 | Sum of Two Integers | Medium | https://leetcode.com/problems/sum-of-two-integers/ |
| 78 | Subsets (bitmask variant) | Medium | https://leetcode.com/problems/subsets/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Number of 1 Bits | Amazon, Apple, Microsoft |
| Counting Bits | Amazon, Google |
| Reverse Bits | Amazon, Apple |
| Sum of Two Integers | Amazon, Google, Meta |

**FAANG focus:** Counting Bits and Number of 1 Bits are common; Sum of Two Integers is
a classic "no arithmetic operators" trick question.
