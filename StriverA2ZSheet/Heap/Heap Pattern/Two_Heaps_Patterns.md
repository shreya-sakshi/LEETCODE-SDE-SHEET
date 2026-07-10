# Two Heaps (Median / Balance) Pattern

## Core Idea

Keep a max-heap for the smaller half and a min-heap for the larger half, balanced in
size. The median is at the tops. Great for streaming medians.

---

## Recognition Questions

1. Median of a stream / sliding window median?
2. Continuously balance smaller vs larger halves?
3. Need the middle element(s) efficiently as data arrives?

If YES -> two heaps.

## Green Flags

- "find median from data stream"
- "sliding window median"
- "IPO / maximize capital" (two heaps variant)

---

## Template (Median from Data Stream)

```java
PriorityQueue<Integer> lo = new PriorityQueue<>((a,b) -> b - a); // max-heap (small half)
PriorityQueue<Integer> hi = new PriorityQueue<>();               // min-heap (large half)

void addNum(int num) {
    lo.offer(num);
    hi.offer(lo.poll());                 // balance value-wise
    if (hi.size() > lo.size()) lo.offer(hi.poll()); // keep lo >= hi in size
}

double findMedian() {
    return lo.size() > hi.size()
        ? lo.peek()
        : (lo.peek() + hi.peek()) / 2.0;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 295 | Find Median from Data Stream | Hard | https://leetcode.com/problems/find-median-from-data-stream/ |
| 480 | Sliding Window Median | Hard | https://leetcode.com/problems/sliding-window-median/ |
| 502 | IPO | Hard | https://leetcode.com/problems/ipo/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Find Median from Data Stream | Amazon, Google, Meta, Microsoft |
| Sliding Window Median | Amazon, Google |
| IPO | Amazon, Google |

**FAANG focus:** Find Median from Data Stream (hard) is the flagship two-heaps question,
frequently asked at Amazon and Google.
