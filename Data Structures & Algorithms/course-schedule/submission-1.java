class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<>());
        
        for(int i=0; i<prerequisites.length; i++)
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] currStack = new boolean[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            if(!visited[i])
            {
                if(dfs(adj, visited, i, currStack)) return false;;   
            }
        }

        return true;
    }

    boolean dfs(List<List<Integer>> adj, boolean[] visited, int u, boolean[] currStack)
    {
        visited[u] = true;
        currStack[u] = true;
        for(int v : adj.get(u))
        {
            if(currStack[v]) return true;
            if(!visited[v])
                if(dfs(adj, visited, v, currStack)) return true;
        }

        currStack[u] = false;
        return false;
    }
}
