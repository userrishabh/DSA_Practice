class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int arrLength = arr.length;
        int right = arrLength-k;
        ArrayList<Integer> resArray = new ArrayList<>();
        while(left<right)
        {
            int mid = left+(right-left)/2;
            if(x-arr[mid] > arr[mid+k]-x)
                left=mid+1;
            else
                right = mid;
        }
        for(int i=left; i<left+k; i++)
        {
            resArray.add(arr[i]);
        }
        return resArray;
    }
}