class Solution {
    public boolean checkDivisibility(int n) {
        int s=0,p=1;
        int res=n;
        while(n>0){
            int r=n%10;
            s=s+r;
            p=p*r;
            n=n/10;
        }

        // if(res%(s+p)==0){
        //     return true;
        // }else{
        //      return false;
        // }
        return res%(s+p)==0;
        
    }
}