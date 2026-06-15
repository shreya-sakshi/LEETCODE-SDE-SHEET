package Graphs;

import java.util.ArrayList;

//DFS

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


