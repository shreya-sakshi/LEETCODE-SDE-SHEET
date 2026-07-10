# Parentheses / Matching Pattern

## Core Idea

Push opening symbols; on a closing symbol, the top must be its match. Stack empty at
the end = balanced. Great for nesting, undo, and "most recent" logic.

---

## Recognition Questions

1. Balanced brackets / valid parentheses?
2. Need to match/cancel the most recent unmatched item?
3. Simplify a path / process nested structure?

If YES -> matching stack.

## Green Flags

- "valid parentheses", "balanced"
- "remove invalid parentheses"
- "simplify path"

---

## Template (Valid Parentheses)

```java
Deque<Character> st = new ArrayDeque<>();
Map<Character, Character> pair = Map.of(')', '(', ']', '[', '}', '{');
for (char c : s.toCharArray()) {
    if (pair.containsValue(c)) st.push(c);              // opening
    else if (st.isEmpty() || st.pop() != pair.get(c)) return false;
}
return st.isEmpty();
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 20 | Valid Parentheses | Easy | https://leetcode.com/problems/valid-parentheses/ |
| 921 | Minimum Add to Make Parentheses Valid | Medium | https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/ |
| 1249 | Minimum Remove to Make Valid Parentheses | Medium | https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/ |
| 71 | Simplify Path | Medium | https://leetcode.com/problems/simplify-path/ |
| 32 | Longest Valid Parentheses | Hard | https://leetcode.com/problems/longest-valid-parentheses/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Valid Parentheses | Amazon, Meta, Google, Microsoft, Bloomberg (near-universal) |
| Minimum Remove to Make Valid Parentheses | Meta (very frequent), Amazon |
| Simplify Path | Meta, Amazon, Microsoft |

**FAANG focus:** Valid Parentheses is a classic warmup; Minimum Remove to Make Valid
Parentheses is one of Meta's most-asked.
