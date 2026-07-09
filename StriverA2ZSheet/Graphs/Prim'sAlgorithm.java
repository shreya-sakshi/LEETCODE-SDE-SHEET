class Solution {
    class Pair
    {
        int node;
        int distance;
        Pair(int node , int distance)
        {
            this.node=node;
            this.distance=distance;
        }
    }
    public int spanningTree(int V, List<List<List<Integer>>> adj) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);

        int[] vis = new int [V];

        pq.add(new Pair(0,0));
        int sum =0;

        while(!pq.isEmpty())
        {
            int node = pq.peek().node;
            int wt = pq.peek().distance;
            pq.remove();

            if(vis[node] == 1) continue;

            vis[node] = 1;
            sum+=wt;

            for(int i=0; i < adj.get(node).size() ; i++)
            {
                 int adjnode = adj.get(node).get(i).get(0);
                 int adjwt = adj.get(node).get(i).get(1);
                 if(vis[adjnode] == 0)
                 {
                     pq.add(new Pair(adjnode,adjwt));
                 }
            }


        }

        return sum;

        
    }
}

