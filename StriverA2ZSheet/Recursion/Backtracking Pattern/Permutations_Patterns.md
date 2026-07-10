# Permutations Pattern

## Core Idea

Generate all orderings. Track which elements are used (order matters, so start from 0
each time but skip already-used indices). Sort + skip for duplicates.

---

## Recognition Questions

1. All arrangements / orderings?
2. Order matters ([1,2] != [2,1])?
3. Generate sequences / phone letter combos?

If YES -> permutations backtracking.

## Green Flags

- "all permutations", "arrangements"
- "letter combinations of a phone number"

---

## Templates

**Permutations (unique input)**

```java
void backtrack(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
    if (cur.size() == nums.length) { res.add(new ArrayList<>(cur)); return; }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true; cur.add(nums[i]);
        backtrack(nums, used, cur, res);
        used[i] = false; cur.remove(cur.size() - 1);
    }
}
```

**Permutations II (with duplicates)** — sort first, then:

```java
if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 46 | Permutations | Medium | https://leetcode.com/problems/permutations/ |
| 47 | Permutations II | Medium | https://leetcode.com/problems/permutations-ii/ |
| 17 | Letter Combinations of a Phone Number | Medium | https://leetcode.com/problems/letter-combinations-of-a-phone-number/ |
| 784 | Letter Case Permutation | Medium | https://leetcode.com/problems/letter-case-permutation/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Permutations | Amazon, Meta, Microsoft, LinkedIn |
| Letter Combinations of a Phone Number | Amazon, Meta, Google, Uber, Dropbox |

**FAANG focus:** Letter Combinations of a Phone Number is a very frequent early-round
backtracking question; Permutations tests the used[] bookkeeping.
