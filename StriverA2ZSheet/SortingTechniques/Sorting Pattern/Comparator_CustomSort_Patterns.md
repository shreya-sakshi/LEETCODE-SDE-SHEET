# Custom Comparator & Counting Sort Pattern

## Core Idea

Most "sorting" interview problems are really about **choosing the right key/order**.
A comparator or counting sort unlocks the solution.

---

## Recognition Questions

1. Sort by a derived key (custom order, string concat, frequency)?
2. Small bounded value range (counting sort)?
3. "Arrange to form largest/smallest number"?

If YES -> comparator / counting sort.

---

## Templates

**Custom Comparator - Largest Number**

```java
String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));   // "9" before "34" -> "934"
if (arr[0].equals("0")) return "0";
return String.join("", arr);
```

**Sort by Frequency (then value)**

```java
Map<Integer,Integer> freq = new HashMap<>();
for (int n : nums) freq.merge(n, 1, Integer::sum);
Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
Arrays.sort(boxed, (a, b) ->
    freq.get(a).equals(freq.get(b)) ? a - b : freq.get(a) - freq.get(b));
```

**Counting Sort (0..k)**

```java
int[] count = new int[k + 1];
for (int x : nums) count[x]++;
int idx = 0;
for (int v = 0; v <= k; v++) while (count[v]-- > 0) nums[idx++] = v;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 179 | Largest Number | Medium | https://leetcode.com/problems/largest-number/ |
| 75 | Sort Colors | Medium | https://leetcode.com/problems/sort-colors/ |
| 451 | Sort Characters By Frequency | Medium | https://leetcode.com/problems/sort-characters-by-frequency/ |
| 1636 | Sort Array by Increasing Frequency | Easy | https://leetcode.com/problems/sort-array-by-increasing-frequency/ |
| 937 | Reorder Data in Log Files | Medium | https://leetcode.com/problems/reorder-data-in-log-files/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Largest Number | Amazon, Microsoft, Meta |
| Sort Colors | Amazon, Microsoft, Meta, Adobe |
| Reorder Data in Log Files | Amazon (very frequent) |

**FAANG focus:** Reorder Data in Log Files is a classic Amazon comparator question;
Largest Number tests the concatenation-comparator insight.
