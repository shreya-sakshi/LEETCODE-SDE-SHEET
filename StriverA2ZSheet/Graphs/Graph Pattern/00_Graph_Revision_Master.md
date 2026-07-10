# Graphs - Master Revision Note

One-stop revision sheet. Start at the **Decision Table**, identify the pattern,
then jump to that section for recognition triggers + complete working code.

> Code here matches the implementations in the `Graphs/` folder of this repo.

---

## How To Use This Note

1. Read the problem, list the **keywords**.
2. Match keywords in the **Decision Table** below.
3. Confirm with the pattern's **Recognition Questions**.
4. Recall the **template code**, then adapt.

---

## Master Decision Table

| If the problem asks for...                                   | Pattern                     | Go To |
|--------------------------------------------------------------|-----------------------------|-------|
| Neighbours of a node / input is edge list                    | Adjacency List (setup)      | [1](#1-adjacency-list-setup) |
| Explore entire region / count islands / area                 | Matrix DFS                  | [2](#2-matrix-dfs) |
| Shortest path / min moves / nearest / spread level by level  | Matrix BFS                  | [3](#3-matrix-bfs) |
| Shortest path, **unit weights**, from a source               | BFS on graph                | [4](#4-bfs-shortest-path-unit-weight) |
| Shortest path, **positive weights**                          | Dijkstra                    | [5](#5-dijkstra-positive-weights) |
| Shortest path, **negative weights** / detect negative cycle  | Bellman-Ford                | [6](#6-bellman-ford-negative-weights) |
| Shortest path between **every pair** of nodes                | Floyd-Warshall              | [7](#7-floyd-warshall-all-pairs) |
| Shortest path in a **DAG** (directed acyclic, weighted)      | Topo Sort + Relax           | [8](#8-shortest-path-in-a-dag) |
| Ordering with prerequisites / "A before B" / detect cycle DG | Topological Sort (Kahn)     | [9](#9-topological-sort-kahn) |
| "Same group?" / merge groups / dynamic connectivity          | DSU (Union-Find)            | [10](#10-disjoint-set-union-find) |
| Connect all nodes at **minimum total cost** (MST)            | Prim's / Kruskal's          | [11](#11-mst--prims), [12](#12-mst--kruskals) |

**Quick disambiguators**

- "Shortest path from source" -> Dijkstra/BFS/Bellman-Ford (NOT MST).
- "Connect everything cheaply" / "minimum wiring" -> MST (Prim/Kruskal).
- "Explore whole region" -> DFS. "Minimum distance in grid" -> BFS.
- "A must come before B" -> Topological Sort (needs a DAG).
- "Are X and Y connected?" repeatedly -> DSU.

---

## 1. Adjacency List (Setup)

**Core idea:** Whenever traversal is needed, build an adjacency list first.

**Recognition Questions**

- Need neighbours of a node?
- Need DFS/BFS on a graph?
- Input given as `edges`?

**Green flags:** input like `[[0,1],[1,2]]`, "roads", "flights", "friendships".

**Template**

```java
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

for (int[] edge : edges) {
    graph.get(edge[0]).add(edge[1]);
    graph.get(edge[1]).add(edge[0]); // omit this line for a DIRECTED graph
}
```

**Weighted variant** (store `Pair(node, weight)`):

```java
List<List<int[]>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
for (int[] e : edges) graph.get(e[0]).add(new int[]{e[1], e[2]});
```

**Typical problems:** Number of Provinces, Clone Graph, Connected Components.

---

## 2. Matrix DFS

**Core idea:** Fully explore a connected region in a grid.

**Recognition Questions**

- Visit all connected cells?
- Exploring a region/component?
- Counting islands/groups? Computing area?

**Green flags:** island, region, connected cells, flood fill, area, cluster, component.
**Red flags:** minimum distance / shortest path / min moves -> use BFS instead.

**Template**

```java
void dfs(int r, int c, int[][] grid, boolean[][] vis) {
    int n = grid.length, m = grid[0].length;
    if (r < 0 || c < 0 || r >= n || c >= m) return;
    if (vis[r][c] || grid[r][c] == 0) return;

    vis[r][c] = true;

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    for (int i = 0; i < 4; i++) dfs(r + dr[i], c + dc[i], grid, vis);
}
```

**Typical problems:** 200 Number of Islands, 695 Max Area of Island, 733 Flood Fill, 130 Surrounded Regions.

---

## 3. Matrix BFS

**Core idea:** Grid asks for minimum distance / shortest path / a spreading process.

**Recognition Questions**

- Need shortest path / minimum moves?
- Need nearest cell?
- Process spreads level by level?

**Green flags:** minimum distance, shortest path, nearest, time to spread, rotten, infection.
**Red flags:** "explore entire region" -> DFS.

**Complete code (Rotten Oranges - multi-source BFS)**

```java
class Pair { int first, second, tm;
    Pair(int f, int s, int t){ first=f; second=s; tm=t; } }

public int orangesRotting(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    Queue<Pair> q = new LinkedList<>();
    int[][] vis = new int[n][m];
    int cntFresh = 0;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 2) { q.add(new Pair(i, j, 0)); vis[i][j] = 2; }
            if (grid[i][j] == 1) cntFresh++;
        }

    int tm = 0, cnt = 0;
    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    while (!q.isEmpty()) {
        int r = q.peek().first, c = q.peek().second, t = q.peek().tm;
        tm = Math.max(tm, t); q.remove();
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                q.add(new Pair(nr, nc, t + 1));
                vis[nr][nc] = 2; cnt++;
            }
        }
    }
    return (cnt != cntFresh) ? -1 : tm;
}
```

**Typical problems:** 994 Rotten Oranges, 542 01 Matrix, 1091 Shortest Path in Binary Matrix.

---

## 4. BFS Shortest Path (Unit Weight)

**Core idea:** Shortest path from a source when **every edge weight = 1**.
BFS visits nodes in increasing distance order, so first visit = shortest.

**Recognition Questions**

- Shortest path / min steps AND all edges equal weight (or unweighted)?

**Template**

```java
int[] dist = new int[n];
Arrays.fill(dist, (int)1e9);
dist[src] = 0;
Queue<Integer> q = new LinkedList<>();
q.add(src);

while (!q.isEmpty()) {
    int node = q.poll();
    for (int next : graph.get(node)) {
        if (dist[node] + 1 < dist[next]) {
            dist[next] = dist[node] + 1;
            q.add(next);
        }
    }
}
```

**Typical problems:** Shortest Path in Undirected Graph (unit weights), word ladder-style.

---

## 5. Dijkstra (Positive Weights)

**Core idea:** Shortest path in a weighted graph with **non-negative** weights, using a min-heap.

**Recognition Questions**

- Need minimum cost / shortest path?
- Positive weights? Multiple routes possible?

**Green flags:** cheapest, minimum cost, fastest route, least time, weighted graph.
**Red flags:** "connect all nodes cheaply" -> that's MST. Negative weights -> Bellman-Ford.

**Complete code (with path reconstruction via `parent[]`)**

```java
class Pair { int first, second;      // first = distance, second = node
    Pair(int f, int s){ first=f; second=s; } }

List<Integer> shortestPath(int n, ArrayList<ArrayList<Pair>> adj, int src) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
    int[] dist = new int[n + 1];
    int[] parent = new int[n + 1];
    for (int i = 1; i <= n; i++) { dist[i] = (int)1e9; parent[i] = i; }

    dist[src] = 0;
    pq.add(new Pair(0, src));

    while (!pq.isEmpty()) {
        int d = pq.peek().first, node = pq.peek().second; pq.remove();
        for (Pair it : adj.get(node)) {
            int adjNode = it.first, w = it.second;   // (node, weight)
            if (d + w < dist[adjNode]) {
                dist[adjNode] = d + w;
                pq.add(new Pair(dist[adjNode], adjNode));
                parent[adjNode] = node;              // for path reconstruction
            }
        }
    }
    // reconstruct path to node n
    List<Integer> path = new ArrayList<>();
    if (dist[n] == (int)1e9) { path.add(-1); return path; }
    int node = n;
    while (parent[node] != node) { path.add(node); node = parent[node]; }
    path.add(src);
    Collections.reverse(path);
    return path;
}
```

> Note the `Pair` convention here: `first = distance`, `second = node`.
> In Prim's below the convention is flipped. Keep this consistent per problem.

**Typical problems:** Network Delay Time, Path With Minimum Effort, Cheapest Flights (k stops - variant), Number of Ways to Arrive at Destination.

---

## 6. Bellman-Ford (Negative Weights)

**Core idea:** Shortest path from a source that also works with **negative edges**,
and can **detect a negative-weight cycle**. Relax all edges `V-1` times.

**Recognition Questions**

- Negative edge weights present?
- Need to detect a negative cycle?

**Complete code**

```java
static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int S) {
    int[] dist = new int[V];
    Arrays.fill(dist, (int)1e8);
    dist[S] = 0;

    // Relax all edges V-1 times
    for (int i = 0; i < V - 1; i++) {
        for (ArrayList<Integer> e : edges) {
            int u = e.get(0), v = e.get(1), wt = e.get(2);
            if (dist[u] != (int)1e8 && dist[u] + wt < dist[v])
                dist[v] = dist[u] + wt;
        }
    }
    // One more pass: if it still relaxes -> negative cycle
    for (ArrayList<Integer> e : edges) {
        int u = e.get(0), v = e.get(1), wt = e.get(2);
        if (dist[u] != (int)1e8 && dist[u] + wt < dist[v])
            return new int[]{ -1 };
    }
    return dist;
}
```

**Complexity:** O(V * E). Use only when Dijkstra can't (negative weights).

---

## 7. Floyd-Warshall (All Pairs)

**Core idea:** Shortest distance between **every pair** of vertices. Try every node `k`
as an intermediate. Here `-1` means "no edge".

**Recognition Questions**

- Need distance between all pairs?
- Small number of vertices (N^3 acceptable)?

**Complete code**

```java
void shortestDistance(int[][] matrix) {
    int n = matrix.length;
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][k] == -1 || matrix[k][j] == -1) continue;
                if (matrix[i][j] == -1)
                    matrix[i][j] = matrix[i][k] + matrix[k][j];
                else
                    matrix[i][j] = Math.min(matrix[i][j],
                                            matrix[i][k] + matrix[k][j]);
            }
}
```

**Complexity:** O(N^3). Negative cycle if any `matrix[i][i] < 0` after running.

---

## 8. Shortest Path in a DAG

**Core idea:** For a **weighted DAG**, do a Topological Sort, then relax edges in topo order.
Faster than Dijkstra: O(V + E).

**Recognition Questions**

- Directed AND acyclic AND weighted?
- Need shortest path from a source?

**Complete code (Topo via DFS + relaxation)**

```java
class Pair { int first, second;    // first = node, second = weight
    Pair(int f, int s){ first=f; second=s; } }

void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
    vis[node] = 1;
    for (Pair it : adj.get(node))
        if (vis[it.first] == 0) topoSort(it.first, adj, vis, st);
    st.push(node);
}

int[] shortestPath(int N, ArrayList<ArrayList<Pair>> adj) {
    int[] vis = new int[N];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < N; i++) if (vis[i] == 0) topoSort(i, adj, vis, st);

    int[] dist = new int[N];
    Arrays.fill(dist, (int)1e9);
    dist[0] = 0;                       // source = 0

    while (!st.isEmpty()) {
        int node = st.pop();
        if (dist[node] == (int)1e9) continue;
        for (Pair it : adj.get(node)) {
            int v = it.first, wt = it.second;
            if (dist[node] + wt < dist[v]) dist[v] = dist[node] + wt;
        }
    }
    for (int i = 0; i < N; i++) if (dist[i] == (int)1e9) dist[i] = -1;
    return dist;
}
```

---

## 9. Topological Sort (Kahn)

**Core idea:** Ordering when there are **prerequisites / dependencies**. Works only on a **DAG**.
Kahn's = BFS using in-degrees. If we can't output all nodes -> a cycle exists.

**Recognition Questions**

- Must A happen before B? Is there a dependency? Need a valid order? Directed graph?

**Green flags:** prerequisite, dependency, before/after, build order, course schedule.
**Red flags:** undirected graph (topo sort needs a DAG).

**Complete code (Course Schedule II - returns order, or empty if cycle)**

```java
int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
    for (int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]

    int[] indegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++)
        for (int it : adj.get(i)) indegree[it]++;

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);

    int[] topo = new int[numCourses];
    int idx = 0;
    while (!q.isEmpty()) {
        int node = q.poll();
        topo[idx++] = node;
        for (int it : adj.get(node)) {
            if (--indegree[it] == 0) q.add(it);
        }
    }
    return (idx == numCourses) ? topo : new int[0];   // empty => cycle (impossible)
}
```

**Cycle detection use:** Course Schedule I = same code, return `idx == numCourses`.
**Typical problems:** 207 Course Schedule, 210 Course Schedule II, 269 Alien Dictionary.

---

## 10. Disjoint Set (Union-Find)

**Core idea:** Repeatedly ask "are A and B in the same group?" and "merge groups"
in near O(1) using path compression + union by rank/size.

**Recognition checklist -> think DSU:** connected components, same group,
connectivity queries, merge groups, friend circles, dynamic connectivity,
cycle detection (undirected), redundant connections, equivalence relations.

**When NOT to use:** shortest path (Dijkstra/Bellman-Ford), plain traversal (DFS/BFS),
ordering (Topo Sort).

**Complete code (path compression + union by rank)**

```java
class DSU {
    int[] parent, rank;
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {                       // path compression
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    void union(int u, int v) {              // union by rank
        int pu = find(u), pv = find(v);
        if (pu == pv) return;
        if (rank[pu] < rank[pv]) parent[pu] = pv;
        else if (rank[pv] < rank[pu]) parent[pv] = pu;
        else { parent[pv] = pu; rank[pu]++; }
    }
}
```

**Key one-liners**

```java
if (find(a) == find(b)) { /* same component / cycle if this is an edge */ }
// count components:
int comps = 0; for (int i = 0; i < n; i++) if (find(i) == i) comps++;
```

**Must-know problems:** 547 Provinces, 1319 Make Network Connected, 684 Redundant
Connection, 721 Accounts Merge, 947 Most Stones Removed, 1202 Smallest String With
Swaps, 990 Satisfiability of Equality Equations, 827 Making A Large Island, 305 Islands II.

---

## 11. MST - Prim's

**Core idea:** Build a Minimum Spanning Tree by **growing from one node**, always taking
the cheapest edge to a new node (via a min-heap).

**Recognition Questions (MST)**

- Connect ALL nodes? Minimum total cost? Exactly N-1 edges? Weighted graph?

**Green flags:** connect all cities/computers, minimum wiring cost.
**Prim vs Dijkstra:** Dijkstra = shortest path from a source; Prim = min total tree weight.

**Complete code (returns MST weight)**

```java
class Pair { int node, distance;      // note: distance = edge weight
    Pair(int n, int d){ node=n; distance=d; } }

int spanningTree(int V, List<List<List<Integer>>> adj) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
    int[] vis = new int[V];
    pq.add(new Pair(0, 0));            // start node 0, weight 0
    int sum = 0;

    while (!pq.isEmpty()) {
        int node = pq.peek().node, wt = pq.peek().distance; pq.remove();
        if (vis[node] == 1) continue;  // skip if already in MST
        vis[node] = 1;
        sum += wt;
        for (List<Integer> it : adj.get(node)) {
            int adjNode = it.get(0), adjWt = it.get(1);
            if (vis[adjNode] == 0) pq.add(new Pair(adjNode, adjWt));
        }
    }
    return sum;
}
```

**Typical problems:** Minimum Cost to Connect Cities / Points.

---

## 12. MST - Kruskal's

**Core idea:** Sort all edges by weight, add the cheapest edge that **does not form a cycle**
(checked with DSU). Stops after N-1 edges.

**Recognition Questions**

- Need MST? Edge list given / easy to sort edges? Cycle detection needed?

**Complete code (uses the DSU from section 10)**

```java
int kruskalMST(int V, int[][] edges) {   // edges: {u, v, weight}
    Arrays.sort(edges, (a, b) -> a[2] - b[2]);
    DSU ds = new DSU(V);
    int mstWeight = 0;

    for (int[] e : edges) {
        int u = e[0], v = e[1], wt = e[2];
        if (ds.find(u) != ds.find(v)) {  // adding it won't create a cycle
            ds.union(u, v);
            mstWeight += wt;
        }
    }
    return mstWeight;
}
```

**Prim vs Kruskal:** both give MST. Prim grows from a node (good for dense graphs);
Kruskal sorts edges (good for sparse/edge-list input).

---

## Complexity Cheat Sheet

| Algorithm            | Time                | Notes |
|----------------------|---------------------|-------|
| DFS / BFS            | O(V + E)            | traversal |
| BFS shortest path    | O(V + E)            | unit weights only |
| Dijkstra (heap)      | O(E log V)          | non-negative weights |
| Bellman-Ford         | O(V * E)            | handles negatives, detects neg cycle |
| Floyd-Warshall       | O(V^3)              | all pairs |
| Topo Sort (Kahn/DFS) | O(V + E)            | DAG only |
| DSU op (amortised)   | ~O(alpha(N)) ~ O(1) | with compression + rank |
| Prim's (heap)        | O(E log V)          | MST |
| Kruskal's            | O(E log E)          | MST (sort + DSU) |

---

## 60-Second Self-Test (fill from memory)

1. Grid, "minimum time to rot all oranges" -> ? (multi-source **BFS**)
2. "Cheapest cost to connect all houses" -> ? (**MST**: Prim/Kruskal)
3. "Shortest path, some edges negative" -> ? (**Bellman-Ford**)
4. "Order to finish courses with prerequisites" -> ? (**Topo Sort**)
5. "Are user A and user B in the same network?" repeated queries -> ? (**DSU**)
6. "Shortest path from A to B, positive weights" -> ? (**Dijkstra**)
7. "Distance between every pair of cities" -> ? (**Floyd-Warshall**)
8. "Number of islands / max area of island" -> ? (**Matrix DFS**)
