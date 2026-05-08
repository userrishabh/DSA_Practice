class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] directions = new int[][]
        {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };
        int row = heights.length;
        int col = heights[0].length;

        int[][] efforts = new int[row][col];
        for(int i=0; i<row; i++)
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[] {0, 0, 0});
        efforts[0][0] = 0;

        while(!minHeap.isEmpty())
        {
            int[] node = minHeap.poll();
            int effort = node[0];
            int r = node[1];
            int c = node[2];

            if(r == row-1 && c == col-1) return effort;
            if(effort > efforts[r][c]) continue;

            for(int[] d : directions)
            {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < row && nc >= 0 && nc < col)
                {
                    int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[r][c]));
                    if(newEffort < efforts[nr][nc])
                    {
                        efforts[nr][nc] = newEffort;
                        minHeap.offer(new int[] {newEffort, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}