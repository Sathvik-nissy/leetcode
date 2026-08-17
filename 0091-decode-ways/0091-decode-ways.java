class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        int dp[]=new int[s.length()];
        dp[0]=1;
        for(int i=1;i<s.length();i++){
            int two = (s.charAt(i - 1) - '0') * 10+ (s.charAt(i) - '0');
            if(s.charAt(i)!='0' ){
                dp[i]+=dp[i-1];

            }
            if(two>=10&&two<=26){
                if(i==1){
                    dp[i]+=1;
                }else{
                    dp[i]+=dp[i-2];
                }
            }


        }
        return dp[s.length()-1];
        
    }
}