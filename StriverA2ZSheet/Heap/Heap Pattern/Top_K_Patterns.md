# Top-K Elements Pattern

## Core Idea

Maintain a heap of size K. For **K largest**, use a **min-heap** (evict the smallest);
for **K smallest**, use a max-heap. O(n log k) beats full sort O(n log n).

---

## Recognition Questions

1. Kth largest / smallest?
2. Top K frequent / K closest?
3. Only need a few extremes, not full order?

If YES -> size-K heap.

## Green Flags

- "kth largest element"
- "top k frequent", "k closest points to origin"

---

## Templates

**Kth Largest Element (min-heap of size k)**

```java
PriorityQueue<Integer> heap = new PriorityQueue<>();   // min-heap
for (int n : nums) {
    heap.offer(n);
    if (heap.size() > k) heap.poll();                  // drop smallest
}
return heap.peek();                                    // kth largest
```

**K Closest Points to Origin (max-heap of size k by distance)**

```java
PriorityQueue<int[]> heap =
    new PriorityQueue<>((a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
for (int[] p : points) {
    heap.offer(p);
    if (heap.size() > k) heap.poll();
}
return heap.toArray(new int[k][]);
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 215 | Kth Largest Element in an Array | Medium | https://leetcode.com/problems/kth-largest-element-in-an-array/ |
| 347 | Top K Frequent Elements | Medium | https://leetcode.com/problems/top-k-frequent-elements/ |
| 973 | K Closest Points to Origin | Medium | https://leetcode.com/problems/k-closest-points-to-origin/ |
| 703 | Kth Largest Element in a Stream | Easy | https://leetcode.com/problems/kth-largest-element-in-a-stream/ |
| 692 | Top K Frequent Words | Medium | https://leetcode.com/problems/top-k-frequent-words/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Kth Largest Element in an Array | Amazon, Meta, Google, Microsoft |
| K Closest Points to Origin | Amazon (very frequent), Meta, Google |
| Top K Frequent Elements | Amazon, Meta, Google, Yelp |

**FAANG focus:** K Closest Points to Origin is one of Amazon's most-asked; also know
Quickselect as the O(n) average alternative for Kth Largest.
