# Binary Search on the Answer Pattern

## Core Idea

When the answer is a number in a range and "does value X work?" is **monotonic**
(if X works, everything larger/smaller also works), binary search the answer space
using a feasibility check.

---

## Recognition Questions

1. "Minimum/maximum value such that a condition holds"?
2. Can I write an `isFeasible(x)` that is monotonic in x?
3. "Minimize the maximum" or "maximize the minimum"?

If YES -> binary search on answer.

## Green Flags

- "minimum eating speed", "min days", "min capacity to ship"
- "split array largest sum", "minimize maximum"
- "kth smallest", "median of two sorted arrays"

---

## Template

```java
int lo = minPossible, hi = maxPossible;
while (lo < hi) {
    int mid = lo + (hi - lo) / 2;
    if (isFeasible(mid)) hi = mid;    // mid works -> try smaller
    else lo = mid + 1;                // mid fails -> need bigger
}
return lo;                            // smallest feasible answer
```

**Koko Eating Bananas (feasibility example)**

```java
boolean canFinish(int[] piles, int speed, int h) {
    long hours = 0;
    for (int p : piles) hours += (p + speed - 1) / speed; // ceil
    return hours <= h;
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 875 | Koko Eating Bananas | Medium | https://leetcode.com/problems/koko-eating-bananas/ |
| 1011 | Capacity To Ship Packages Within D Days | Medium | https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/ |
| 410 | Split Array Largest Sum | Hard | https://leetcode.com/problems/split-array-largest-sum/ |
| 4 | Median of Two Sorted Arrays | Hard | https://leetcode.com/problems/median-of-two-sorted-arrays/ |
| 1482 | Minimum Days to Make m Bouquets | Medium | https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/ |
| 774 | Minimize Max Distance to Gas Station | Hard | https://leetcode.com/problems/minimize-max-distance-to-gas-station/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Koko Eating Bananas | Amazon, Meta, Google |
| Capacity To Ship Packages | Amazon (very frequent), Google |
| Split Array Largest Sum | Amazon, Google, Meta |
| Median of Two Sorted Arrays | Amazon, Google, Microsoft, Apple, Adobe |

**FAANG focus:** Median of Two Sorted Arrays (hard) is a classic Google/Amazon question;
the "binary search on answer" family (Koko, Ship Packages) is heavily favored by Amazon.
