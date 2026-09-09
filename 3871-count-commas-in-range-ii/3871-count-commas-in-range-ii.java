class Solution {
    public long countCommas(long n) {
        long c=0;
        for(long i=1000;i<=n;i=i*1000){
            c=c+n-i+1;
        }
        return c;
        
    }
}