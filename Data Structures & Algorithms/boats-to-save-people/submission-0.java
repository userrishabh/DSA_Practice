class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int leftPointer = 0;
        int rightPointer = people.length-1;
        int res = 0;
        while(leftPointer<=rightPointer)
        {
            int tempSum = people[leftPointer] + people[rightPointer];
            if(tempSum <= limit)
            {
                leftPointer++;
            }
            rightPointer--;
            res++;
        }
        return res;
    }
}