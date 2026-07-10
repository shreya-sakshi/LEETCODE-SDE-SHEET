# Rotated Sorted Array Pattern

## Core Idea

A rotated sorted array still has one sorted half at every step. Decide which half is
sorted, check if the target lies in it, and discard the other half.

---

## Recognition Questions

1. Array was sorted then rotated at an unknown pivot?
2. Need to search / find the minimum in it in O(log n)?

If YES -> rotated binary search.

## Green Flags

- "rotated sorted array"
- "find minimum in rotated array"

---

## Templates

**Search in Rotated Sorted Array**

```java
int lo = 0, hi = nums.length - 1;
while (lo <= hi) {
    int mid = (lo + hi) / 2;
    if (nums[mid] == target) return mid;
    if (nums[lo] <= nums[mid]) {                 // left half sorted
        if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
        else lo = mid + 1;
    } else {                                     // right half sorted
        if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
        else hi = mid - 1;
    }
}
return -1;
```

**Find Minimum in Rotated Sorted Array**

```java
int lo = 0, hi = nums.length - 1;
while (lo < hi) {
    int mid = (lo + hi) / 2;
    if (nums[mid] > nums[hi]) lo = mid + 1;      // min is to the right
    else hi = mid;
}
return nums[lo];
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 33 | Search in Rotated Sorted Array | Medium | https://leetcode.com/problems/search-in-rotated-sorted-array/ |
| 153 | Find Minimum in Rotated Sorted Array | Medium | https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ |
| 81 | Search in Rotated Sorted Array II | Medium | https://leetcode.com/problems/search-in-rotated-sorted-array-ii/ |
| 154 | Find Minimum in Rotated Sorted Array II | Hard | https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Search in Rotated Sorted Array | Amazon, Meta, Google, Microsoft, LinkedIn |
| Find Minimum in Rotated Sorted Array | Amazon, Meta, Microsoft |

**FAANG focus:** Search in Rotated Sorted Array is one of the most-asked binary search
mediums — practice the "which half is sorted" branch until automatic.
