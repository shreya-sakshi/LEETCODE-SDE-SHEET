# Opposite Ends (Converging Pointers) Pattern

## Core Idea

Place one pointer at the start and one at the end; move them toward each other
based on a comparison. Works great on **sorted** arrays and symmetric checks.

---

## Recognition Questions

1. Is the array sorted (or can be sorted)?
2. Am I looking for a pair meeting a sum/target?
3. Is it a palindrome / symmetry check?
4. "Max area / most water between two lines"?

If YES -> converging two pointers.

## Green Flags

- "sorted array", "pair sums to target"
- "palindrome", "reverse"
- "container", "most water", "trap rain water"

---

## Templates

**Two Sum II (sorted)**

```java
int l = 0, r = nums.length - 1;
while (l < r) {
    int sum = nums[l] + nums[r];
    if (sum == target) return new int[]{ l + 1, r + 1 };
    if (sum < target) l++;
    else r--;
}
return new int[]{-1, -1};
```

**Valid Palindrome (skip non-alphanumeric)**

```java
int l = 0, r = s.length() - 1;
while (l < r) {
    while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
    while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
    if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
        return false;
    l++; r--;
}
return true;
```

**Container With Most Water**

```java
int l = 0, r = height.length - 1, best = 0;
while (l < r) {
    best = Math.max(best, (r - l) * Math.min(height[l], height[r]));
    if (height[l] < height[r]) l++; else r--;  // move the smaller wall
}
return best;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 167 | Two Sum II - Input Array Is Sorted | Medium | https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ |
| 125 | Valid Palindrome | Easy | https://leetcode.com/problems/valid-palindrome/ |
| 11 | Container With Most Water | Medium | https://leetcode.com/problems/container-with-most-water/ |
| 42 | Trapping Rain Water | Hard | https://leetcode.com/problems/trapping-rain-water/ |
| 680 | Valid Palindrome II | Easy | https://leetcode.com/problems/valid-palindrome-ii/ |
| 344 | Reverse String | Easy | https://leetcode.com/problems/reverse-string/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Container With Most Water | Amazon, Meta, Google, Microsoft, Adobe |
| Trapping Rain Water | Amazon, Google, Meta, Apple, Goldman Sachs |
| Valid Palindrome | Meta (very frequent), Amazon, Microsoft |
| Two Sum II | Amazon, Apple, Google |

**FAANG focus:** Trapping Rain Water (hard) and Container With Most Water are top-tier;
Valid Palindrome is a Meta staple phone-screen question.
