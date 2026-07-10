# DSA ONE-PAGE CHEAT SHEET

Print at ~90% scale, landscape. Everything you need to pick a pattern in seconds.

---

## 1. KEYWORD -> PATTERN (the 20-second scan)

| Keyword you see | Reach for |
|-----------------|-----------|
| subarray sum / range sum | **Prefix Sum** (+ HashMap if "= k") |
| longest / shortest substring, "at most K" | **Sliding Window** |
| sorted + pair, palindrome, in-place | **Two Pointers** |
| cycle / middle / nth-from-end (list) | **Fast & Slow** |
| reverse list / k-group | **In-place Reversal** |
| next greater/smaller, histogram, span | **Monotonic Stack** |
| kth / top-k / k closest / median | **Heap** |
| merge intervals / meeting rooms | **Intervals** |
| search sorted / rotated / minimize max | **Binary Search** |
| level order / right-side view | **Tree BFS** |
| height / diameter / path sum | **Tree DFS** |
| BST + kth / range / closest | **BST inorder** |
| prerequisite / build order / A before B | **Topological Sort** |
| connect all cheaply / min wiring | **MST (Prim/Kruskal)** |
| cheapest / fastest weighted path | **Dijkstra** (neg -> Bellman-Ford) |
| same group / friend circle / merge | **Union-Find** |
| all subsets / permutations / combos | **Backtracking** |
| number of ways / min-max cost / longest | **DP** |
| anagram / frequency / group | **Hashing** |
| unique / missing number | **XOR** |

---

## 2. COMPLEXITY LADDER

```
O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n!)
hash    binary    scan   sort/heap    nested    subset   perms
```

Constraint hint (n): 
- n <= 12 -> O(n!)  |  n <= 20 -> O(2^n)  |  n <= 500 -> O(n^3)
- n <= 5000 -> O(n^2)  |  n <= 1e6 -> O(n log n) / O(n)  |  n > 1e8 -> O(log n)/O(1)

---

## 3. CODE SKELETONS (fill from memory)

**Sliding window (variable)**
```java
int l=0; for(int r=0;r<n;r++){ add(r); while(bad){ remove(l++);} best=upd(); }
```

**Binary search on answer**
```java
while(lo<hi){ int m=lo+(hi-lo)/2; if(feasible(m)) hi=m; else lo=m+1; } return lo;
```

**BFS**
```java
q.add(src); while(!q.isEmpty()){ int s=q.size(); for(;s>0;s--){ n=q.poll(); for(nb) q.add(nb);} }
```

**DFS (grid)**
```java
void dfs(r,c){ if(oob||seen||bad)return; seen=true; for(dir) dfs(nr,nc); }
```

**Backtracking**
```java
void bt(st){ if(done){res.add(copy);return;} for(ch){ apply; bt(st); undo; } }
```

**Dijkstra**
```java
pq.add(new int[]{0,src}); while(!pq.isEmpty()){ [d,u]=pq.poll(); for(v,w) if(d+w<dist[v]){dist[v]=d+w; pq.add({dist[v],v});} }
```

**Union-Find**
```java
int find(x){ return p[x]==x?x:(p[x]=find(p[x])); }
void union(a,b){ p[find(a)]=find(b); }
```

**DP recipe**: state -> transition -> base -> order -> answer (then reduce space).

---

## 4. TWO-POINTER vs SLIDING WINDOW vs BINARY SEARCH

| Signal | Pick |
|--------|------|
| sorted + pair/target from ends | Two Pointers |
| contiguous window + constraint | Sliding Window |
| sorted + O(log n) or "min feasible" | Binary Search |

## DFS vs BFS

| Signal | Pick |
|--------|------|
| explore whole region / all paths / backtrack | DFS |
| shortest path / min steps / level-by-level | BFS |

## Dijkstra vs MST vs Bellman-Ford

| Signal | Pick |
|--------|------|
| shortest path from a source, weights >= 0 | Dijkstra |
| connect ALL nodes at min total cost | MST |
| negative edges / detect negative cycle | Bellman-Ford |

---

## 5. MUST-SOLVE 30 (breadth across patterns)

Two Sum(1) - Valid Anagram(242) - Group Anagrams(49) - Top K Frequent(347) -
Product Except Self(238) - Valid Palindrome(125) - 3Sum(15) - Container Water(11) -
Best Time Buy/Sell(121) - Longest Substring No Repeat(3) - Min Window Substring(76) -
Valid Parentheses(20) - Daily Temperatures(739) - Binary Search(704) -
Search Rotated(33) - Koko Bananas(875) - Reverse List(206) - Merge Two Lists(21) -
Linked List Cycle(141) - LRU Cache(146) - Invert Tree(226) - Level Order(102) -
Validate BST(98) - LCA(236) - Kth Smallest BST(230) - Number of Islands(200) -
Course Schedule(207) - Clone Graph(133) - Coin Change(322) - LIS(300).

---

## 6. INTERVIEW FLOW (say this out loud)

1. Restate + clarify constraints & edge cases.
2. Brute force + its complexity.
3. Identify the **pattern** (use section 1).
4. State target complexity, then code.
5. Dry-run a small example.
6. Test edge cases: empty, single, duplicates, overflow, cycle.

---

*Full details: see `00_ULTIMATE_VISUAL_INDEX.md` and each topic's `00_*_Master.md`.*
