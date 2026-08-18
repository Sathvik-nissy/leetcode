class Solution {
    public boolean canPartition(int[] nums) {
        int  sum=0;
        for(int x:nums){
            sum=sum+x;
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        return knap(target,nums);    
    }

    // static boolean knap(int W, int wt[]) {
    //     int n=wt.length;
    //     boolean dp[][]=new boolean[n+1][W+1];
    //     for(int i=0;i<=n;i++){
    //         dp[i][0]=true;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=W;j++){
    //             if(j==0){
    //                 dp[i][j]=true;
    //             }else{
    //                 boolean p=false;
    //                 if(wt[i-1]<=j){
    //                     p=dp[i-1][j]||dp[i-1][j-wt[i-1]];
    //                 }
    //                 boolean np=dp[i-1][j];
    //                 dp[i][j]=np||p;
    //             }
                
    //         }
    //     }
    //     return dp[n][W];

    // }   


    static boolean knap( int target,int[] arr) {
        boolean dp[]=new boolean[target+1];
        dp[0]=true;
        for (int x : arr) {
            for (int j = target; j >= x; j--) {
                dp[j] = dp[j] || dp[j - x];
            }
        }
        return dp[target];
      
    }
}