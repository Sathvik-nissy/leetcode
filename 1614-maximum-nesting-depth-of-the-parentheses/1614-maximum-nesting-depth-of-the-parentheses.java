class Solution {
    public int maxDepth(String s) {
        int c=0,c1=0;
        for(int x:s.toCharArray()){
            if(x=='('){
                c++;
                c1=Math.max(c,c1);
            }else if(x==')'){
                c--;
            }
        }
        return c1;
        
    }
}