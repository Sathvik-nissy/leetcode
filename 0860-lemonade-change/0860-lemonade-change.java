class Solution {
    public boolean lemonadeChange(int[] b) {
        if(b[0]!=5){
            return false;
        }
        int arr[]=new int[3];
        for(int i=0;i<b.length;i++){
            if(b[i]==5){
                arr[0]++;
            }
            if(b[i]==10){
                arr[1]++;
                arr[0]--;
                if(arr[0]<0){
                    return false;
                }
            }
if(b[i] == 20) {
    arr[2]++;
    if(arr[1] > 0 && arr[0] > 0) {
        arr[1]--;
        arr[0]--;
    } 
    else if(arr[0] >= 3) {
        arr[0] -= 3;
    } 
    else {
        return false;
    }
}

        }

        return true;
        
    }
}