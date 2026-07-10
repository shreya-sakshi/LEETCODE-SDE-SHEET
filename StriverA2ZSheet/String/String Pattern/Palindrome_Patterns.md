# Palindrome Pattern

## Core Idea

Palindromes are symmetric. Two go-to techniques: **expand around center** (each of the
2n-1 centers) for "longest/count substrings", and **interval DP** for partition-style.

---

## Visual

```
 Expand around center:  b a b a d
                          ^ center = index 1 ('a')
                        <- expand ->
                        b[aba]d  ->  "aba"

 2n-1 centers: each char (odd length) + each gap (even length)
```

---

## Recognition Questions

1. Longest palindromic substring / count palindromic substrings?
2. Is it a palindrome after >= 0 deletions?
3. Partition into palindromes / min cuts?

If YES -> palindrome techniques.

---

## Templates

**Longest Palindromic Substring (expand around center)**

```java
int start = 0, maxLen = 1;
for (int i = 0; i < s.length(); i++) {
    int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
    if (len > maxLen) { maxLen = len; start = i - (len - 1) / 2; }
}
return s.substring(start, start + maxLen);

int expand(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
    return r - l - 1;   // length of palindrome
}
```

**Count Palindromic Substrings** — same expand, add `(r - l - 1 + 1) / 2` count per
center, or simply increment a counter each successful expansion.

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 5 | Longest Palindromic Substring | Medium | https://leetcode.com/problems/longest-palindromic-substring/ |
| 647 | Palindromic Substrings | Medium | https://leetcode.com/problems/palindromic-substrings/ |
| 125 | Valid Palindrome | Easy | https://leetcode.com/problems/valid-palindrome/ |
| 131 | Palindrome Partitioning | Medium | https://leetcode.com/problems/palindrome-partitioning/ |
| 516 | Longest Palindromic Subsequence | Medium | https://leetcode.com/problems/longest-palindromic-subsequence/ |
| 5 | Longest Palindromic Substring | Medium | https://leetcode.com/problems/longest-palindromic-substring/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Longest Palindromic Substring | Amazon, Meta, Microsoft, Google |
| Palindromic Substrings | Amazon, Meta, Google |
| Palindrome Partitioning | Amazon, Google, Bloomberg |

**FAANG focus:** Longest Palindromic Substring is a very common medium; know expand-
around-center (O(n^2), O(1) space) before the DP version.
