class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int i=0;
        int j=0;
        while(i < m && j<n)
        {
            if(nums1[i] < nums2[j])
                {
                    res[i+j] = nums1[i];
                    i++;
                }
            else{
                res[i+j] = nums2[j];
                j++;
            }
        }
        while(i<m)
        {res[i+j] = nums1[i]; i++;}
        while(j<n)
        {
            res[i+j] = nums2[j];
            j++;
        }
        for(int data = 0; data<res.length; data++)
        {
            nums1[data] = res[data];
        }
    }
}