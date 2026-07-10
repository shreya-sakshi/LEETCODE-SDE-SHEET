# Grid / 2-D DP Pattern

## Core Idea

`dp[i][j]` = best/count to reach cell `(i,j)`, built from the cell above and/or to the
left. Often reducible to a single rolling row.

---

## Recognition Questions

1. Move through a grid with restricted directions (right/down)?
2. "Number of unique paths" / "minimum path sum"?
3. Obstacles or costs on cells?

If YES -> grid DP.

## Green Flags

- "unique paths", "how many ways to reach bottom-right"
- "minimum path sum", "maximal square"

---

## Templates

**Unique Paths**

```java
int[][] dp = new int[m][n];
for (int i = 0; i < m; i++) dp[i][0] = 1;
for (int j = 0; j < n; j++) dp[0][j] = 1;
for (int i = 1; i < m; i++)
    for (int j = 1; j < n; j++)
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
return dp[m - 1][n - 1];
```

**Minimum Path Sum**

```java
for (int i = 0; i < m; i++)
    for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) continue;
        int up   = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
        int left = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
        grid[i][j] += Math.min(up, left);
    }
return grid[m - 1][n - 1];
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 62 | Unique Paths | Medium | https://leetcode.com/problems/unique-paths/ |
| 63 | Unique Paths II (obstacles) | Medium | https://leetcode.com/problems/unique-paths-ii/ |
| 64 | Minimum Path Sum | Medium | https://leetcode.com/problems/minimum-path-sum/ |
| 221 | Maximal Square | Medium | https://leetcode.com/problems/maximal-square/ |
| 120 | Triangle | Medium | https://leetcode.com/problems/triangle/ |
| 931 | Minimum Falling Path Sum | Medium | https://leetcode.com/problems/minimum-falling-path-sum/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Unique Paths | Amazon, Google, Bloomberg |
| Minimum Path Sum | Amazon, Google, Goldman Sachs |
| Maximal Square | Amazon, Meta, Google |

**FAANG focus:** Unique Paths and Maximal Square are common medium grid-DP questions;
Maximal Square adds the "min of three neighbours + 1" twist.
