# Divide & Conquer (Merge / Quickselect) Pattern

## Core Idea

Split, solve halves, combine. Merge sort's merge step powers "count while sorting"
problems; Quickselect finds the Kth element in O(n) average without full sorting.

---

## Recognition Questions

1. Count inversions / pairs while sorting?
2. Kth largest/smallest in O(n) average?
3. Merge-based counting (reverse pairs, smaller after self)?

If YES -> divide & conquer.

---

## Templates

**Quickselect (Kth largest)**

```java
int quickselect(int[] a, int lo, int hi, int kSmallest) {
    if (lo == hi) return a[lo];
    int pivot = a[hi], p = lo;
    for (int i = lo; i < hi; i++) if (a[i] < pivot) swap(a, i, p++);
    swap(a, p, hi);
    if (p == kSmallest) return a[p];
    return p < kSmallest ? quickselect(a, p + 1, hi, kSmallest)
                         : quickselect(a, lo, p - 1, kSmallest);
}
// Kth largest => kSmallest index = n - k
```

**Merge Sort skeleton (counting inversions)**

```java
// during merge, when a[i] > a[j] (i in left, j in right),
// all remaining left elements form inversions with a[j]: count += (mid - i + 1)
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 215 | Kth Largest Element in an Array | Medium | https://leetcode.com/problems/kth-largest-element-in-an-array/ |
| 912 | Sort an Array | Medium | https://leetcode.com/problems/sort-an-array/ |
| 493 | Reverse Pairs | Hard | https://leetcode.com/problems/reverse-pairs/ |
| 315 | Count of Smaller Numbers After Self | Hard | https://leetcode.com/problems/count-of-smaller-numbers-after-self/ |
| 148 | Sort List | Medium | https://leetcode.com/problems/sort-list/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Kth Largest Element | Amazon, Meta, Google, Microsoft |
| Sort List (merge sort on linked list) | Amazon, Meta, Microsoft |
| Reverse Pairs | Google, Amazon |
| Count of Smaller Numbers After Self | Google, Amazon |

**FAANG focus:** Kth Largest via Quickselect is a top question; the merge-sort counting
trick (Reverse Pairs / Count Smaller) is a hard Google favorite.
