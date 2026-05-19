class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
    
        Deque<int[]> queue = new ArrayDeque<>();
        int totalFreshOranges = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                {
                    if(grid[i][j] == 2)
                        queue.offer(new int[] {i,j});
                    else if(grid[i][j] == 1)
                        totalFreshOranges++;
                }

        int totalMinutes = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            while(size-- > 0)
            {
                int[] indexes = queue.poll();
                int i = indexes[0];
                int j = indexes[1];

                for(int[] d : directions) {
                    
                    int ni = i+d[0];
                    int nj = j+d[1];

                    if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length 
                        && grid[ni][nj] == 1)
                    {
                        grid[ni][nj] = 2;
                        queue.offer(new int[] {ni,nj});
                        --totalFreshOranges;
                    }
                }
            }
            
            if(!queue.isEmpty()) totalMinutes++;
        }

        return totalFreshOranges == 0 ? totalMinutes : -1;
    }
}
