class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0;
        int l=0;
        int frq[]=new int[26];
        for(int r=0;r<s.length();r++){
            frq[s.charAt(r)-'a']++;
            while(frq[s.charAt(r)-'a']>2){
                frq[s.charAt(l)-'a']--;
                l++;
            }
            max=Math.max(max,r-l+1);

        }


        return max;
    }
}