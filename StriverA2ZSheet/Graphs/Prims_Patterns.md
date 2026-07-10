# Prim's Algorithm Pattern Recognition

## Core Idea

Build MST by expanding from one node.

---

## Recognition Questions

1. Need to connect all nodes?
2. Need minimum total cost?
3. Need exactly N-1 edges?
4. Graph is weighted?

If YES → MST

Then think Prim.

---

## Green Flags

- Connect all cities
- Connect all computers
- Minimum wiring cost

---

## Mental Trigger

Grow Tree Node By Node

→ Prim

---

## Difference from Dijkstra

Dijkstra:

```text
Shortest path from source
```

Prim:

```text
Minimum spanning tree
```

---

## Template

```java
PriorityQueue<Pair> pq =
new PriorityQueue<>((a,b)->a.weight-b.weight);

pq.offer(new Pair(0,0));

while(!pq.isEmpty()) {

}
```

---

## Typical Problems

- Minimum Cost to Connect Cities
- Minimum Cost to Connect Points
