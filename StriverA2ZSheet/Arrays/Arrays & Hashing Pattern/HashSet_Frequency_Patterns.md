# HashSet & Frequency Pattern

## Core Idea

Use a `HashSet` for membership ("seen it?") and a `HashMap<key,count>` for
frequency ("how many?"). O(1) average lookup replaces nested loops.

---

## Recognition Questions

1. Do I need to know if an element appeared before?
2. Do I need counts / frequencies of elements or characters?
3. Am I checking if two collections have the same multiset (anagram)?
4. Do I need the longest consecutive run?

If YES -> HashSet / HashMap.

## Green Flags

- "contains duplicate", "unique", "seen", "distinct"
- "anagram", "frequency", "count of"
- "consecutive sequence"

---

## Templates

**Membership (duplicate check)**

```java
Set<Integer> seen = new HashSet<>();
for (int x : nums) {
    if (!seen.add(x)) return true; // add returns false if already present
}
return false;
```

**Frequency map**

```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : s.toCharArray())
    freq.put(c, freq.getOrDefault(c, 0) + 1);
```

**Longest Consecutive Sequence (O(n))**

```java
Set<Integer> set = new HashSet<>();
for (int n : nums) set.add(n);
int best = 0;
for (int n : set) {
    if (!set.contains(n - 1)) {        // only start at a sequence head
        int len = 1;
        while (set.contains(n + len)) len++;
        best = Math.max(best, len);
    }
}
return best;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 217 | Contains Duplicate | Easy | https://leetcode.com/problems/contains-duplicate/ |
| 242 | Valid Anagram | Easy | https://leetcode.com/problems/valid-anagram/ |
| 383 | Ransom Note | Easy | https://leetcode.com/problems/ransom-note/ |
| 268 | Missing Number | Easy | https://leetcode.com/problems/missing-number/ |
| 128 | Longest Consecutive Sequence | Medium | https://leetcode.com/problems/longest-consecutive-sequence/ |
| 349 | Intersection of Two Arrays | Easy | https://leetcode.com/problems/intersection-of-two-arrays/ |
| 136 | Single Number | Easy | https://leetcode.com/problems/single-number/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Contains Duplicate | Amazon, Google, Adobe |
| Valid Anagram | Amazon, Meta, Bloomberg, Uber |
| Longest Consecutive Sequence | Google, Amazon, Meta, Microsoft |
| Missing Number | Amazon, Microsoft, Apple |
| Single Number | Amazon, Google, Bloomberg |

**FAANG focus:** Valid Anagram and Longest Consecutive Sequence are the highest-signal
here (Meta & Google love LCS as a "can you get O(n)?" filter).
