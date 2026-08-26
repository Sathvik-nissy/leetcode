class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0, c = 0;
        String ans = "";

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '1') c++;
            while (c > k) {
                if (s.charAt(l) == '1') c--;
                l++;
            }
            while (c == k && l <= r && s.charAt(l) == '0') {
                l++;
            }

            if (c == k) {
                String cur = s.substring(l, r + 1);
                if (ans.isEmpty() ||
                    cur.length() < ans.length() ||
                    (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {
                    ans = cur;
                }
            }
        }

        return ans;
    }
}