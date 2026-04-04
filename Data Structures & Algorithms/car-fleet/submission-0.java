class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int arrLength = position.length;
        int noOfCarsFleet = 0;
        double max_so_far = -1;
        int[][] sortedByPositionWithGrouping = new int[arrLength][2];

        for(int i=0; i<arrLength; i++)
        {
            sortedByPositionWithGrouping[i][0] = position[i];
            sortedByPositionWithGrouping[i][1] = speed[i];
        }

        Arrays.sort(sortedByPositionWithGrouping, (a,b) -> b[0] - a[0]);

        for(int i=0; i<arrLength; i++)
        {
            int distanceFromTarget = target - sortedByPositionWithGrouping[i][0];
            double timeRemaining = (double) distanceFromTarget/sortedByPositionWithGrouping[i][1];
            if(timeRemaining>max_so_far)
            {
                max_so_far = timeRemaining;
                noOfCarsFleet++;
            }
        }

        return noOfCarsFleet;
    }
}
