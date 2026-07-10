# Same-Direction (Slow/Fast Write) Pattern

## Core Idea

Two pointers moving the same way: a **fast** reader scans, a **slow** writer places
kept elements. Used for in-place dedupe, partitioning, and moving values.

---

## Recognition Questions

1. Modify the array in place (no extra array)?
2. Remove/keep elements based on a condition?
3. Move certain values (zeroes) to one side?

If YES -> slow/fast same-direction pointers.

## Green Flags

- "in place", "O(1) extra space"
- "remove duplicates from sorted array"
- "move zeroes", "remove element"

---

## Templates

**Remove Duplicates from Sorted Array**

```java
int slow = 0;
for (int fast = 1; fast < nums.length; fast++) {
    if (nums[fast] != nums[slow]) {
        slow++;
        nums[slow] = nums[fast];
    }
}
return slow + 1; // length of unique prefix
```

**Move Zeroes (keep order)**

```java
int slow = 0;
for (int fast = 0; fast < nums.length; fast++) {
    if (nums[fast] != 0) {
        int tmp = nums[slow]; nums[slow] = nums[fast]; nums[fast] = tmp;
        slow++;
    }
}
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 26 | Remove Duplicates from Sorted Array | Easy | https://leetcode.com/problems/remove-duplicates-from-sorted-array/ |
| 27 | Remove Element | Easy | https://leetcode.com/problems/remove-element/ |
| 283 | Move Zeroes | Easy | https://leetcode.com/problems/move-zeroes/ |
| 80 | Remove Duplicates from Sorted Array II | Medium | https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ |
| 75 | Sort Colors (Dutch flag) | Medium | https://leetcode.com/problems/sort-colors/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Move Zeroes | Meta (very frequent), Amazon, Bloomberg |
| Sort Colors | Amazon, Microsoft, Meta, Adobe |
| Remove Duplicates from Sorted Array | Amazon, Microsoft, Google |

**FAANG focus:** Move Zeroes and Sort Colors (three-pointer Dutch National Flag) are
common early-round in-place questions.
