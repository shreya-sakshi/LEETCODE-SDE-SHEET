# Monotonic Deque (Sliding Window Max/Min) Pattern

## Core Idea

Maintain a deque of indices whose values are monotonic. The front always holds the
max (or min) of the current window. Each index is pushed/popped once -> O(n).

---

## Recognition Questions

1. Need the max/min of EVERY window of size k?
2. Naive O(n*k) too slow?
3. Need "nearest greater/smaller within a window"?

If YES -> monotonic deque.

## Green Flags

- "sliding window maximum"
- "max of each subarray of size k"

---

## Template (Sliding Window Maximum)

```java
int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();   // stores indices, values decreasing
    int[] res = new int[nums.length - k + 1];
    int ri = 0;
    for (int i = 0; i < nums.length; i++) {
        if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst(); // out of window
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
        dq.offerLast(i);
        if (i >= k - 1) res[ri++] = nums[dq.peekFirst()];
    }
    return res;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 239 | Sliding Window Maximum | Hard | https://leetcode.com/problems/sliding-window-maximum/ |
| 1438 | Longest Continuous Subarray with Abs Diff <= Limit | Medium | https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/ |
| 862 | Shortest Subarray with Sum at Least K | Hard | https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Sliding Window Maximum | Amazon, Google, Meta, Microsoft |
| Longest Subarray Abs Diff <= Limit | Amazon, Google |
| Shortest Subarray with Sum at Least K | Google, Amazon |

**FAANG focus:** Sliding Window Maximum is the canonical monotonic-deque question and a
frequent Google/Amazon hard.
