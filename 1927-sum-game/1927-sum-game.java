class Solution {
    public boolean sumGame(String s) {
        int s1=0,s2=0,c1=0,c2=0;
        int l=0,r=s.length()-1;
        while (l < r) {
        if (s.charAt(l) != '?'){
            s1 += s.charAt(l) - '0';
        }else{
            c1++;
        }
        if (s.charAt(r) != '?'){
            s2 += s.charAt(r) - '0';
        }else{
            c2++;
        }
        l++;
        r--;
        }

        if(c1+c2==0)return s1!=s2;

        if((c1+c2)%2!=0)return true;

        if(c1==c2)return s1!=s2;

        return 2 * (s1 - s2) != 9 * (c2 - c1);



    }
}