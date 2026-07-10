# HashMap Lookup (Complement) Pattern

## Core Idea

Store what you've seen in a `HashMap<value, index>` and for each element look up
the "complement" you still need. Turns O(n^2) pair-finding into O(n).

---

## Recognition Questions

1. Find two elements that sum to a target?
2. Need the index/position of a matching partner?
3. "Has the value I need already appeared?"
4. Subarray with a given sum (prefix-sum + map)?

If YES -> HashMap complement lookup.

## Green Flags

- "two numbers that add up to target"
- "pair with difference k"
- "subarray sum equals k"

---

## Templates

**Two Sum (indices)**

```java
Map<Integer, Integer> seen = new HashMap<>(); // value -> index
for (int i = 0; i < nums.length; i++) {
    int need = target - nums[i];
    if (seen.containsKey(need)) return new int[]{ seen.get(need), i };
    seen.put(nums[i], i);
}
return new int[]{-1, -1};
```

**Subarray Sum Equals K (prefix sum + map)**

```java
Map<Integer, Integer> prefixCount = new HashMap<>();
prefixCount.put(0, 1);
int sum = 0, count = 0;
for (int x : nums) {
    sum += x;
    count += prefixCount.getOrDefault(sum - k, 0);
    prefixCount.merge(sum, 1, Integer::sum);
}
return count;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 1 | Two Sum | Easy | https://leetcode.com/problems/two-sum/ |
| 560 | Subarray Sum Equals K | Medium | https://leetcode.com/problems/subarray-sum-equals-k/ |
| 1 | Two Sum II (sorted, two-pointer) | Medium | https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ |
| 454 | 4Sum II | Medium | https://leetcode.com/problems/4sum-ii/ |
| 219 | Contains Duplicate II | Easy | https://leetcode.com/problems/contains-duplicate-ii/ |
| 974 | Subarray Sums Divisible by K | Medium | https://leetcode.com/problems/subarray-sums-divisible-by-k/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Two Sum | Amazon, Google, Meta, Microsoft, Apple, Adobe (near-universal) |
| Subarray Sum Equals K | Amazon, Meta, Google, Microsoft |
| 4Sum II | Amazon, Adobe |
| Contains Duplicate II | Amazon, Google, Airbnb |

**FAANG focus:** Two Sum is the classic warmup; Subarray Sum Equals K is the real
discriminator (tests prefix-sum + hashmap insight).
