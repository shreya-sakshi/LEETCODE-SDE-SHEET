# Sort-Then-Greedy Pattern

## Core Idea

Sort by a well-chosen key (end time, ratio, deadline), then make a single greedy pass
selecting or skipping items. Sorting exposes the greedy-choice order.

---

## Recognition Questions

1. Choose the maximum set of non-conflicting items?
2. Assign/consume by best ratio or earliest deadline?
3. "Minimum number of X to cover/remove"?

If YES -> sort then greedy.

## Green Flags

- "maximum number of non-overlapping intervals"
- "assign cookies", "minimum arrows to burst balloons"
- "two city scheduling"

---

## Templates

**Non-overlapping Intervals (keep max compatible, by end time)**

```java
Arrays.sort(intervals, (a,b) -> a[1] - b[1]);   // sort by end
int end = Integer.MIN_VALUE, removed = 0;
for (int[] it : intervals) {
    if (it[0] >= end) end = it[1];              // keep it
    else removed++;                              // overlaps -> remove
}
return removed;
```

**Assign Cookies (two-pointer greedy)**

```java
Arrays.sort(g); Arrays.sort(s);
int i = 0, j = 0;
while (i < g.length && j < s.length) {
    if (s[j] >= g[i]) i++;                        // satisfy child i
    j++;
}
return i;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 435 | Non-overlapping Intervals | Medium | https://leetcode.com/problems/non-overlapping-intervals/ |
| 452 | Minimum Arrows to Burst Balloons | Medium | https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/ |
| 455 | Assign Cookies | Easy | https://leetcode.com/problems/assign-cookies/ |
| 1029 | Two City Scheduling | Medium | https://leetcode.com/problems/two-city-scheduling/ |
| 406 | Queue Reconstruction by Height | Medium | https://leetcode.com/problems/queue-reconstruction-by-height/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Non-overlapping Intervals | Amazon, Google, Meta |
| Minimum Arrows to Burst Balloons | Amazon, Meta |
| Two City Scheduling | Amazon, Google |
| Queue Reconstruction by Height | Amazon, Google |

**FAANG focus:** The "sort by end time, greedily keep" trick powers most interval-greedy
questions — very common at Amazon/Google.
