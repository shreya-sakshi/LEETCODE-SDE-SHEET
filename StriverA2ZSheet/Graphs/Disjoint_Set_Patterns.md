# Disjoint Set Union (DSU / Union-Find) - Recognition Patterns

---

# What is DSU?

DSU (Disjoint Set Union) is a data structure used to:

1. Find whether two nodes belong to the same group/component.
2. Merge two groups/components efficiently.

Operations:

- `find(u)` → Find Ultimate Parent (Root)
- `union(u, v)` → Merge two components

Time Complexity:

- Nearly O(1)
- More precisely: O(α(N)) (Inverse Ackermann Function)

---

# When Should I Think of DSU?

Ask yourself:

> "Do I need to repeatedly determine whether two nodes belong to the same component and/or merge components?"

If YES → Consider DSU.

---

# Pattern 1: Same Component / Connectivity Check

Questions like:

- Are node A and node B connected?
- Do they belong to the same group?
- Can A reach B?

Example:

```text
Given friendships, determine whether two people are in the same friend circle.
```

DSU:

```java
if(find(a) == find(b))
{
    // same component
}
```

---

# Pattern 2: Count Connected Components

Questions ask:

- How many groups exist?
- How many provinces exist?
- How many connected components are present?

Examples:

- Number of Provinces (547)
- Number of Operations to Make Network Connected (1319)

DSU Idea:

```java
Count number of roots.
```

```java
for(int i=0; i<n; i++)
{
    if(find(i) == i)
        components++;
}
```

---

# Pattern 3: Dynamic Connectivity

Connections are added one by one.

Questions like:

```text
Add connection (u,v)
Check if x and y are connected
Add connection (a,b)
Check connectivity again
```

Why DSU?

Because:

```java
union(u,v)
find(x)
```

are almost O(1).

Examples:

- Number of Islands II
- Online Connectivity Queries

---

# Pattern 4: Merge Groups

Questions involving:

- Merging users
- Merging accounts
- Merging friend circles
- Merging organizations

Examples:

- Accounts Merge (721)

Example:

```text
John
john@gmail.com
john@yahoo.com

John
john@yahoo.com
john123@gmail.com
```

Same email means same account.

DSU naturally merges them.

---

# Pattern 5: Cycle Detection in Undirected Graph

Classic DSU Pattern.

Before connecting:

```java
if(find(u) == find(v))
{
    // Cycle found
}
```

Reason:

If both nodes already belong to the same component, adding another edge creates a cycle.

Examples:

- Redundant Connection (684)

---

# Pattern 6: Network Connection Problems

Keywords:

- Connect all cities
- Connect all computers
- Connect network
- Connect houses

Examples:

- Number of Operations to Make Network Connected (1319)

Idea:

```text
Count components
+
Merge components
```

DSU fits perfectly.

---

# Pattern 7: Grouping Problems

Questions ask:

- Which elements belong together?
- Form groups based on relationships
- Cluster items

Examples:

```text
People with common interests
Students belonging to same club
Emails belonging to same account
```

DSU efficiently forms groups.

---

# Pattern 8: Grid Connectivity Problems

A grid can be converted into a graph.

Example:

```text
1 1 0
0 1 1
1 0 0
```

Treat each cell as a node.

Union adjacent cells.

Examples:

- Number of Islands II
- Making A Large Island (827)

---

# Pattern 9: Extra / Redundant Connections

Questions ask:

```text
How many extra edges exist?
```

or

```text
Can we remove some edges?
```

Example:

```java
if(find(u) == find(v))
{
    extraEdges++;
}
```

Common in network and graph problems.

---

# Pattern 10: Equivalence Relations

Questions involve:

```text
a == b
b == c
```

Then automatically:

```text
a == c
```

Examples:

- Satisfiability of Equality Equations (990)
- Lexicographically Smallest Equivalent String (1061)

DSU is ideal for representing equivalence classes.

---

# Quick Identification Checklist

If the problem contains any of these:

✅ Connected Components

✅ Same Group

✅ Connectivity Queries

✅ Merge Groups

✅ Friend Circles

✅ Dynamic Connectivity

✅ Cycle Detection (Undirected Graph)

✅ Redundant Connections

✅ Network Connection Problems

✅ Equivalence Relations

→ Think **DSU (Union-Find)**.

---

# When NOT to Use DSU

## Shortest Path

Examples:

- Dijkstra
- Bellman Ford

Use:

```text
Priority Queue + Graph
```

---

## Graph Traversal

Examples:

- Visit all nodes
- Find path between nodes

Use:

```text
DFS / BFS
```

---

## Topological Ordering

Examples:

- Course Schedule
- Dependency Graph

Use:

```text
Topological Sort
```

---

# DSU Template (Java)

```java
class DSU {

    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {
        if(parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if(pu == pv)
            return;

        if(size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
```

---

# Must-Know LeetCode Problems for DSU

Easy → Medium:

1. 547 - Number of Provinces
2. 1319 - Number of Operations to Make Network Connected
3. 684 - Redundant Connection
4. 721 - Accounts Merge
5. 947 - Most Stones Removed
6. 1202 - Smallest String With Swaps
7. 1061 - Lexicographically Smallest Equivalent String
8. 990 - Satisfiability of Equality Equations
9. 827 - Making A Large Island
10. 305 - Number of Islands II

---

# Golden Rule

If you are repeatedly answering:

```text
"Are these two nodes in the same component?"
```

or

```text
"Merge these two components."
```

then DSU is usually the best choice.
