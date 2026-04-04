class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diffArray = new int[1001];

        for(int i=0; i<trips.length; i++)
        {
            int noOfPassenger = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            diffArray[from] += noOfPassenger;
            diffArray[to] -= noOfPassenger;
        }

        int curr = 0;
        for(int i =0; i<diffArray.length; i++)
        {
            curr += diffArray[i];

            if(curr > capacity)
                return false;
        }

        return true;
    }
}