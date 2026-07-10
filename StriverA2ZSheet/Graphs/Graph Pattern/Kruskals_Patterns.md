# Kruskal Pattern Recognition

## Core Idea

Sort edges and keep adding cheapest valid edge.

Uses DSU.

---

## Recognition Questions

1. Need MST?
2. Can I sort edges?
3. Need cycle detection?
4. Need minimum cost connection?

If YES → Kruskal

---

## Green Flags

- Edge List Given
- Minimum Spanning Tree
- Minimum Connection Cost

---

## Mental Trigger

Sort Edges
+
DSU

→ Kruskal

---

## Template

```java
Arrays.sort(edges);

for(edge : edges) {

    if(find(u)!=find(v)) {

        union(u,v);

        mstWeight+=wt;
    }
}
```

---

## Typical Problems

- Kruskal MST
- Minimum Cost To Connect Points
