class Solution {
   class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = findUPar(parent[x]);
    }

    void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
    public int makeConnected(int n, int[][] connections) {

        DSU ds = new DSU(n);

        int cntExtras =0;
        int m = connections.length;

        for(int i=0; i<m ; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUPar(u) == ds.findUPar(v))
            {
                cntExtras++;
            }
            else
            {
                ds.unionBySize(u,v);
            }
        }
        int cntC=0;
        for(int i=0 ; i<n ; i++)
        {
            if(ds.findUPar(i) == i) cntC++;

        }
        int ans=cntC-1 ;
        if(cntExtras >= ans) return ans;
        return -1;

        
    }
}
