public int maxSubArray(int[] nums) 
    {
        int currentSum = nums[0];
        int maxSum = nums[0];
    
        for (int i = 1; i < nums.length; i++)
        {
            // keep track of the maximum sum obtained by adding the current element
            currSum = Math.max(nums[i], currSum + nums[i]);
            // This calculates the maxSum until now.
            maxSum = Math.max(maxSum, currSum);   
            
        }
        return maxSum;   
    }
