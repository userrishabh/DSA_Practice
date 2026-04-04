class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int initialRange = 0;
        int maxRange = 0;
        for(int i=0; i<weights.length; i++)
        {
            if(weights[i]>initialRange)
                initialRange = weights[i];
            
            maxRange += weights[i];
        }

        while(initialRange < maxRange)
        {
            int possibleWeight = initialRange + (maxRange - initialRange) / 2;
            int sum = 0;
            int daysUsed = 1;
            for(int i=0; i<weights.length; i++)
            {
                if(sum+weights[i] <= possibleWeight)
                    sum += weights[i];
                else
                {
                    daysUsed++;
                    sum = weights[i];
                }
            }
            if(daysUsed <= days)
            {
                maxRange = possibleWeight;
            }
            else
                initialRange = possibleWeight+1;
        }

        return initialRange;
    }
}