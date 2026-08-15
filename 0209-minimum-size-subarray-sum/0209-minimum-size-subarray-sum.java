class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0,min=Integer.MAX_VALUE,l=0;
        for(int r=0;r<nums.length;r++){
            sum=sum+nums[r];
            while(sum>target){
                min=Math.min(min,r-l+1);
                sum=sum-nums[l];
                l++;
            }
            if(sum==target){
            min=Math.min(min,r-l+1);
            }
        }
        int k=(min==Integer.MAX_VALUE)?0:min;
        return k;
        
    }
}