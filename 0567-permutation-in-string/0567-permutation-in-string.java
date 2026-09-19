class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;

        int k=s1.length();
        for(int i1=0;i1<=s2.length()-k;i1++){
            //StringBuilder sb=new StringBuilder();

            String str=s2.substring(i1,i1+k);
            int frq[]=new int[26];
            for(int i=0;i<k;i++){
                frq[str.charAt(i)-'a']++;
                frq[s1.charAt(i)-'a']--;

            }
            boolean ok=true;
            for(int x:frq){
                if(x!=0){
                    ok=false;
                    break;
                }
            }
            if(ok)return true;

        }
        return false;
        
    }
}