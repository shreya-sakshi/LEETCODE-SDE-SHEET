# Merge & Insert Intervals Pattern

## Core Idea

Sort by start. Walk through; if the current interval overlaps the last kept one,
extend the end, otherwise start a new interval.

---

## Recognition Questions

1. Merge all overlapping intervals?
2. Insert a new interval and merge?
3. Do intervals need combining into fewer ranges?

If YES -> merge/insert.

## Green Flags

- "merge intervals", "overlapping"
- "insert interval"

---

## Templates

**Merge Intervals**

```java
Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
List<int[]> res = new ArrayList<>();
int[] cur = intervals[0];
for (int i = 1; i < intervals.length; i++) {
    if (intervals[i][0] <= cur[1]) {                  // overlap
        cur[1] = Math.max(cur[1], intervals[i][1]);
    } else {
        res.add(cur);
        cur = intervals[i];
    }
}
res.add(cur);
return res.toArray(new int[res.size()][]);
```

**Insert Interval (already sorted)**

```java
List<int[]> res = new ArrayList<>();
int i = 0, n = intervals.length;
while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++]); // before
while (i < n && intervals[i][0] <= newInterval[1]) {                        // overlap
    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    i++;
}
res.add(newInterval);
while (i < n) res.add(intervals[i++]);                                      // after
return res.toArray(new int[res.size()][]);
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 56 | Merge Intervals | Medium | https://leetcode.com/problems/merge-intervals/ |
| 57 | Insert Interval | Medium | https://leetcode.com/problems/insert-interval/ |
| 986 | Interval List Intersections | Medium | https://leetcode.com/problems/interval-list-intersections/ |
| 763 | Partition Labels | Medium | https://leetcode.com/problems/partition-labels/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Merge Intervals | Amazon, Meta, Google, Microsoft, Bloomberg (near-universal) |
| Insert Interval | Amazon, Google, Meta, LinkedIn |
| Interval List Intersections | Amazon, Meta, Google |

**FAANG focus:** Merge Intervals is one of the most-asked medium problems overall;
Insert Interval is a common follow-up.
