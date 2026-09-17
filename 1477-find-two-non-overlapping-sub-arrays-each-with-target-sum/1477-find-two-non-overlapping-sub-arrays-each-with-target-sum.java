// class Solution {
//     public int minSumOfLengths(int[] arr, int target) {
//         int n = arr.length;
//         int ans = Integer.MAX_VALUE;
//         int l = 0, sum = 0;
//         for (int r = 0; r < n; r++) {
//             sum += arr[r];
//             while (sum > target) {
//                 sum -= arr[l++];
//             }
//             if (sum == target) {
//                 int firstLen = r - l + 1;
//                 int secondLen = find(arr, r + 1, target);
//                 if (secondLen != Integer.MAX_VALUE) {
//                     ans = Math.min(ans, firstLen + secondLen);
//                 }
//             }
//         }
//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }

//     int find(int[] arr, int start, int target) {
//         int l = start, sum = 0;
//         int minLen = Integer.MAX_VALUE;
//         for (int r = start; r < arr.length; r++) {
//             sum += arr[r];
//             while (sum > target) {
//                 sum -= arr[l++];
//             }
//             if (sum == target) {
//                 minLen = Math.min(minLen, r - l + 1);
//             }
//         }
//         return minLen;
//     }
// }

class Solution {
    public int minSumOfLengths(int[] A, int k) {
        int n = A.length;
        int res = n + 1, sum = 0, i = 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        for (int j = 0; j < n; j++) {
            sum += A[j];

            while (sum > k)
                sum -= A[i++];

            dp[j + 1] = dp[j];

            if (sum == k) {
                dp[j + 1] = Math.min(dp[j], j - i + 1);
                res = Math.min(res, j - i + 1 + dp[i]);

            }
        }

        return res == n + 1 ? -1 : res;
    }
}