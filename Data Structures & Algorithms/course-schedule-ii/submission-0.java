class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] resArray = new int[numCourses];
        int d=0;
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++)
            res.add(new ArrayList<>());
        
        for(int i=0; i<prerequisites.length; i++)
        {
            res.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        for(int i=0; i<numCourses; i++)
        {
            if(inDegree[i] == 0)
            {
                dq.offer(i);
                resArray[d++] = i;
            }
        }

        while(!dq.isEmpty())
        {
            int u = dq.poll();

            for(int v : res.get(u))
            {
                inDegree[v]--;
                if(inDegree[v] == 0)
                {
                    dq.offer(v);
                    resArray[d++] = v;
                }
            }
        }
        return d == numCourses ? resArray : new int[0];
    }
}
