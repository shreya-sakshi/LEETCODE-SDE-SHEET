# Topological Sort Pattern Recognition

## Core Idea

Used when ordering depends on prerequisites.

---

## Recognition Questions

1. Must A happen before B?
2. Is there dependency?
3. Need valid order?
4. Directed graph?

If YES → Topological Sort

---

## Green Flags

- Prerequisite
- Dependency
- Before
- After
- Build Order
- Course Schedule

---

## Red Flags

Undirected Graph

Topo Sort only works on DAGs.

---

## Mental Trigger

A Before B

→ Topological Sort

---

## Kahn's Algorithm Template

```java
Queue<Integer> q;

while(!q.isEmpty()) {

    int node = q.poll();

    for(neighbor)
        indegree[neighbor]--;
}
```

---

## Typical Problems

- Course Schedule
- Course Schedule II
- Alien Dictionary
