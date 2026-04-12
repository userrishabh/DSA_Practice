class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] res = new int[n+1];
        for(int j=0; j<trust.length; j++)
        {
            res[trust[j][0]]--;
            res[trust[j][1]]++;
        }

        for(int i=1; i<=n; i++)
            if(res[i] == n-1) return i;

        return -1;
    }
}