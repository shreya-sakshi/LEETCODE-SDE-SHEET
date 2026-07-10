# Overlap Counting (Sweep Line / Two Heaps) Pattern

## Core Idea

To count maximum concurrent intervals (rooms, planes, CPU), process start and end
events in time order: a start +1, an end -1. The running max is the answer.

---

## Recognition Questions

1. Minimum resources to handle all intervals at once?
2. Maximum number of overlapping intervals at any time?
3. "Can a person attend all meetings?"

If YES -> overlap counting / sweep line.

## Green Flags

- "meeting rooms", "minimum conference rooms"
- "maximum overlapping", "car pooling", "my calendar"

---

## Templates

**Meeting Rooms II (min rooms) — sort starts & ends separately**

```java
int n = intervals.length;
int[] starts = new int[n], ends = new int[n];
for (int i = 0; i < n; i++) { starts[i] = intervals[i][0]; ends[i] = intervals[i][1]; }
Arrays.sort(starts); Arrays.sort(ends);

int rooms = 0, maxRooms = 0, e = 0;
for (int s = 0; s < n; s++) {
    while (e < n && ends[e] <= starts[s]) { rooms--; e++; }  // a meeting freed up
    rooms++;
    maxRooms = Math.max(maxRooms, rooms);
}
return maxRooms;
```

**Meeting Rooms I (can attend all?)** — sort by start, check `intervals[i][0] < intervals[i-1][1]` for any overlap.

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 252 | Meeting Rooms | Easy | https://leetcode.com/problems/meeting-rooms/ |
| 253 | Meeting Rooms II | Medium | https://leetcode.com/problems/meeting-rooms-ii/ |
| 1094 | Car Pooling | Medium | https://leetcode.com/problems/car-pooling/ |
| 731 | My Calendar II | Medium | https://leetcode.com/problems/my-calendar-ii/ |
| 218 | The Skyline Problem | Hard | https://leetcode.com/problems/the-skyline-problem/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Meeting Rooms II | Amazon (very frequent), Google, Meta, Microsoft |
| Car Pooling | Amazon, Google |
| The Skyline Problem | Amazon, Google, Meta |

**FAANG focus:** Meeting Rooms II is a top interval question at Amazon/Google — know both
the two-sorted-arrays and the min-heap-of-end-times solutions.
