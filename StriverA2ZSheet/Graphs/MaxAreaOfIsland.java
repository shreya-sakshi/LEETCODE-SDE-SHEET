class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
                if(grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea , dfs(i,j,grid));
                }
            }
        }

        return maxArea;

    }
    private int dfs(int ro , int co , int[][] grid)
    {
          if(ro < 0 || ro >= grid.length || co < 0 || co >= grid[0].length || grid[ro][co] == 0 )
          {
            return 0;
          }

          grid[ro][co] = 0;

          return 1 + dfs(ro+1 , co , grid)
                   + dfs(ro-1 , co , grid)
                   + dfs(ro , co +1 , grid)
                   + dfs(ro , co-1 , grid);
    }
}
