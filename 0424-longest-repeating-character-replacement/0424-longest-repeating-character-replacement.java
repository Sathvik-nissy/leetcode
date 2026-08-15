class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, maxFreq = 0, ans = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(c));

            while ((r - l + 1) - maxFreq > k) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}