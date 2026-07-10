# Adjacency List Pattern Recognition

## Core Idea

Whenever graph traversal is required, build an adjacency list first.

---

## Recognition Questions

1. Need neighbors of a node?
2. Need DFS/BFS on graph?
3. Input given as edges?

If YES → Adjacency List

---

## Green Flags

Input:

```text
[[0,1],[1,2],[2,3]]
```

or

```text
Roads
Flights
Computers
Friendships
```

---

## Mental Trigger

Graph Traversal

→ Build Adjacency List

---

## Template

```java
List<List<Integer>> graph = new ArrayList<>();

for(int i=0;i<n;i++)
    graph.add(new ArrayList<>());

for(int[] edge : edges) {
    graph.get(edge[0]).add(edge[1]);
    graph.get(edge[1]).add(edge[0]);
}
```

---

## Typical Problems

- Number of Provinces
- Clone Graph
- Connected Components
