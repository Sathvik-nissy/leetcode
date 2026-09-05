class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int g[]=new int[nums.length];
        int s[]=new int[nums.length];
        int max=nums[0];
        int min=nums[nums.length-1];
        g[0]=max;
        s[nums.length-1]=min;
        for(int i=1;i<g.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            g[i]=max;
            
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<min){
                min=nums[i];
            }
            s[i]=min;   
        }

        int res=-1;
        for(int i=0;i<nums.length;i++){
            nums[i]=g[i]-s[i];
            if(nums[i]<=k){
                res=i;
                break;
            }
        }
        // for(int x:g){
        //     System.out.println(x+" ");
        // }
        // for(int x:s){
        //     System.out.println(x+" ");
        // }
        return res;
        
    }
}