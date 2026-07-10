# String Hashing / Frequency Pattern

## Core Idea

Represent a string by a fixed-size `count[26]` (lowercase) or a HashMap. Two strings
are anagrams iff their counts match. Frequency signatures group related strings.

---

## Visual

```
 "listen"          "silent"
 l i s t e n        s i l e n t
 count[26]:  e:1 i:1 l:1 n:1 s:1 t:1   ==  same  -> anagram
```

---

## Recognition Questions

1. Anagram / permutation of another string?
2. Group strings by letter content?
3. Count characters / build a signature?

If YES -> string hashing.

---

## Templates

**Valid Anagram**

```java
if (s.length() != t.length()) return false;
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) { count[s.charAt(i)-'a']++; count[t.charAt(i)-'a']--; }
for (int c : count) if (c != 0) return false;
return true;
```

**Encode / Decode Strings (length-prefix)**

```java
// encode: for each s -> s.length() + "#" + s
// decode: read digits until '#', then read that many chars
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 242 | Valid Anagram | Easy | https://leetcode.com/problems/valid-anagram/ |
| 49 | Group Anagrams | Medium | https://leetcode.com/problems/group-anagrams/ |
| 271 | Encode and Decode Strings | Medium | https://leetcode.com/problems/encode-and-decode-strings/ |
| 383 | Ransom Note | Easy | https://leetcode.com/problems/ransom-note/ |
| 205 | Isomorphic Strings | Easy | https://leetcode.com/problems/isomorphic-strings/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Valid Anagram | Amazon, Meta, Bloomberg, Uber |
| Group Anagrams | Amazon, Meta, Uber, Microsoft |
| Encode and Decode Strings | Google, Meta, Amazon |

**FAANG focus:** Encode and Decode Strings is a common Google/Meta design-ish question;
Group Anagrams tests the count-signature key.
