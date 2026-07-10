# Grouping & Bucketing Pattern

## Core Idea

Group items under a computed key (`HashMap<key, List>`), or bucket by frequency/value
into an array indexed by count. Bucketing gives O(n) where a heap would give O(n log k).

---

## Recognition Questions

1. Do items need to be grouped by a shared property (anagram, category)?
2. Do I need the K most/least frequent elements?
3. Can the "key" be a sorted string or a char-count signature?

If YES -> Grouping / Bucketing.

## Green Flags

- "group the anagrams", "categorize"
- "top k frequent", "k most common"

---

## Templates

**Group Anagrams (key = sorted string or count signature)**

```java
Map<String, List<String>> map = new HashMap<>();
for (String s : strs) {
    char[] c = s.toCharArray();
    Arrays.sort(c);
    String key = new String(c);
    map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
}
return new ArrayList<>(map.values());
```

**Top K Frequent (bucket sort by frequency, O(n))**

```java
Map<Integer, Integer> freq = new HashMap<>();
for (int n : nums) freq.merge(n, 1, Integer::sum);

List<Integer>[] bucket = new List[nums.length + 1];
for (var e : freq.entrySet()) {
    int f = e.getValue();
    if (bucket[f] == null) bucket[f] = new ArrayList<>();
    bucket[f].add(e.getKey());
}
List<Integer> res = new ArrayList<>();
for (int f = bucket.length - 1; f >= 0 && res.size() < k; f--)
    if (bucket[f] != null) res.addAll(bucket[f]);
return res.subList(0, k).stream().mapToInt(i -> i).toArray();
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 49 | Group Anagrams | Medium | https://leetcode.com/problems/group-anagrams/ |
| 347 | Top K Frequent Elements | Medium | https://leetcode.com/problems/top-k-frequent-elements/ |
| 692 | Top K Frequent Words | Medium | https://leetcode.com/problems/top-k-frequent-words/ |
| 451 | Sort Characters By Frequency | Medium | https://leetcode.com/problems/sort-characters-by-frequency/ |
| 249 | Group Shifted Strings | Medium | https://leetcode.com/problems/group-shifted-strings/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Group Anagrams | Amazon, Meta, Uber, Microsoft, Bloomberg |
| Top K Frequent Elements | Amazon, Meta, Google, Microsoft, Yelp |
| Top K Frequent Words | Amazon, Bloomberg, Uber |
| Sort Characters By Frequency | Amazon, Google |

**FAANG focus:** Top K Frequent Elements is very common — be ready to give both the
heap O(n log k) and the bucket-sort O(n) solutions.
