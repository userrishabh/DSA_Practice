/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0;
        int hi = mountainArr.length() - 1;
        while(lo < hi)
        {
            int mid = lo + (hi-lo)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid+1))
                hi = mid;
            else
                lo = mid+1;
        }
        int peakIndex = lo;
        lo = 0;
        hi = peakIndex;
        while(lo <= hi)
        {
            int mid = lo + (hi-lo)/2;
            int element = mountainArr.get(mid);
            if(element == target)
                return mid;
            else if(element > target)
                hi = mid-1;
            else
                lo = mid+1;
        }
        lo = peakIndex+1;
        hi = mountainArr.length()-1;

        while(lo <= hi)
        {
            int mid = lo + (hi-lo)/2;
            int element = mountainArr.get(mid);
            if(element == target)
                return mid;
            else if(element > target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return -1;
    }
}