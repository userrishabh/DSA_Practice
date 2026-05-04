class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] dist = new int[n+1];

        for(int i=0; i<n+1; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++)
        {
            int u = times[i][0]; int v = times[i][1]; int w = times[i][2];
            adj.get(u).add(new int[] {v, w});
        }
        minHeap.offer(new int[] {0, k});
        dist[k] = 0;

        while(!minHeap.isEmpty())
        {
            int[] data = minHeap.poll();
            int weight = data[0];
            int node = data[1];
            if(weight > dist[node]) continue;
            for(int[] v : adj.get(node))
            {
                int w = v[1];
                int tempNode = v[0];
                if(w+weight < dist[tempNode])
                {
                    dist[tempNode] = w+weight;
                    minHeap.offer(new int[] {w+weight, tempNode});
                }
            }
        }
        int resDist = 0;
        for(int i=1; i<n+1; i++)
        {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(dist[i] > resDist) resDist = dist[i];
        }

        return resDist;
    }
}
