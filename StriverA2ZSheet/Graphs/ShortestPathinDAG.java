class Pair {

    // Destination node
    int first;

    // Weight of the edge
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    // DFS function used for Topological Sorting
    public void topoSort(int node,
                         ArrayList<ArrayList<Pair>> adj,
                         int vis[],
                         Stack<Integer> st) {

        // Mark current node as visited
        vis[node] = 1;

        // Visit all neighbours of current node
        for (int i = 0; i < adj.get(node).size(); i++) {

            // Get neighbour node
            int v = adj.get(node).get(i).first;

            // If neighbour is not visited
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }

        // Push node into stack after visiting all neighbours
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Create empty lists for each node
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // Build graph
        for (int i = 0; i < M; i++) {

            int u = edges[i][0]; // source
            int v = edges[i][1]; // destination
            int wt = edges[i][2]; // weight

            adj.get(u).add(new Pair(v, wt));
        }

        // Visited array for DFS
        int vis[] = new int[N];

        // Stack to store Topological order
        Stack<Integer> st = new Stack<>();

        // Perform Topological Sort
        for (int i = 0; i < N; i++) {

            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        // Distance array
        int dist[] = new int[N];

        // Initialize all distances as infinity
        for (int i = 0; i < N; i++) {
            dist[i] = (int)(1e9);
        }

        // Distance from source(0) to itself
        dist[0] = 0;

        // Process nodes in Topological order
        while (!st.isEmpty()) {

            int node = st.peek();
            st.pop();

            // Traverse all outgoing edges
            for (int i = 0; i < adj.get(node).size(); i++) {

                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                // Relaxation
                if (dist[node] + wt < dist[v]) {

                    dist[v] = dist[node] + wt;
                }
            }
        }

        // Replace infinity with -1
        for (int i = 0; i < N; i++) {

            if (dist[i] == (int)(1e9)) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
