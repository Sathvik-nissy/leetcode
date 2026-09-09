class Solution {
    public int countRotations(String s, int k) {
        int res = 0;
        String cur = s;

        for (int i = 0; i < s.length(); i++) {
            res += findadj(cur, k);
            cur = cur.substring(1) + cur.charAt(0);
        }
        return res;
    }

    static int findadj(String s, int k) {
        int c = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                c++;
        }

        if (c == k)
            return 1;
        else
            return 0;
    }
}