# Greedy Scan Pattern

## Core Idea

Sweep once, maintaining a running quantity (farthest reach, best profit, current sum)
and making the locally best choice at each step.

---

## Recognition Questions

1. Can I reach the last index / with min jumps?
2. Maximize total profit from repeated up-moves?
3. Track a running max/min while scanning?

If YES -> greedy scan.

## Green Flags

- "jump game", "can you reach the end"
- "gas station", "maximum profit"

---

## Templates

**Jump Game (reachability)**

```java
int farthest = 0;
for (int i = 0; i < nums.length; i++) {
    if (i > farthest) return false;              // stuck
    farthest = Math.max(farthest, i + nums[i]);
}
return true;
```

**Jump Game II (min jumps, BFS-like greedy)**

```java
int jumps = 0, curEnd = 0, farthest = 0;
for (int i = 0; i < nums.length - 1; i++) {
    farthest = Math.max(farthest, i + nums[i]);
    if (i == curEnd) { jumps++; curEnd = farthest; }
}
return jumps;
```

**Gas Station**

```java
int total = 0, tank = 0, start = 0;
for (int i = 0; i < gas.length; i++) {
    int diff = gas[i] - cost[i];
    total += diff; tank += diff;
    if (tank < 0) { start = i + 1; tank = 0; }   // restart after failing point
}
return total >= 0 ? start : -1;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 55 | Jump Game | Medium | https://leetcode.com/problems/jump-game/ |
| 45 | Jump Game II | Medium | https://leetcode.com/problems/jump-game-ii/ |
| 134 | Gas Station | Medium | https://leetcode.com/problems/gas-station/ |
| 53 | Maximum Subarray | Medium | https://leetcode.com/problems/maximum-subarray/ |
| 763 | Partition Labels | Medium | https://leetcode.com/problems/partition-labels/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Jump Game | Amazon, Google, Meta |
| Gas Station | Amazon, Google, Bloomberg |
| Partition Labels | Amazon (very frequent), Meta, Google |

**FAANG focus:** Jump Game (I/II) and Partition Labels are common greedy scans;
Partition Labels is a favorite Amazon medium.
