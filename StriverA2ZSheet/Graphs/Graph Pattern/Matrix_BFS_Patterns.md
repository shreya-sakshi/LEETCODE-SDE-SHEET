# Matrix BFS Pattern Recognition Notes

## Core Idea

Use BFS whenever a grid asks for minimum distance, shortest path, or spreading process.

---

## Recognition Questions

1. Need shortest path?
2. Need minimum moves?
3. Need nearest cell?
4. Process spreads level by level?

If YES → Matrix BFS

---

## Green Flags

- Minimum Distance
- Shortest Path
- Nearest
- Time to Spread
- Rotten
- Infection

Examples:

- Rotten Oranges
- Walls and Gates
- 01 Matrix

---

## Red Flags

- Explore entire region

This usually means DFS.

---

## Mental Trigger

Grid + Minimum Distance

→ BFS

---

## BFS Template

```java
Queue<Pair> q = new LinkedList<>();

while(!q.isEmpty()) {

    Pair curr = q.poll();

    for(each direction) {
        q.offer(nextCell);
    }
}
```

---


## Typical Problems
994.  Rotten Oranges
542.  01 Matrix
1091.  Shortest Path in Binary Matrix

