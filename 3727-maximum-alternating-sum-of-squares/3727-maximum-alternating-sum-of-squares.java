class Solution {
    public long maxAlternatingSum(int[] nums) {
        long n=nums.length;
        long res=n/2;
        long sum=0;
        long s2=0;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
            sum+=nums[i];
        }
        
        Arrays.sort(nums);

        for(int i=0;i<res;i++){
            s2+=nums[i];
        }

        return sum-2*s2;
        
    }
}