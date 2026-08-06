class Solution {
    public int smallestNumber(int n, int t) {
        int p=1;
        int res=n;
        while(n>0){
            int r=n%10;
            p=p*r;
            n=n/10;
        }
        if(p%t==0){
            return res;
        }else{
            return smallestNumber(res+1,t);
        }
        
    }
}