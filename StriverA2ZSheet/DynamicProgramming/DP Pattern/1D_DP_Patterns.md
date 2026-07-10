# 1-D DP (Linear / Fibonacci-style) Pattern

## Core Idea

`dp[i]` depends on a constant number of previous states (usually `dp[i-1]`, `dp[i-2]`).
Often reducible to O(1) space with two variables.

---

## Recognition Questions

1. Does state `i` depend only on a few earlier states?
2. "Number of ways to reach step i" / "max money up to house i"?
3. Linear scan with a running best/choice?

If YES -> 1-D DP.

## Green Flags

- "climbing stairs", "ways to reach"
- "house robber", "cannot pick adjacent"
- "decode ways", "max subarray"

---

## Templates

**Climbing Stairs / Fibonacci (O(1) space)**

```java
int a = 1, b = 1;             // ways to reach step 0 and 1
for (int i = 2; i <= n; i++) { int c = a + b; a = b; b = c; }
return b;
```

**House Robber (no two adjacent)**

```java
int rob1 = 0, rob2 = 0;       // best up to i-2, i-1
for (int num : nums) {
    int take = rob1 + num;
    rob1 = rob2;
    rob2 = Math.max(rob2, take);
}
return rob2;
```

**Kadane (Max Subarray)**

```java
int best = nums[0], cur = nums[0];
for (int i = 1; i < nums.length; i++) {
    cur = Math.max(nums[i], cur + nums[i]);
    best = Math.max(best, cur);
}
return best;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 70 | Climbing Stairs | Easy | https://leetcode.com/problems/climbing-stairs/ |
| 198 | House Robber | Medium | https://leetcode.com/problems/house-robber/ |
| 213 | House Robber II | Medium | https://leetcode.com/problems/house-robber-ii/ |
| 53 | Maximum Subarray | Medium | https://leetcode.com/problems/maximum-subarray/ |
| 91 | Decode Ways | Medium | https://leetcode.com/problems/decode-ways/ |
| 322 | Coin Change | Medium | https://leetcode.com/problems/coin-change/ |
| 152 | Maximum Product Subarray | Medium | https://leetcode.com/problems/maximum-product-subarray/ |
| 746 | Min Cost Climbing Stairs | Easy | https://leetcode.com/problems/min-cost-climbing-stairs/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Maximum Subarray | Amazon, Meta, Microsoft, LinkedIn, Bloomberg |
| House Robber | Amazon, Google, Meta |
| Decode Ways | Meta, Amazon, Google, Uber |
| Coin Change | Amazon, Google, Meta, Uber |

**FAANG focus:** Maximum Subarray (Kadane) and Coin Change are near-universal; Decode
Ways is a Meta/Uber favorite for testing careful transitions.
