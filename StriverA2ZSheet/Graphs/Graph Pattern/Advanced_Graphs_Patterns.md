# Advanced Graphs Pattern

Covers the NeetCode roadmap "Advanced Graphs" topic. Builds on the algorithms already
documented in `00_Graph_Revision_Master.md` (Dijkstra, Bellman-Ford, MST, Topo Sort).

> Company tags are *commonly reported* associations, not official live data.

---

## Sub-patterns & when to use

| Sub-pattern | Trigger | Algorithm |
|-------------|---------|-----------|
| Cheapest flights with <= K stops | shortest path with a hop limit | Bellman-Ford (K+1 relaxations) / modified Dijkstra |
| Min cost to connect all points | connect everything cheaply | MST (Prim / Kruskal) |
| Network delay time | time for signal to reach all | Dijkstra |
| Swim in rising water / path of min max | minimize the maximum edge on a path | Dijkstra-like on max, or DSU + sort |
| Reconstruct itinerary | use every edge exactly once | Eulerian path (Hierholzer) |
| Alien dictionary | derive order from constraints | Topological sort |

---

## Key Templates (beyond the master file)

**Cheapest Flights Within K Stops (Bellman-Ford, K+1 rounds)**

```java
int[] dist = new int[n];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;
for (int i = 0; i <= k; i++) {                 // at most k stops => k+1 edges
    int[] tmp = dist.clone();
    for (int[] f : flights) {                  // f = {u, v, price}
        if (dist[f[0]] == Integer.MAX_VALUE) continue;
        tmp[f[1]] = Math.min(tmp[f[1]], dist[f[0]] + f[2]);
    }
    dist = tmp;
}
return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
```

**Reconstruct Itinerary (Hierholzer, lexical)**

```java
Map<String, PriorityQueue<String>> g = new HashMap<>();
for (List<String> t : tickets)
    g.computeIfAbsent(t.get(0), x -> new PriorityQueue<>()).add(t.get(1));
LinkedList<String> route = new LinkedList<>();
Deque<String> st = new ArrayDeque<>(); st.push("JFK");
while (!st.isEmpty()) {
    String cur = st.peek();
    if (g.containsKey(cur) && !g.get(cur).isEmpty()) st.push(g.get(cur).poll());
    else route.addFirst(st.pop());
}
return route;
```

---

## Famous LeetCode Questions

| # | Problem | Difficulty | Link |
|---|---------|-----------|------|
| 787 | Cheapest Flights Within K Stops | Medium | https://leetcode.com/problems/cheapest-flights-within-k-stops/ |
| 1584 | Min Cost to Connect All Points | Medium | https://leetcode.com/problems/min-cost-to-connect-all-points/ |
| 743 | Network Delay Time | Medium | https://leetcode.com/problems/network-delay-time/ |
| 778 | Swim in Rising Water | Hard | https://leetcode.com/problems/swim-in-rising-water/ |
| 332 | Reconstruct Itinerary | Hard | https://leetcode.com/problems/reconstruct-itinerary/ |
| 269 | Alien Dictionary | Hard | https://leetcode.com/problems/alien-dictionary/ |
| 1631 | Path With Minimum Effort | Medium | https://leetcode.com/problems/path-with-minimum-effort/ |
| 1489 | Find Critical and Pseudo-Critical Edges in MST | Hard | https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/ |

---

## Company-Wise (commonly reported)

| Problem | Companies |
|---------|-----------|
| Cheapest Flights Within K Stops | Amazon, Google, Meta |
| Min Cost to Connect All Points | Amazon, Google |
| Network Delay Time | Amazon, Google, Meta |
| Alien Dictionary | Amazon, Meta, Google, Airbnb (very frequent) |
| Reconstruct Itinerary | Google, Amazon |
| Swim in Rising Water | Google, Amazon |

**FAANG focus:** Alien Dictionary is one of the most-asked hard graph problems (topo sort
over derived constraints); Cheapest Flights Within K Stops is a favorite for testing the
Bellman-Ford hop-limit variant.
