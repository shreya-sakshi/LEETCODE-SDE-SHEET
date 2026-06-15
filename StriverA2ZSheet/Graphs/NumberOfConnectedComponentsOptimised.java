package Graphs;

import java.util.ArrayList;

//DFS
class NumberOfConnectedComponents {
    private void dfs(int node , ArrayList<ArrayList<Integer>> adjLs , int[] vis)
    {
        vis[node] = 1;

        for(Integer neighbour : adjLs.get(node))
        {
            if(vis[neighbour] == 0)
            {
                dfs(neighbour , adjLs , vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
         ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
         for(int i = 0 ; i < n ; i++)
         {
            adjLs.add(new ArrayList<>());
         }

         for(int[] edge : edges)
         {
            int u = edge[0];
            int v = edge[1];

            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
         }

         int vis[] = new int[n];
         int count = 0 ; 

         for(int i = 0 ; i< n ; i++)
         {
            if(vis[i] == 0)
            {
                count++;
                dfs(i , adjLs , vis);
            }
         }

         return count;
          
    }
}

//Optimised 

class Solution {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public void dfs(int node,boolean[] visited){
        visited[node]=true;
        for(int near:adj.get(node)){
            if(!visited[near]){
                dfs(near,visited);
            }
        }

    }
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){adj.add(new ArrayList<>());}
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                dfs(i,visited);
            }
        }
        return c;
    }
}


