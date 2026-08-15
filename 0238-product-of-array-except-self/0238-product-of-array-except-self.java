class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans=new int[nums.length];
        int pre=1;
        int suff=1;
        ans[0]=pre;
        for(int i=1;i<nums.length;i++){
            pre=pre*nums[i-1];
            ans[i]=pre;
        }

        for(int i=nums.length-2;i>=0;i--){
            suff=suff*nums[i+1];
            ans[i]=ans[i]*suff;

        }
        return ans;



        
    }
}