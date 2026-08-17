class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int x=robb(nums,0,nums.length-2);
        int y=robb(nums,1,nums.length-1);
        return Math.max(x,y);
    }

    static int robb(int[]nums,int s,int e){
        int dp[]=new int[e-s+1];
        if(s==e)return nums[s];
        
        dp[0]=nums[s];
        dp[1]=Math.max(nums[s],nums[s+1]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],nums[s+i]+dp[i-2]);
        }
        return dp[dp.length-1];

    }
}