class ShortestPathInUndirectedGraph {

    public int[] shortestPath(int[][] edges, int N, int M) {

        // Adjacency List representation of graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create N empty lists (one for each node)
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edge list into adjacency list
        for(int i = 0; i < M; i++) {

            // Edge: u -> v
            adj.get(edges[i][0]).add(edges[i][1]);

            // Edge: v -> u (because graph is undirected)
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // Distance array to store shortest distance
        int dist[] = new int[N];

        // Initialize all distances as "infinity"
        // 1e9 means 1000000000 (very large number)
        for(int i = 0; i < N; i++) {
            dist[i] = (int)1e9;
        }

        // Source node is given as 0
        int src = 0;

        // Distance of source to itself is 0
        dist[src] = 0;

        // Queue used for BFS traversal
        Queue<Integer> q = new LinkedList<>();

        // Start BFS from source node
        q.add(src);

        // Run BFS until queue becomes empty
        while(!q.isEmpty()) {

            // Get front node
            int node = q.peek();

            // Remove front node from queue
            q.remove();

            // Traverse all neighbours of current node
            for(int it : adj.get(node)) {

                // Check if a shorter path is found
                if(dist[node] + 1 < dist[it]) {

                    // Update shortest distance
                    dist[it] = dist[node] + 1;

                    // Add neighbour to queue for further traversal
                    q.add(it);
                }
            }
        }

        // Convert unreached nodes from INF to -1
        for(int i = 0; i < N; i++) {

            // If still infinity, node was never visited
            if(dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }

        // Return shortest distance array
        return dist;
    }
}
