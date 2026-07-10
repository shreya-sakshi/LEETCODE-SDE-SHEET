# Variable-Size Window Pattern

## Core Idea

Expand the right edge to include elements; when the window violates the constraint,
shrink from the left until valid again. Track the best valid window. O(n).

---

## Recognition Questions

1. Longest/shortest contiguous segment under a constraint?
2. "At most K distinct", "no repeating characters", "sum >= target"?
3. Constraint loosens when you remove from the left?

If YES -> variable window.

## Green Flags

- "longest substring without repeating characters"
- "at most K distinct", "at most two distinct"
- "minimum size subarray sum >= target"
- "longest repeating character replacement"

---

## Templates

**Longest Substring Without Repeating Characters**

```java
Map<Character, Integer> last = new HashMap<>();
int left = 0, best = 0;
for (int right = 0; right < s.length(); right++) {
    char c = s.charAt(right);
    if (last.containsKey(c) && last.get(c) >= left)
        left = last.get(c) + 1;      // jump left past the previous occurrence
    last.put(c, right);
    best = Math.max(best, right - left + 1);
}
return best;
```

**Minimum Size Subarray Sum (sum >= target)**

```java
int left = 0, sum = 0, best = Integer.MAX_VALUE;
for (int right = 0; right < nums.length; right++) {
    sum += nums[right];
    while (sum >= target) {          // shrink while still valid
        best = Math.min(best, right - left + 1);
        sum -= nums[left++];
    }
}
return best == Integer.MAX_VALUE ? 0 : best;
```

**Longest Repeating Character Replacement**

```java
int[] count = new int[26];
int left = 0, maxFreq = 0, best = 0;
for (int right = 0; right < s.length(); right++) {
    maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);
    while ((right - left + 1) - maxFreq > k) count[s.charAt(left++) - 'A']--;
    best = Math.max(best, right - left + 1);
}
return best;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 3 | Longest Substring Without Repeating Characters | Medium | https://leetcode.com/problems/longest-substring-without-repeating-characters/ |
| 424 | Longest Repeating Character Replacement | Medium | https://leetcode.com/problems/longest-repeating-character-replacement/ |
| 209 | Minimum Size Subarray Sum | Medium | https://leetcode.com/problems/minimum-size-subarray-sum/ |
| 76 | Minimum Window Substring | Hard | https://leetcode.com/problems/minimum-window-substring/ |
| 340 | Longest Substring with At Most K Distinct | Medium | https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/ |
| 904 | Fruit Into Baskets | Medium | https://leetcode.com/problems/fruit-into-baskets/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Longest Substring Without Repeating Chars | Amazon, Meta, Google, Microsoft, Bloomberg, Adobe |
| Minimum Window Substring | Meta, Amazon, Google, Uber, LinkedIn |
| Longest Repeating Character Replacement | Amazon, Google, Meta |
| Minimum Size Subarray Sum | Amazon, Google, Facebook |

**FAANG focus:** Longest Substring Without Repeating Chars and Minimum Window Substring
(hard) are extremely common — master the expand/shrink skeleton.
