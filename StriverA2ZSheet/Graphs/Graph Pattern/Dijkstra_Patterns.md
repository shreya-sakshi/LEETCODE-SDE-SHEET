# Dijkstra Pattern Recognition

## Core Idea

Shortest Path in a Weighted Graph.

---

## Recognition Questions

1. Need minimum cost?
2. Need shortest path?
3. Graph has positive weights?
4. Multiple routes possible?

If YES → Dijkstra

---

## Green Flags

- Cheapest
- Minimum Cost
- Fastest Route
- Least Time
- Weighted Graph

---

## Red Flags

- Connect all nodes cheaply

That's MST (Prim/Kruskal).

---

## Mental Trigger

Weighted Graph
+
Shortest Path

→ Dijkstra

---

## Template

```java
PriorityQueue<Pair> pq =
new PriorityQueue<>((a,b) -> a.dist-b.dist);

pq.offer(new Pair(src,0));

while(!pq.isEmpty()) {

    Pair curr = pq.poll();

    for(neighbor)
        relaxEdge();
}
```

---

## Typical Problems

- Network Delay Time
- Path With Minimum Effort
- Dijkstra Shortest Path
