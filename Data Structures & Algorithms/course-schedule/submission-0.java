class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 0;
        for(int i=0; i<prerequisites.length; i++)
            indegree[prerequisites[i][0]]++;
        for(int i=0; i<numCourses; i++)
        {
            if(indegree[i] == 0)
                {
                    dq.offer(i);
                    count++;
                }
        }

        while(!dq.isEmpty())
        {
            int u = dq.poll();

            for(int v=0; v<prerequisites.length; v++)
            {
                if(prerequisites[v][1] == u)
                {
                    indegree[prerequisites[v][0]]--;
                    if(indegree[prerequisites[v][0]] == 0)
                    {
                        dq.offer(prerequisites[v][0]);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
