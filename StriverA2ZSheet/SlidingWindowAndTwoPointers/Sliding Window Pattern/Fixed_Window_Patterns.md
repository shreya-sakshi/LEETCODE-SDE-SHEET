# Fixed-Size Window Pattern

## Core Idea

Window of a fixed length `k` slides across the array. Maintain a running
aggregate: add the entering element, remove the leaving element. O(n).

---

## Recognition Questions

1. Is the window length fixed (given k)?
2. Need max/min/avg/sum of every k-length block?
3. Single best "buy low, sell high" style scan?

If YES -> fixed window.

## Green Flags

- "subarray of size k"
- "maximum average", "of length k"
- "best time to buy and sell (one transaction)"

---

## Templates

**Max Sum Subarray of Size K**

```java
int sum = 0, best;
for (int i = 0; i < k; i++) sum += nums[i];
best = sum;
for (int i = k; i < nums.length; i++) {
    sum += nums[i] - nums[i - k];   // add new, drop old
    best = Math.max(best, sum);
}
return best;
```

**Best Time to Buy and Sell Stock (one transaction)**

```java
int minPrice = Integer.MAX_VALUE, profit = 0;
for (int p : prices) {
    minPrice = Math.min(minPrice, p);
    profit = Math.max(profit, p - minPrice);
}
return profit;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 121 | Best Time to Buy and Sell Stock | Easy | https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ |
| 643 | Maximum Average Subarray I | Easy | https://leetcode.com/problems/maximum-average-subarray-i/ |
| 1456 | Max Vowels in a Substring of Given Length | Medium | https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/ |
| 567 | Permutation in String | Medium | https://leetcode.com/problems/permutation-in-string/ |
| 438 | Find All Anagrams in a String | Medium | https://leetcode.com/problems/find-all-anagrams-in-a-string/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Best Time to Buy and Sell Stock | Amazon, Meta, Google, Microsoft, Bloomberg |
| Permutation in String | Amazon, Microsoft, Meta |
| Find All Anagrams in a String | Amazon, Google, Uber |

**FAANG focus:** Best Time to Buy/Sell Stock is a near-universal warmup; anagram/permutation
window problems test fixed-window + frequency map together.
