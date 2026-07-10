# Strings - Master Revision Note

Striver A2Z "Strings" (basic + advanced). Many string problems reuse Array patterns
(two pointers, sliding window, hashing) plus a few string-specific algorithms.

> Company tags are *commonly reported* associations, not official live data.

---

## Which string technique?

```mermaid
flowchart TD
    A[String problem] --> B{Anagram / frequency?}
    B -->|yes| C[count[26] / HashMap]
    A --> D{Longest / shortest substring w/ constraint?}
    D -->|yes| E[Sliding Window]
    A --> F{Palindrome?}
    F -->|yes| G[Expand Around Center / DP]
    A --> H{Pattern / substring search?}
    H -->|yes| I[KMP / Rabin-Karp]
    A --> J{Parsing / nesting?}
    J -->|yes| K[Stack]
```

---

## Master Decision Table

| If the problem asks for...                              | File / Topic |
|---------------------------------------------------------|--------------|
| Anagrams, frequency, encode/decode                      | [String_Hashing_Patterns](./String_Hashing_Patterns.md) |
| Palindrome (longest/count/partition)                    | [Palindrome_Patterns](./Palindrome_Patterns.md) |
| Longest/shortest substring under a constraint           | Sliding Window notes |
| Substring / pattern search                              | [Pattern_Matching_Patterns](./Pattern_Matching_Patterns.md) |

---

## Cross-references (already covered elsewhere)

- **Longest Substring Without Repeating / Min Window** -> `SlidingWindowAndTwoPointers/Sliding Window Pattern`.
- **Valid Palindrome (two pointer)** -> `Two Pointers Pattern/Opposite_Ends_Patterns.md`.
- **Valid Parentheses** -> `StackAndQueue/Stack Pattern`.
- **Group Anagrams / Top-K words** -> `Arrays & Hashing Pattern`.

---

## Files in this folder

1. `String_Hashing_Patterns.md`
2. `Palindrome_Patterns.md`
3. `Pattern_Matching_Patterns.md`
