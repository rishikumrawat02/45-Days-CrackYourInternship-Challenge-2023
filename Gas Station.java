class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int diff[] = new int[n];
        for(int i=0; i<n; i++) diff[i]=gas[i]-cost[i];
        int sum=0; int res=0;
        for(int i=0; i<n; i++){
            sum+=diff[i];
            if(sum<0){
                res=-1; sum=0;
            }else if(res==-1){
                res=i;
            }
        }
        if(res==-1) return res;
        sum=diff[res];
        for(int i=(res+1)%n; i!=res; i=(i+1)%n){
            sum+=diff[i];
            if(sum<0) return -1;
        }
        return res;
    }
}
