class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2,nums1);
        int lo = 0;
        int hi = nums1.length;
        int totalLength = (nums1.length + nums2.length + 1) / 2;

        while(lo <= hi)
        {
            int cut1 = lo + (hi-lo)/2;
            int cut2 = totalLength - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];

            int r1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1)
            {
                if((nums1.length + nums2.length)%2 == 1)
                {
                    return Math.max(l1,l2);
                }
                else
                {
                    double res = (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                    return res;
                }
            }
            else if(l1 > r2)
            {
                hi = cut1-1;
            }
            else
                lo = cut1+1;
        }

        return 0.0;
    }
}
