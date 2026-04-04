class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;

        for(int i=0; i<piles.length; i++)
        {
            if(piles[i]>maxSpeed)
                maxSpeed = piles[i];
        }

        int minSpeed = 1;

        while(minSpeed < maxSpeed)
        {
            int possibleCandidate = minSpeed + (maxSpeed-minSpeed)/2;

            long totalTimeTaken = 0;
            for(int i=0; i<piles.length; i++)
            {
                totalTimeTaken += Math.ceil((piles[i]+possibleCandidate-1)/possibleCandidate);
            }
            if(totalTimeTaken<=h)
                maxSpeed = possibleCandidate;
            else
                minSpeed = possibleCandidate+1;
        }

        return minSpeed;
    }
}
