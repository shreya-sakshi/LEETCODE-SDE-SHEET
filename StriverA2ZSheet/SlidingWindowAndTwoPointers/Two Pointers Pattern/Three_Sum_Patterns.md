# 3Sum / kSum Pattern

## Core Idea

Sort the array, fix one element, then run a converging two-pointer scan for the
remaining pair. Skip duplicates to avoid repeated triplets. Generalizes to kSum.

---

## Recognition Questions

1. Find triplets/quadruplets meeting a sum condition?
2. Need all unique combinations (not just existence)?
3. Is sorting acceptable (order doesn't matter)?

If YES -> sort + fix + two pointers.

## Green Flags

- "three numbers that sum to zero"
- "triplets", "quadruplets"
- "closest sum to target"

---

## Template (3Sum)

```java
Arrays.sort(nums);
List<List<Integer>> res = new ArrayList<>();
for (int i = 0; i < nums.length - 2; i++) {
    if (i > 0 && nums[i] == nums[i - 1]) continue;   // skip dup for i
    int l = i + 1, r = nums.length - 1;
    while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum < 0) l++;
        else if (sum > 0) r--;
        else {
            res.add(Arrays.asList(nums[i], nums[l], nums[r]));
            l++; r--;
            while (l < r && nums[l] == nums[l - 1]) l++;   // skip dup for l
            while (l < r && nums[r] == nums[r + 1]) r--;   // skip dup for r
        }
    }
}
return res;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 15 | 3Sum | Medium | https://leetcode.com/problems/3sum/ |
| 16 | 3Sum Closest | Medium | https://leetcode.com/problems/3sum-closest/ |
| 18 | 4Sum | Medium | https://leetcode.com/problems/4sum/ |
| 259 | 3Sum Smaller | Medium | https://leetcode.com/problems/3sum-smaller/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| 3Sum | Amazon, Meta, Google, Microsoft, Adobe, Apple |
| 3Sum Closest | Amazon, Meta, Bloomberg |
| 4Sum | Amazon, Adobe |

**FAANG focus:** 3Sum is one of the most-asked medium array problems overall —
know the duplicate-skipping logic cold.
