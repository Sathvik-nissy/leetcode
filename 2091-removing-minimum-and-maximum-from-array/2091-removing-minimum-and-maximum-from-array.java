class Solution {
    public int minimumDeletions(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int n = nums.length;

        int front = Math.max(minIdx, maxIdx) + 1;
        int back = n - Math.min(minIdx, maxIdx);
        int both = Math.min(minIdx, maxIdx) + 1 + n - Math.max(minIdx, maxIdx);

        return Math.min(front, Math.min(back, both));
    }
}