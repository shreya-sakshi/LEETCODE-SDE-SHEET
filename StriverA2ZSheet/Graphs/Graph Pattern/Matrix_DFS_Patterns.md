# Matrix DFS Pattern Recognition Notes

## Core Idea

Use DFS when you need to completely explore a connected region in a grid.

---

## Recognition Questions

Ask yourself:

1. Do I need to visit all connected cells?
2. Am I exploring a region/component?
3. Do I need to mark visited cells?
4. Am I counting islands/groups?

If YES → Matrix DFS

---

## Green Flags

- Island
- Region
- Connected Cells
- Flood Fill
- Area
- Cluster
- Component

Examples:

- Number of Islands
- Max Area of Island
- Flood Fill
- Surrounded Regions

---

## Red Flags

- Minimum distance
- Shortest path
- Minimum moves

These indicate BFS.

---

## Mental Trigger

Grid + Explore Entire Component

→ DFS

---

## DFS Template

```java
void dfs(int r, int c) {

    if(outOfBounds || visited || invalid)
        return;

    visited[r][c] = true;

    for(each direction)
        dfs(newRow, newCol);
}
```

---

## Typical Problems

200. Number of Islands
695. Max Area of Island
733. Flood Fill
130. Surrounded Regions
