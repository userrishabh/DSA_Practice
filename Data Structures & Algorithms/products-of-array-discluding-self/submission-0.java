class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        for(int i=0; i<nums.length; i++)
        {
            if(i==0)
                res[i]=1;
            else
                res[i]=nums[i-1]*res[i-1];
        }
        int tempNum = nums[nums.length-1];
        for(int i=nums.length-2; i>=0 ; i--)
        {
            res[i]=res[i]*tempNum;
            tempNum *= nums[i];
        }
        return res;
    }
}  
