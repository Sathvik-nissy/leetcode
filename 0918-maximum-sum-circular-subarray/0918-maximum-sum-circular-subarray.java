class Solution { 
    public int maxSubarraySumCircular(int[] nums) { 
        int n = nums.length; 
 
        int sum = 0; 
        int max = nums[0]; 
        int min = nums[0]; 
        int currentMax = 0, currentMin = 0; 

        for(int i = 0; i < n; i++) { 

            currentMax = Math.max(nums[i], currentMax + nums[i]);
            max = Math.max(max, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            min = Math.min(min, currentMin);

            sum += nums[i]; 
        } 

        if(max < 0) { 
            return max; 
        } 

        int cimax = sum - min; 
        return Math.max(cimax, max); 
    } 
}