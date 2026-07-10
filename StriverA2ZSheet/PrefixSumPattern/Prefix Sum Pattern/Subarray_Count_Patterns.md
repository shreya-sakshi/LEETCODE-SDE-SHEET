# Prefix Sum + HashMap (Subarray Count) Pattern

## Core Idea

Running prefix sum + a hashmap of seen prefix sums. If `prefix - k` was seen before,
a subarray summing to `k` ends here. Turns O(n^2) into O(n).

---

## Visual

```
nums   : [ 1 ,  2 ,  3 ]     k = 3
prefix :  1    3    6
seen   : {0:1}
 i=0 p=1  need 1-3=-2  no ; seen={0:1, 1:1}
 i=1 p=3  need 3-3= 0  YES(+1); seen={0:1,1:1,3:1}
 i=2 p=6  need 6-3= 3  YES(+1)
 count = 2   ->  [1,2] and [3]
```

---

## Recognition Questions

1. Count/exist subarrays with sum = k?
2. Sum divisible by k, or equal number of 0/1?
3. Longest subarray with a given sum?

If YES -> Prefix Sum + HashMap.

---

## Template (Subarray Sum Equals K)

```java
Map<Integer,Integer> seen = new HashMap<>();
seen.put(0, 1);                        // empty prefix
int sum = 0, count = 0;
for (int x : nums) {
    sum += x;
    count += seen.getOrDefault(sum - k, 0);
    seen.merge(sum, 1, Integer::sum);
}
return count;
```

> For "divisible by k": key on `((sum % k) + k) % k`.
> For "equal 0s and 1s": treat 0 as -1, find longest subarray with sum 0.

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 560 | Subarray Sum Equals K | Medium | https://leetcode.com/problems/subarray-sum-equals-k/ |
| 974 | Subarray Sums Divisible by K | Medium | https://leetcode.com/problems/subarray-sums-divisible-by-k/ |
| 523 | Continuous Subarray Sum | Medium | https://leetcode.com/problems/continuous-subarray-sum/ |
| 525 | Contiguous Array | Medium | https://leetcode.com/problems/contiguous-array/ |
| 930 | Binary Subarrays With Sum | Medium | https://leetcode.com/problems/binary-subarrays-with-sum/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Subarray Sum Equals K | Amazon, Meta, Google, Microsoft |
| Contiguous Array | Amazon, Meta, Google |
| Continuous Subarray Sum | Amazon, Microsoft |

**FAANG focus:** Subarray Sum Equals K is the flagship prefix-sum + hashmap question and
extremely common across FAANG.
