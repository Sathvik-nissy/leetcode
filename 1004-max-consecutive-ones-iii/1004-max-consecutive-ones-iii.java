class Solution {
    public int longestOnes(int[] nums, int k) {
        int z=0,o=0,l=0,m=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                z++;
            }else{
                o++;
            }

            while(z>k){
                if(nums[l]==0){
                    z--;
                }else{
                    o--;
                }
                l++;
            }
            m=Math.max(m,r-l+1);

        }
        return m;

        
    }
}


















// import java.util.*;
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int cl=0,pl=0,ml=0,l=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==1){
//                 cl++;
//             }else{
//                 ml=Math.max(ml,cl+pl+k);
//                 pl=cl;
//                 cl=0;
//             }
//         }
//         ml=Math.max(ml,cl+pl+k);
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==1){
//                 l++;
//             }
//         }
//         if(l==nums.length){
//             ml=nums.length;
//         }
//         return ml;
    
//     }
// }