# Knapsack / Subset DP Pattern

## Core Idea

For each item, choose **take or skip** subject to a capacity/target. `dp[cap]` (1-D
rolling) or `dp[i][cap]` tracks the best/count/feasibility. Coin change is unbounded knapsack.

---

## Recognition Questions

1. Items with weights/values and a capacity or target?
2. "Can we reach exactly T?", "fewest coins to make amount"?
3. "Partition into equal subsets"?

If YES -> knapsack family.

## Green Flags

- "subset sum", "partition equal subset"
- "coin change" (min coins / number of ways)
- "target sum", "0/1 knapsack"

---

## Templates

**0/1 Subset Sum (can we hit target?)**

```java
boolean[] dp = new boolean[target + 1];
dp[0] = true;
for (int num : nums)
    for (int c = target; c >= num; c--)     // iterate capacity DOWN for 0/1
        dp[c] = dp[c] || dp[c - num];
return dp[target];
```

**Coin Change (min coins, unbounded)**

```java
int[] dp = new int[amount + 1];
Arrays.fill(dp, amount + 1);
dp[0] = 0;
for (int coin : coins)
    for (int c = coin; c <= amount; c++)    // iterate UP for unbounded
        dp[c] = Math.min(dp[c], dp[c - coin] + 1);
return dp[amount] > amount ? -1 : dp[amount];
```

> Key detail: **0/1 -> loop capacity descending**; **unbounded -> ascending**.

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 416 | Partition Equal Subset Sum | Medium | https://leetcode.com/problems/partition-equal-subset-sum/ |
| 322 | Coin Change | Medium | https://leetcode.com/problems/coin-change/ |
| 518 | Coin Change II (ways) | Medium | https://leetcode.com/problems/coin-change-ii/ |
| 494 | Target Sum | Medium | https://leetcode.com/problems/target-sum/ |
| 474 | Ones and Zeroes | Medium | https://leetcode.com/problems/ones-and-zeroes/ |
| 279 | Perfect Squares | Medium | https://leetcode.com/problems/perfect-squares/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Partition Equal Subset Sum | Amazon, Meta, Google |
| Coin Change | Amazon, Google, Meta, Uber, Microsoft |
| Target Sum | Meta, Amazon, Google |

**FAANG focus:** Coin Change (both min-coins and count variants) shows up constantly;
Partition Equal Subset Sum tests recognising a hidden 0/1 knapsack.
