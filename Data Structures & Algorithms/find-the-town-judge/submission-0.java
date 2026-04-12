class Solution {
    public int findJudge(int n, int[][] trust) {
        for(int i=1; i<=n; i++)
        {
            boolean isMatched = false;
            for(int j=0; j<trust.length; j++)
            {
                if(i == trust[j][0]) 
                {
                    isMatched = true;
                    break;
                }
            }

            if(!isMatched) return i;
        }

        return -1;
    }
}