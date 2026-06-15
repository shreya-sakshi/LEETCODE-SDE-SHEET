package Graphs;

class Solution {
    private void dfs( int ro , int co , int[][] vis , char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        vis[ro][co] = 1;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i = 0 ; i < 4 ; i++)
        {
            int nrow = ro + drow[i];
            int ncol = co + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m
            && grid[nrow][ncol]== '1' && vis[nrow][ncol] == 0)
            {
                dfs(nrow , ncol , vis, grid);   
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0 ;

        for(int row = 0; row<n; row++)
        {
            for(int col = 0; col<m; col++)
            {
                if(vis[row][col] == 0 && grid[row][col] == '1')
                {
                    cnt++;
                    dfs(row , col , vis, grid);
                }
            }
        }
        return cnt;
        
    }
}
