class Solution {
    public int longestSubsequence(int[] nums) {
        int xor1 = 0;

        for (int x : nums) {
            xor1 = xor1 ^ x;
        }

        if (xor1 != 0)
            return nums.length;

        for (int x : nums) {
            if (x != 0){
                return nums.length - 1;
            }
        }

        return 0;
    }
}