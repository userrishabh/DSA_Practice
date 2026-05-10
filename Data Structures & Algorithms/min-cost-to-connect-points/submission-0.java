class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        int len = points.length;
        for(int i=0; i<len; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<len; i++)
            for(int j=i+1; j<len; j++)
            {
                int xi = points[i][0], yi = points[i][1], xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xi-xj) + Math.abs(yi-yj);
                adj.get(i).add(new int[] {j, weight});
                adj.get(j).add(new int[] {i, weight});
            }
        
        boolean[] visited = new boolean[len];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[] {0,0});
        int sum = 0;

        while(!minHeap.isEmpty())
        {
            int[] node = minHeap.poll();
            int w = node[0];
            int u = node[1];

            if(visited[u]) continue;
            visited[u] = true;
            sum+=w;
            for(int[] v : adj.get(u))
            {
                int nv = v[0];
                int nw = v[1];

                if(!visited[nv])
                    minHeap.offer(new int[] {nw, nv});
            }
        }

        return sum;
    }
}
