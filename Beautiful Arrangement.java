class Solution {
    int res=0;
    public int countArrangement(int n) {
        int mask=(1<<n)-1;
        helper(mask,1,n);
        return res;
    }

    void helper(int mask, int idx, int n){
        if(mask==0){
            res++;
            return;
        }
        for(int i=0; i<n; i++){
            if((mask&1<<i)!=0){
                int num=i+1;
                if(num%idx==0 || idx%num==0){
                    helper(mask^1<<i,idx+1,n);
                }
            }
        }
        return;
    }
}
