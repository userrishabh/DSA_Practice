class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int res = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                res = Math.max(res, dfs(grid, i, j));
            }
        }

        return res;
    }

    int dfs(int[][] grid, int i, int j)
    {
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int count = 1;

        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);
        return count;
    }
}
