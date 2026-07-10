# Sequence DP (LCS / Edit Distance / LIS) Pattern

## Core Idea

Compare or transform sequences. `dp[i][j]` relates prefixes of two strings; LIS uses
`dp[i]` = best subsequence ending at i (or patience sorting for O(n log n)).

---

## Recognition Questions

1. Two strings/arrays compared (common/edit/match)?
2. Longest increasing/common subsequence?
3. "Minimum operations to convert A to B"?

If YES -> sequence DP.

## Green Flags

- "longest common subsequence", "edit distance"
- "longest increasing subsequence"
- "distinct subsequences", "interleaving string"

---

## Templates

**Longest Common Subsequence**

```java
int[][] dp = new int[m + 1][n + 1];
for (int i = 1; i <= m; i++)
    for (int j = 1; j <= n; j++)
        dp[i][j] = (a.charAt(i-1) == b.charAt(j-1))
                 ? dp[i-1][j-1] + 1
                 : Math.max(dp[i-1][j], dp[i][j-1]);
return dp[m][n];
```

**Edit Distance**

```java
for (int i = 0; i <= m; i++) dp[i][0] = i;
for (int j = 0; j <= n; j++) dp[0][j] = j;
for (int i = 1; i <= m; i++)
    for (int j = 1; j <= n; j++)
        dp[i][j] = (a.charAt(i-1) == b.charAt(j-1))
                 ? dp[i-1][j-1]
                 : 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
return dp[m][n];
```

**LIS (O(n log n), patience)**

```java
List<Integer> tails = new ArrayList<>();
for (int x : nums) {
    int i = Collections.binarySearch(tails, x);
    if (i < 0) i = -(i + 1);
    if (i == tails.size()) tails.add(x); else tails.set(i, x);
}
return tails.size();
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 1143 | Longest Common Subsequence | Medium | https://leetcode.com/problems/longest-common-subsequence/ |
| 72 | Edit Distance | Medium | https://leetcode.com/problems/edit-distance/ |
| 300 | Longest Increasing Subsequence | Medium | https://leetcode.com/problems/longest-increasing-subsequence/ |
| 516 | Longest Palindromic Subsequence | Medium | https://leetcode.com/problems/longest-palindromic-subsequence/ |
| 115 | Distinct Subsequences | Hard | https://leetcode.com/problems/distinct-subsequences/ |
| 97 | Interleaving String | Medium | https://leetcode.com/problems/interleaving-string/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Longest Common Subsequence | Amazon, Google, Microsoft |
| Edit Distance | Google, Amazon, Meta, Microsoft |
| Longest Increasing Subsequence | Amazon, Google, Meta, Microsoft |

**FAANG focus:** Edit Distance and LIS are top interview DP; know LIS in both O(n^2)
and O(n log n).
