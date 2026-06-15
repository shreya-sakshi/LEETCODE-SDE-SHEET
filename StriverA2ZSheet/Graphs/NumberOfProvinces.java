package Graphs;

import java.util.ArrayList;

class NumberOfProvinces {
    public void dfs(int node , ArrayList<ArrayList<Integer>> adjLs , int vis[])
    {
        vis[node] = 1;
        for(Integer it : adjLs.get(node))
        {
            if(vis[it] == 0)
            {
                dfs(it , adjLs , vis );
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();

        for(int i=0 ; i < n ; i++)
        {
            adjLs.add(new ArrayList<>());
        }

        
        for(int i=0 ; i < n ; i++)
        {
            for(int j=0 ; j < n ; j++)
            {
                if(isConnected[i][j] == 1 && i!=j)
                {
                     adjLs.get(i).add(j);
                     adjLs.get(j).add(i);
                }
            }
           
        }

        int vis[] = new int[n];
        int count = 0 ;

        for(int i=0 ; i < n ; i++)
        {
              if(vis[i] == 0)
              { 
                count ++;
                dfs(i, adjLs , vis);
              }
        }

        return count;
        
    }
}
