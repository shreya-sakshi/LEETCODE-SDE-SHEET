# String Pattern Matching (KMP / Rabin-Karp) Pattern

## Core Idea

Find a pattern inside text in O(n + m). KMP precomputes a longest-prefix-suffix (LPS)
array to skip re-checks; Rabin-Karp uses rolling hashes.

---

## Visual (KMP LPS)

```
 pattern: a b a b a c
 LPS    : 0 0 1 2 3 0
          ^ length of the longest proper prefix that is also a suffix
 On mismatch at index i, jump pattern pointer to LPS[i-1] instead of restarting.
```

---

## Recognition Questions

1. Substring search / count occurrences?
2. Repeated pattern detection / shortest repeating unit?
3. "Implement strStr()"?

If YES -> KMP / Rabin-Karp (or built-in indexOf for simple cases).

---

## Templates

**Build LPS (KMP)**

```java
int[] buildLPS(String p) {
    int[] lps = new int[p.length()];
    int len = 0, i = 1;
    while (i < p.length()) {
        if (p.charAt(i) == p.charAt(len)) lps[i++] = ++len;
        else if (len > 0) len = lps[len - 1];
        else lps[i++] = 0;
    }
    return lps;
}
```

**Rabin-Karp rolling hash idea**

```java
// hash(window) rolls in O(1): remove leading char * base^(m-1), *base, add new char.
// compare hash first; verify char-by-char only on hash match to avoid collisions.
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 28 | Find the Index of the First Occurrence (strStr) | Easy | https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ |
| 459 | Repeated Substring Pattern | Easy | https://leetcode.com/problems/repeated-substring-pattern/ |
| 686 | Repeated String Match | Medium | https://leetcode.com/problems/repeated-string-match/ |
| 214 | Shortest Palindrome | Hard | https://leetcode.com/problems/shortest-palindrome/ |
| 1392 | Longest Happy Prefix | Hard | https://leetcode.com/problems/longest-happy-prefix/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Implement strStr() | Amazon, Meta, Microsoft |
| Repeated Substring Pattern | Amazon, Google |
| Shortest Palindrome | Google, Amazon |

**FAANG focus:** strStr() is common as a warmup; KMP's LPS array shows up in the harder
"repeated pattern" and "happy prefix" problems.
