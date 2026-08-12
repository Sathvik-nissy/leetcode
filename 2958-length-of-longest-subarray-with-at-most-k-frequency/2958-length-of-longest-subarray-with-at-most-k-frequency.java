class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        int l=0;

            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int r = 0; r < n; r++) {
                int c = nums[r];
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                while(freq.get(c)>k){
                    freq.put(nums[l],freq.get(nums[l])-1);
                    l++;
                }

                ans=Math.max(ans,r-l+1);


            }
        
        return ans;
    }
}