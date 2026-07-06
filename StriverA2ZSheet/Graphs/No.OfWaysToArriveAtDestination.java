import java.util.*;

class Solution {

    // For adjacency list
    class Edge {
        int node;
        long weight;

        Edge(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // For priority queue
    class State {
        int node;
        long dist;

        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new Edge(v, time));
            adj.get(v).add(new Edge(u, time));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int node = curr.node;
            long currDist = curr.dist;

            if (currDist > dist[node]) {
                continue;
            }

            for (Edge edge : adj.get(node)) {

                int adjNode = edge.node;
                long edgeWt = edge.weight;

                if (currDist + edgeWt < dist[adjNode]) {

                    dist[adjNode] = currDist + edgeWt;
                    ways[adjNode] = ways[node];

                    pq.offer(new State(adjNode, dist[adjNode]));
                }
                else if (currDist + edgeWt == dist[adjNode]) {

                    ways[adjNode] =
                        (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
