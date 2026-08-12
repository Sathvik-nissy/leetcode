class Solution {
    public int rob(int[] nums) {
    

        if (nums.length == 1)
            return nums[0];

        int case1 = rob1(nums, 1, nums.length - 1);
        int case2 = rob1(nums, 0, nums.length - 2);

        return Math.max(case1, case2);
    }

    static int rob1(int[] nums, int start, int end) {

        if (start == end)
            return nums[start];

        int[] dp = new int[end - start + 1];

        dp[0] = nums[start];

        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(
                dp[i - 1],
                nums[start + i] + dp[i - 2]
            );
        }

        return dp[dp.length - 1];
    }
}