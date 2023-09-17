class Solution {
    public int minCost(String colors, int[] nT) {
        int res=0;
        int cnt=1; int sum=nT[0]; int max=nT[0];
        for(int i=1; i<colors.length(); i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                cnt++; sum+=nT[i]; max=Math.max(max,nT[i]);
            }else{
                if(cnt>1){
                    res+=(sum-max);
                }
                cnt=1; sum=nT[i]; max=nT[i];
            }
        }
        if(cnt>1){
            res+=(sum-max);
        }
        return res;
    }
}
