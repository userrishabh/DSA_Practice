class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] partitions = new int[k];
        
        int target = 0;

        for(int num : nums)
            target += num;
        if(target%k != 0) return false;
        Arrays.sort(nums);
        reverse(nums);

        return isEqualSumPartition(nums, target/k, partitions, k, 0);
    }

    boolean isEqualSumPartition(int[] nums, int target, int[] partitions, int partitionSize, int index)
    {

        if(nums.length == index)
        {
            for(int i=0; i<partitionSize; i++)
            {
                if(partitions[i] != target)
                    return false;
            }
            return true;
        }

        int tempNum = nums[index];

        for(int i=0; i<partitionSize; i++)
        {
            if(i>0 && partitions[i] == partitions[i-1]) continue;
            if(partitions[i]+tempNum <= target)
            {
                partitions[i] += tempNum;
                if(isEqualSumPartition(nums, target, partitions, partitionSize, index+1)) return true;
                partitions[i] -= tempNum;
            }
        }
        return false;
    }

    void reverse(int[] nums)
    {
        int l=0;
        int r=nums.length-1;

        while(l<r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}