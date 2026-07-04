import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DijkstrasAlgoPathReconstructionPQ {

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        // ==========================
        // CREATE ADJACENCY LIST
        // ==========================

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Create empty list for every node
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add all edges into adjacency list
        for (int i = 0; i < m; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            // Undirected graph
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        /*
            Example:

            1 -> (2,2), (3,4)
            2 -> (1,2), (3,1), (4,7)
            3 -> (1,4), (2,1), (5,3)
            4 -> (2,7), (5,1)
            5 -> (3,3), (4,1)
        */

        // ==========================
        // PRIORITY QUEUE
        // ==========================

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> x.first - y.first);

        /*
           first  = distance
           second = node

           PQ will always give the Pair
           having minimum distance first.
        */

        // ==========================
        // DISTANCE ARRAY
        // ==========================

        int dist[] = new int[n + 1];

        // ==========================
        // PARENT ARRAY
        // ==========================

        int parent[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dist[i] = (int) 1e9; // infinity

            // every node is initially its own parent
            parent[i] = i;
        }

        // Source node = 1
        dist[1] = 0;

        // Push source into PQ
        pq.add(new Pair(0, 1));

        /*
             PQ = [(0,1)]

             distance = 0
             node = 1
        */

        // ==========================
        // DIJKSTRA ALGORITHM
        // ==========================

        while (!pq.isEmpty()) {

            Pair current = pq.peek();

            int dis = current.first;
            int node = current.second;

            pq.remove();

            // Visit every neighbour

            for (int i = 0; i < adj.get(node).size(); i++) {

                int adjNode =
                        adj.get(node).get(i).first;

                int edgeWeight =
                        adj.get(node).get(i).second;

                /*
                   Relaxation

                   Is current path shorter?
                */

                if (dis + edgeWeight < dist[adjNode]) {

                    // Update shortest distance
                    dist[adjNode] = dis + edgeWeight;

                    // Insert updated distance
                    pq.add(
                            new Pair(
                                    dist[adjNode],
                                    adjNode
                            )
                    );

                    // Store parent for path reconstruction
                    parent[adjNode] = node;
                }
            }
        }

        // ==========================
        // PATH RECONSTRUCTION
        // ==========================

        List<Integer> path = new ArrayList<>();

        // Destination node = n

        if (dist[n] == (int) 1e9) {

            path.add(-1);

            return path;
        }

        int node = n;

        while (parent[node] != node) {

            path.add(node);

            node = parent[node];
        }

        // Add source node
        path.add(1);

        // Reverse path
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {

        int n = 5;
        int m = 6;

        int edges[][] = {
                {1, 2, 2},
                {1, 3, 4},
                {2, 3, 1},
                {2, 4, 7},
                {3, 5, 3},
                {4, 5, 1}
        };

        List<Integer> ans = shortestPath(n, m, edges);

        System.out.println(ans);
    }
}
