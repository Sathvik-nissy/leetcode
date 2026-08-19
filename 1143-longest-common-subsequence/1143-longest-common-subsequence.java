// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {

//         int n = text1.length();
//         int m = text2.length();

//         int j = 0;
//         int[] dp = new int[n];

//         for (int i = 0; i < n; i++) {

//             if (j < m && text1.charAt(i) == text2.charAt(j)) {

//                 if (i == 0) {
//                     dp[i] = 1;
//                 } else {
//                     dp[i] = dp[i - 1] + 1;
//                 }

//                 j++;

//             } else {

//                 if (i == 0) {
//                     dp[i] = 0;
//                 } else {
//                     dp[i] = dp[i - 1];
//                 }
//             }
//         }

//         return dp[n - 1];
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[n][m];
    }
}